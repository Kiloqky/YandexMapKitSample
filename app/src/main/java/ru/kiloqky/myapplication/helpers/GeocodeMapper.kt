package ru.kiloqky.myapplication.helpers

import ru.kiloqky.myapplication.model.rest.geolocation.geocodingApi.entities.GeocodingMain

object GeocodeMapper {

    fun map(geocodingMain: GeocodingMain) =
        geocodingMain.results[0].address

}