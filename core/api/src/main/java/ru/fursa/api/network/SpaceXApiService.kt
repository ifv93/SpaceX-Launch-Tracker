package ru.fursa.api.network

import retrofit2.http.GET
import ru.fursa.api.response.LaunchResponse

interface SpaceXApiService {
    @GET("launches/past")
    suspend fun getPastLaunches(): List<LaunchResponse>
}