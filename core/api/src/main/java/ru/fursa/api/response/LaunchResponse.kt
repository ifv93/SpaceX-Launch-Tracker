package ru.fursa.api.response

import com.google.gson.annotations.SerializedName

data class LaunchResponse(
    @SerializedName("flight_number")
    val flightNumber: Int,
    @SerializedName("name")
    val missionName: String,
)