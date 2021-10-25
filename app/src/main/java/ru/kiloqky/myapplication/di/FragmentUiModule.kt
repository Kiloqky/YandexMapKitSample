package ru.kiloqky.myapplication.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.kiloqky.myapplication.presentation.info.InfoFragment
import ru.kiloqky.myapplication.presentation.maps.MapsFragment
import ru.kiloqky.myapplication.presentation.start.StartFragment

@Module
abstract class FragmentUiModule {

    @ContributesAndroidInjector
    abstract fun bindStartFragment(): StartFragment

    @ContributesAndroidInjector
    abstract fun bindMapsFragment(): MapsFragment

    @ContributesAndroidInjector
    abstract fun bindInfoFragment(): InfoFragment
}