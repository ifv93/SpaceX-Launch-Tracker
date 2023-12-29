package ru.fursa.data.model

data class LaunchModel(
    val flightNumber: Int,
    val missionName: String,
    val logoUrl: String? = null,
    val launchDate: String,
    val launchSite: String,
    val isRocketFailed: Boolean = false,
)
