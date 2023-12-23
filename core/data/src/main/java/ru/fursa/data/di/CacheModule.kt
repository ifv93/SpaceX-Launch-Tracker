package ru.fursa.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.fursa.data.cache.LaunchesMemoryCache
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Provides
    @Named("upcoming_launches")
    fun provideUpcomingMemoryCache() = LaunchesMemoryCache()

    @Provides
    @Named("past_launches")
    fun providePastMemoryCache() = LaunchesMemoryCache()
}