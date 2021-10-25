package ru.kiloqky.myapplication.navigation.cicerone.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen

interface Screens {
    fun StartScreen(): FragmentScreen
    fun MapsScreen(): FragmentScreen
    fun InfoScreen(lat: String, long: String, address: String): FragmentScreen
}