package ru.fursa.spacex.data

import ru.fursa.spacex.api.SpaceXApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LaunchRepository @Inject constructor(
    private val apiService: SpaceXApiService,
) {
    suspend fun loadPastLaunches() = apiService.fetchPast()
}