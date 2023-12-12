package ru.fursa.spacex.api

import retrofit2.http.GET
import ru.fursa.spacex.api.responses.PastLaunchResponse

interface SpaceXApiService {
    @GET("launches/past")
    suspend fun fetchPast(): List<PastLaunchResponse>
}