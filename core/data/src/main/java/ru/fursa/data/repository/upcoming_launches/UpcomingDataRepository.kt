package ru.fursa.data.repository.upcoming_launches

import ru.fursa.api.network.SpaceXApiService
import ru.fursa.data.cache.LaunchesMemoryCache
import ru.fursa.data.model.LaunchModel
import javax.inject.Inject
import javax.inject.Named

private const val LAUNCHES_CACHE_KEY = "upcoming_launches_key"
class UpcomingDataRepository @Inject constructor(
    private val apiService: SpaceXApiService,
    @Named("upcoming_launches") private val memoryCache: LaunchesMemoryCache,
) : UpcomingRepository {
    override suspend fun getUpcomingLaunches(): List<LaunchModel> {
        return memoryCache[LAUNCHES_CACHE_KEY] ?: apiService.getUpcomingLaunches().map {
            LaunchModel(
                flightNumber = it.flightNumber,
                missionName = it.missionName,
                launchDate = "",
                launchSite = (it.launchSite?.siteNameLong ?: it.launchSite?.siteNameShort).orEmpty(),
                logoUrl = it.links.missionPatchSmall
            )
        }.also {
            memoryCache.set(key = LAUNCHES_CACHE_KEY, value = it)
        }
    }
}