package ru.fursa.past_screeen.domain.model

data class PastLaunchModel(
    val flightNumber: Int,
    val missionName: String,
    val logoUrl: String,
    val launchSite: String,
    val isRocketFailed: Boolean = false,
)