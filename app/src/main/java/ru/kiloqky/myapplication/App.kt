package ru.kiloqky.myapplication

import androidx.appcompat.app.AppCompatDelegate
import com.github.terrakok.cicerone.Cicerone
import com.yandex.mapkit.MapKitFactory
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.kiloqky.gb.rickandmortymvp.scheduler.DefaultSchedulers
import ru.kiloqky.myapplication.config.Config
import ru.kiloqky.myapplication.di.AppComponent
import ru.kiloqky.myapplication.di.DaggerAppComponent
import ru.kiloqky.myapplication.navigation.cicerone.navigationcontroller.NavigationControllerImpl
import ru.kiloqky.myapplication.navigation.cicerone.screens.ScreensImpl

class App : DaggerApplication() {

    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        instance = this
        MapKitFactory.setApiKey(Config.YANDEX_MAPKIT_KEY)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent
            .builder()
            .withContext(applicationContext)
            .apply {
                val cicerone = Cicerone.create()
                withNavigationController(
                    NavigationControllerImpl(
                        cicerone.getNavigatorHolder(),
                        cicerone.router,
                        ScreensImpl()
                    )
                )
            }
            .withSchedulers(DefaultSchedulers())
            .build()

}