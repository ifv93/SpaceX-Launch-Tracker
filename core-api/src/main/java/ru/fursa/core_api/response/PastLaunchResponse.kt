package ru.fursa.core_api.response

import com.google.gson.annotations.SerializedName

data class PastLaunchResponse(
    @SerializedName("flight_number")
    val flightNumber: Int,
    @SerializedName("mission_name")
    val flightTitle: String,
)