package ru.kiloqky.myapplication.helpers

import ru.kiloqky.myapplication.BuildConfig

fun checkIsDebug(unit: () -> Unit){
    if (BuildConfig.DEBUG){
        unit.invoke()
    }
}