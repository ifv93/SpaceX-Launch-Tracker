package ru.fursa.data.repository.past_launch

import ru.fursa.api.network.SpaceXApiService
import ru.fursa.data.cache.LaunchesMemoryCache
import ru.fursa.data.model.LaunchModel
import javax.inject.Inject
import javax.inject.Named

private const val LAUNCHES_CACHE_KEY = "past_launches"
class PastLaunchDataRepository @Inject constructor(
    private val apiService: SpaceXApiService,
    @Named("past_launches") private val memoryCache: LaunchesMemoryCache
) : PastLaunchRepository {
    override suspend fun getPastLaunches(): List<LaunchModel> {
        return memoryCache[LAUNCHES_CACHE_KEY] ?: apiService.getPastLaunches().map {
            LaunchModel(
                flightNumber = it.flightNumber,
                missionName = it.missionName,
                launchSite = (it.launchSite?.siteNameLong ?: it.launchSite?.siteNameShort).orEmpty(),
                logoUrl = it.links.missionPatchSmall.orEmpty(),
                launchDate = "10 october 2006",
                isRocketFailed = it.isRocketFailed
            )
        }.also {
            memoryCache.set(key = LAUNCHES_CACHE_KEY, value = it)
        }
    }


}