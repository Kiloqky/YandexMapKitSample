package ru.kiloqky.myapplication.navigation.cicerone.navigationcontroller

import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import ru.kiloqky.myapplication.navigation.cicerone.MainAppNavigator
import ru.kiloqky.myapplication.navigation.cicerone.screens.Screens

class NavigationControllerImpl(
    private val navigatorHolder: NavigatorHolder,
    private val router: Router,
    private val screens: Screens
) : NavigationController {
    override fun openRootScreen() {
        router.newRootScreen(screens.StartScreen())
    }

    override fun removeNavigator() {
        navigatorHolder.removeNavigator()
    }

    override fun setNavigator(navigator: MainAppNavigator) {
        navigatorHolder.setNavigator(navigator)
    }

    override fun openMapScreen() {
        router.navigateTo(screens.MapsScreen())
    }

    override fun openInfoScreen(lat: String, long: String, address: String) {
        router.navigateTo(screens.InfoScreen(lat, long, address))
    }
}