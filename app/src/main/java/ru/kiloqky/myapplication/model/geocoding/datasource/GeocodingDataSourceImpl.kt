package ru.kiloqky.myapplication.model.geocoding.datasource

import io.reactivex.rxjava3.core.Single
import ru.kiloqky.myapplication.config.Config
import ru.kiloqky.myapplication.helpers.GeocodeMapper
import ru.kiloqky.myapplication.model.rest.geolocation.geocodingApi.GeocodingAPI

class GeocodingDataSourceImpl(private val geocodingApi: GeocodingAPI): GeocodingDataSource {

    override fun getGeocode(latlng: String): Single<String> =
        geocodingApi.loadLocation(latlng, Config.GOOGLE_GEOCODING_API_KEY)
            .map(GeocodeMapper::map)
}