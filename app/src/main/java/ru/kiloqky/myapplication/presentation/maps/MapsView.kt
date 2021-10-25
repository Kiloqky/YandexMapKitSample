package ru.kiloqky.myapplication.presentation.maps

import com.yandex.mapkit.geometry.Point
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MapsView: MvpView {
    fun stopMap()
    fun startMap()
    fun initializeMap()
    fun showToast(text: String)
    fun moveCamera(point: Point)
    fun showAddress(address: String)
    fun addPlacemark(point: Point)
    fun clearAllPlacemarks()
    fun showConfirmBtn()
    fun addMapInputListener()
    fun initBtns()
}