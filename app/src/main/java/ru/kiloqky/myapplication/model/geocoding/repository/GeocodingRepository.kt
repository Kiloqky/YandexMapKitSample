package ru.kiloqky.myapplication.model.geocoding.repository

import io.reactivex.rxjava3.core.Single

interface GeocodingRepository {
    /**
     * @param latlng Format: lat,long
     */
    fun getAddress(latlng: String): Single<String>
}