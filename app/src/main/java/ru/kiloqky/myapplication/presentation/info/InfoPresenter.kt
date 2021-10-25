package ru.kiloqky.myapplication.presentation.info

import moxy.MvpPresenter

class InfoPresenter: MvpPresenter<InfoView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showInfo()
    }
}