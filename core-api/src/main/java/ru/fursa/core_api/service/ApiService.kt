package ru.fursa.core_api.service

import retrofit2.http.GET
import ru.fursa.core_api.response.PastLaunchResponse

interface ApiService {
    @GET("launches/past")
    suspend fun getPastLaunches(): List<PastLaunchResponse>
}