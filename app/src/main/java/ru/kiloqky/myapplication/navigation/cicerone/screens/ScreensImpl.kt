package ru.kiloqky.myapplication.navigation.cicerone.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.kiloqky.myapplication.presentation.info.InfoFragment
import ru.kiloqky.myapplication.presentation.maps.MapsFragment
import ru.kiloqky.myapplication.presentation.start.StartFragment

class ScreensImpl : Screens {
    override fun StartScreen() = FragmentScreen {
        StartFragment.newInstance()
    }

    override fun MapsScreen() = FragmentScreen {
        MapsFragment.newInstance()
    }

    override fun InfoScreen(lat: String, long: String, address: String) = FragmentScreen {
        InfoFragment.newInstance(lat, long, address)
    }

}