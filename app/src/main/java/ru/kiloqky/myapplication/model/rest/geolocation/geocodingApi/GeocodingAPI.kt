package ru.kiloqky.myapplication.model.rest.geolocation.geocodingApi

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.kiloqky.myapplication.model.rest.geolocation.geocodingApi.entities.GeocodingMain

interface GeocodingAPI {
    @GET("maps/api/geocode/json")
    fun loadLocation(
        @Query("latlng") latlng: String,
        @Query("key") key: String
    ): Single<GeocodingMain>
}