package ru.fursa.response

import com.google.gson.annotations.SerializedName

data class LaunchResponse(
  @SerializedName("flight_number")
  val flightNumber: Int,
  @SerializedName("mission_name")
  val missionName: String,
)