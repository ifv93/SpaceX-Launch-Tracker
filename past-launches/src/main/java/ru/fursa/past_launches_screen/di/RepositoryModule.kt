package ru.fursa.past_launches_screen.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.fursa.past_launches_screen.data.PastLaunchRepositoryImpl
import ru.fursa.past_launches_screen.domain.PastLaunchRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
  @Binds
  abstract fun bindRepository(
    repository: PastLaunchRepositoryImpl
  ): PastLaunchRepository
}