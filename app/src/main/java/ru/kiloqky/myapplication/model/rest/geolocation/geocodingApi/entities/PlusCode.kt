package ru.kiloqky.myapplication.model.rest.geolocation.geocodingApi.entities

import com.google.gson.annotations.SerializedName

class PlusCode {
    @SerializedName("compound_code")
    lateinit var compound: String
}
