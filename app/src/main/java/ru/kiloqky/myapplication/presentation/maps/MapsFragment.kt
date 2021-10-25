package ru.kiloqky.myapplication.presentation.maps

import android.widget.Toast
import androidx.core.view.isVisible
import by.kirich1409.viewbindingdelegate.viewBinding
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import moxy.ktx.moxyPresenter
import ru.kiloqky.myapplication.R
import ru.kiloqky.myapplication.databinding.MapsFragmentBinding
import ru.kiloqky.myapplication.helpers.click
import ru.kiloqky.myapplication.helpers.visible
import ru.kiloqky.myapplication.model.geocoding.repository.GeocodingRepository
import ru.kiloqky.myapplication.navigation.cicerone.navigationcontroller.NavigationController
import ru.kiloqky.myapplication.presentation.abs.AbsFragment
import javax.inject.Inject

class MapsFragment : AbsFragment(R.layout.maps_fragment), MapsView {

    private val binding: MapsFragmentBinding by viewBinding()

    @Inject
    lateinit var geocodingRepository: GeocodingRepository

    @Inject
    lateinit var navigationController: NavigationController

    private val presenter: MapsPresenter by moxyPresenter {
        MapsPresenter(geocodingRepository, navigationController)
    }

    override fun addMapInputListener() {
        binding.mapview.map.addInputListener(presenter.inputListener)
    }

    override fun clearAllPlacemarks() {
        binding.mapview.map.mapObjects.clear()
    }

    override fun addPlacemark(point: Point) {
        binding.mapview.map.mapObjects.addPlacemark(point)
    }

    override fun showConfirmBtn() {
        if (!binding.btnConfirm.isVisible) binding.btnConfirm.visible()
    }

    override fun stopMap() {
        binding.mapview.onStop()
    }

    override fun startMap() {
        binding.mapview.onStart()
    }

    override fun initializeMap() {
        MapKitFactory.initialize(requireContext())
    }

    override fun showToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }

    override fun moveCamera(point: Point) {
        binding.mapview.map.move(CameraPosition(point, 14f, 0f, 0f))
    }

    override fun showAddress(address: String) {
        binding.btnConfirm.text = address
    }

    override fun initBtns(){
        binding.btnConfirm.click{
            presenter.confirm()
        }
    }

    companion object {
        fun newInstance() = MapsFragment()
    }
}