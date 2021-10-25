package ru.kiloqky.myapplication.presentation.start

import moxy.MvpPresenter
import ru.kiloqky.myapplication.navigation.cicerone.navigationcontroller.NavigationController

class StartPresenter(private val navigationController: NavigationController): MvpPresenter<StartView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.requestPermissions()
        viewState.initBtns()
    }

    fun openMap(){
        navigationController.openMapScreen()
    }
}