package ru.kiloqky.myapplication.presentation.maps

import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.location.Location
import com.yandex.mapkit.location.LocationListener
import com.yandex.mapkit.location.LocationStatus
import com.yandex.mapkit.map.InputListener
import com.yandex.mapkit.map.Map
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import moxy.MvpPresenter
import ru.kiloqky.myapplication.model.geocoding.repository.GeocodingRepository
import ru.kiloqky.myapplication.navigation.cicerone.navigationcontroller.NavigationController

class MapsPresenter(
    private val geocodingRepository: GeocodingRepository,
    private val navigationController: NavigationController
) : MvpPresenter<MapsView>() {
    private fun getMapKit() = MapKitFactory.getInstance()

    val inputListener: InputListener = object : InputListener {
        override fun onMapTap(map: Map, point: Point) {
            viewState.clearAllPlacemarks()
            viewState.addPlacemark(point)
            savePointAndCheckoutAddress(point)
            viewState.showConfirmBtn()
        }

        override fun onMapLongTap(p0: Map, p1: Point) {}
    }

    private val locationListener = object : LocationListener {
        override fun onLocationUpdated(location: Location) {
            viewState.moveCamera(location.position)
        }

        override fun onLocationStatusUpdated(status: LocationStatus) {}
    }

    private var userPoint = Point()
    private var userAddress: String = ""
    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initializeMap()
        getMapKit().onStart()
        viewState.startMap()
        viewState.addMapInputListener()
        viewState.initBtns()
    }

    override fun attachView(view: MapsView?) {
        super.attachView(view)
        showUserLocation()
    }

    private fun showUserLocation() {
        val locationManager = getMapKit().createLocationManager()
        locationManager.requestSingleUpdate(locationListener)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewState.stopMap()
        getMapKit().onStop()
    }

    fun savePointAndCheckoutAddress(point: Point) {
        userPoint = point
        disposables +=
            geocodingRepository.getAddress("${point.latitude},${point.longitude}")
                .subscribe(::saveAddress, ::showThrow)
    }

    private fun saveAddress(address: String) {
        viewState.showAddress(address)
        userAddress = address
    }

    private fun showThrow(t: Throwable) {
        t.message?.let { viewState.showToast(it) }
    }

    fun confirm() {
        navigationController.openInfoScreen(
            userPoint.latitude.toString(),
            userPoint.longitude.toString(),
            userAddress
        )
    }

}