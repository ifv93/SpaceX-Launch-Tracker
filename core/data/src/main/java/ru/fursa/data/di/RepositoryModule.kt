package ru.fursa.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.fursa.data.repository.past_launch.PastLaunchDataRepository
import ru.fursa.data.repository.past_launch.PastLaunchRepository
import ru.fursa.data.repository.upcoming_launches.UpcomingDataRepository
import ru.fursa.data.repository.upcoming_launches.UpcomingRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindPastLaunchRepository(
        repository: PastLaunchDataRepository
    ): PastLaunchRepository

    @Binds
    abstract fun bindUpcomingLaunchRepository(
        repository: UpcomingDataRepository
    ): UpcomingRepository


}