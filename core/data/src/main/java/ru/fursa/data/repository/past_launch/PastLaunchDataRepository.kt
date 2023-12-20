package ru.fursa.data.repository.past_launch

import ru.fursa.api.network.SpaceXApiService
import ru.fursa.data.cache.LaunchesMemoryCache
import ru.fursa.data.model.LaunchModel
import javax.inject.Inject

private const val LAUNCHES_CACHE_KEY = "past_launches"
class PastLaunchDataRepository @Inject constructor(
    private val apiService: SpaceXApiService,
    private val memoryCache: LaunchesMemoryCache
) : PastLaunchRepository {
    override suspend fun getPastLaunches(): List<LaunchModel> {
        return memoryCache[LAUNCHES_CACHE_KEY] ?: apiService.getPastLaunches().map {
            LaunchModel(
                flightNumber = it.flightNumber,
                missionName = it.missionName
            )
        }.also {
            memoryCache.set(key = LAUNCHES_CACHE_KEY, value = it)
        }
    }


}