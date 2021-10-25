package ru.kiloqky.myapplication.presentation.start

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface StartView : MvpView {
    fun requestPermissions()
    fun initBtns()
}