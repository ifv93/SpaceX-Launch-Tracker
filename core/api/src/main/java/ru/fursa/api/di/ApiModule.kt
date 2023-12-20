package ru.fursa.api.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.fursa.api.network.SpaceXApiService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideRetrofit() = Retrofit.Builder()
        .baseUrl("https://api.spacexdata.com/v4/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit) = retrofit.create(SpaceXApiService::class.java)
}