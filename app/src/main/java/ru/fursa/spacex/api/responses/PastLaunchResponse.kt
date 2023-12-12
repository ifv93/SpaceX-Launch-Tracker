package ru.fursa.spacex.api.responses

import com.google.gson.annotations.SerializedName


data class PastLaunchResponse(
    @SerializedName("flight_number") val flightNumber: Int? = 0,
    @SerializedName("name") val missionName: String? = "",
)
