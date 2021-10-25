package ru.kiloqky.myapplication.navigation.cicerone.navigationcontroller

import ru.kiloqky.myapplication.navigation.cicerone.MainAppNavigator

interface NavigationController {
    fun openRootScreen()
    fun removeNavigator()
    fun setNavigator(navigator:MainAppNavigator)
    fun openMapScreen()
    fun openInfoScreen(lat: String, long: String, address: String)
}