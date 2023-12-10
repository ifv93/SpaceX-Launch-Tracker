package ru.fursa.past_launches_screen.data

import ru.fursa.past_launches_screen.domain.PastLaunchRepository
import ru.fursa.service.SpaceXApiService
import javax.inject.Inject

class PastLaunchRepositoryImpl @Inject constructor(
  private val apiService: SpaceXApiService,
) : PastLaunchRepository {
  override suspend fun getPastLaunches(): List<Launch> {
    return apiService.getPast().map {
      Launch(
        flightNumber = it.flightNumber,
        missionName = it.missionName
      )
    }
  }
}