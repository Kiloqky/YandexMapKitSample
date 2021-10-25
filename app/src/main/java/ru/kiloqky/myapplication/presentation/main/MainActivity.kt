package ru.kiloqky.myapplication.presentation.main

import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.ktx.moxyPresenter
import ru.kiloqky.myapplication.R
import ru.kiloqky.myapplication.databinding.ActivityMainBinding
import ru.kiloqky.myapplication.navigation.cicerone.MainAppNavigator
import ru.kiloqky.myapplication.navigation.cicerone.navigationcontroller.NavigationController
import ru.kiloqky.myapplication.presentation.abs.AbsActivity
import javax.inject.Inject

class MainActivity : AbsActivity(R.layout.activity_main), MainView {

    @Inject
    lateinit var navigationController: NavigationController

    private val binding: ActivityMainBinding by viewBinding()

    private val presenter: MainPresenter by moxyPresenter {
        MainPresenter(navigationController)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?: presenter.openRootScreen()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        presenter.setNavigator(MainAppNavigator(this, R.id.container))
    }

    override fun onPause() {
        presenter.removeNavigator()
        super.onPause()
    }
}