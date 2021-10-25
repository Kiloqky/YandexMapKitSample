package ru.kiloqky.myapplication.model.geocoding.datasource

import io.reactivex.rxjava3.core.Single

interface GeocodingDataSource {
    fun getGeocode(latlng: String): Single<String>
}