package ru.fursa.spacex.data

import ru.fursa.past_screeen.domain.LaunchRepository
import ru.fursa.past_screeen.model.PastLaunchModel
import ru.fursa.spacex.api.SpaceXApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LaunchRepositoryImpl @Inject constructor(
    private val apiService: SpaceXApiService,
): LaunchRepository {
    override suspend fun loadPastLaunches() = apiService.fetchPast().map { response ->
        PastLaunchModel(
            flightNumber = response.flightNumber ?: 0,
            missionName = response.missionName.orEmpty()
        )
    }
}