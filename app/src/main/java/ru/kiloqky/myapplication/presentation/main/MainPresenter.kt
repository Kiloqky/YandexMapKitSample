package ru.kiloqky.myapplication.presentation.main

import moxy.MvpPresenter
import ru.kiloqky.myapplication.navigation.cicerone.MainAppNavigator
import ru.kiloqky.myapplication.navigation.cicerone.navigationcontroller.NavigationController

class MainPresenter(private val navigationController: NavigationController) :
    MvpPresenter<MainView>() {
    fun openRootScreen() {
        navigationController.openRootScreen()
    }

    fun setNavigator(navigator: MainAppNavigator) {
        navigationController.setNavigator(navigator)
    }

    fun removeNavigator() {
        navigationController.removeNavigator()
    }

}