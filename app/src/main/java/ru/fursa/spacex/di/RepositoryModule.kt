package ru.fursa.spacex.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.fursa.past_screeen.domain.LaunchRepository
import ru.fursa.spacex.data.LaunchRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindLaunchRepository(repositoryImpl: LaunchRepositoryImpl): LaunchRepository
}