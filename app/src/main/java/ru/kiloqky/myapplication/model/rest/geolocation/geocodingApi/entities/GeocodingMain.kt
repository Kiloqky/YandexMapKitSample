package ru.kiloqky.myapplication.model.rest.geolocation.geocodingApi.entities

import com.google.gson.annotations.SerializedName

class GeocodingMain {
    @SerializedName("results")
    lateinit var results: ArrayList<Result>

    @SerializedName("plus_code")
    lateinit var plusCode: PlusCode
}