package ru.kiloqky.myapplication.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.kiloqky.myapplication.model.geocoding.datasource.GeocodingDataSource
import ru.kiloqky.myapplication.model.geocoding.datasource.GeocodingDataSourceImpl
import ru.kiloqky.myapplication.model.geocoding.repository.GeocodingRepository
import ru.kiloqky.myapplication.model.geocoding.repository.GeocodingRepositoryImpl
import ru.kiloqky.myapplication.model.rest.geolocation.geocodingApi.GeocodingAPI
import ru.kiloqky.myapplication.scheduler.Schedulers
import javax.inject.Singleton

@Module
object GeocodingModule {

    @Provides
    @Singleton
    fun provideApi(): GeocodingAPI = Retrofit.Builder()
        .baseUrl("https://maps.googleapis.com/")
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GeocodingAPI::class.java)

    @Provides
    fun provideGeocodingDataSource(api: GeocodingAPI): GeocodingDataSource =
        GeocodingDataSourceImpl(api)

    @Provides
    fun provideGeocodingRepository(geocodingDataSource: GeocodingDataSource, schedulers: Schedulers): GeocodingRepository =
        GeocodingRepositoryImpl(geocodingDataSource, schedulers)
}