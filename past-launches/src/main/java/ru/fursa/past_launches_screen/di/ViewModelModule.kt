package ru.fursa.past_launches_screen.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.fursa.past_launches_screen.domain.PastLaunchRepository
import ru.fursa.past_launches_screen.presentation.PastLaunchesViewModel
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ViewModelModule {
    @Provides
    @Singleton
    fun provideViewModel(repository: PastLaunchRepository): PastLaunchesViewModel {
        return PastLaunchesViewModel(
            repository = repository
        )
    }
}