package ru.fursa.service

import retrofit2.http.GET
import ru.fursa.response.LaunchResponse

interface SpaceXApiService {

  @GET("launches/past")
  suspend fun getPast(): List<LaunchResponse>
}