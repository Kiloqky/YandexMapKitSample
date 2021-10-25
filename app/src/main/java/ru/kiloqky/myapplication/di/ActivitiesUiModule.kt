package ru.kiloqky.myapplication.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.kiloqky.myapplication.presentation.main.MainActivity

@Module
abstract class ActivitiesUiModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}