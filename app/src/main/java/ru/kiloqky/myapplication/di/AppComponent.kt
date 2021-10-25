package ru.kiloqky.myapplication.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ru.kiloqky.myapplication.App
import ru.kiloqky.myapplication.navigation.cicerone.navigationcontroller.NavigationController
import ru.kiloqky.myapplication.scheduler.Schedulers
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivitiesUiModule::class,
        FragmentUiModule::class,
        GeocodingModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withNavigationController(
            navigationController: NavigationController
        ): Builder

        @BindsInstance
        fun withSchedulers(schedulers: Schedulers): Builder

        fun build(): AppComponent

    }
}