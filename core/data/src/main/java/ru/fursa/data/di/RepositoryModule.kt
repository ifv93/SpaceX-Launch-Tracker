package ru.fursa.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.fursa.data.repository.past_launch.PastLaunchDataRepository
import ru.fursa.data.repository.past_launch.PastLaunchRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindPastLaunchRepository(
        repository: PastLaunchDataRepository
    ): PastLaunchRepository

}