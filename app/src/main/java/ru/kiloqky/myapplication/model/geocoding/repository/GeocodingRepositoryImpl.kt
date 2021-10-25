package ru.kiloqky.myapplication.model.geocoding.repository

import io.reactivex.rxjava3.core.Single
import ru.kiloqky.myapplication.model.geocoding.datasource.GeocodingDataSource
import ru.kiloqky.myapplication.scheduler.Schedulers

class GeocodingRepositoryImpl(private val geocodingDataSource: GeocodingDataSource,val schedulers: Schedulers) : GeocodingRepository {
    override fun getAddress(latlng: String): Single<String> =
        geocodingDataSource.getGeocode(latlng)
            .subscribeOn(schedulers.background())
            .observeOn(schedulers.main())
}