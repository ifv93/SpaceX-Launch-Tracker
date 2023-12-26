package ru.fursa.past_screeen.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.fursa.past_screeen.domain.use_case.GetPastLaunchesUseCase
import ru.fursa.past_screeen.domain.use_case.PastLaunchesUseCase

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {
    @Binds
    abstract fun bindGetPastLaunchUseCase(
        getPastLaunchesUseCase: GetPastLaunchesUseCase,
    ): PastLaunchesUseCase
}