package ru.fursa.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.fursa.data.cache.LaunchesMemoryCache
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideMemoryCache() = LaunchesMemoryCache()
}