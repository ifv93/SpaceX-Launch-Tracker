package ru.fursa.data.cache

import ru.fursa.common.Cache
import ru.fursa.common.MemoryCache
import ru.fursa.data.model.LaunchModel
import javax.inject.Singleton

@Singleton
class LaunchesMemoryCache: Cache<List<LaunchModel>> by MemoryCache()