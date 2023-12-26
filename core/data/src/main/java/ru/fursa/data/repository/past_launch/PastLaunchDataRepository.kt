package ru.fursa.data.repository.past_launch

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.update
import ru.fursa.api.network.SpaceXApiService
import ru.fursa.data.cache.LaunchesMemoryCache
import ru.fursa.data.model.LaunchModel
import javax.inject.Inject
import javax.inject.Named

private const val LAUNCHES_CACHE_KEY = "past_launches"

class PastLaunchDataRepository @Inject constructor(
    private val apiService: SpaceXApiService,
    @Named("past_launches") private val memoryCache: LaunchesMemoryCache,
) : PastLaunchRepository {

    override suspend fun loadPastLaunches(): List<LaunchModel> {
        val resultData = memoryCache[LAUNCHES_CACHE_KEY] ?: apiService.getPastLaunches().map { response ->
            LaunchModel(
                flightNumber = response.flightNumber,
                missionName = response.missionName
            )
        }.also { launches ->
            memoryCache[LAUNCHES_CACHE_KEY] = launches
        }

        return resultData
    }
}