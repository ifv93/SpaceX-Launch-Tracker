package ru.fursa.upcoming_launches.domain

data class UpcomingLaunchModel(
    val flightNumber: Int,
    val missionName: String,
    val logoUrl: String,
    val launchSite: String,
    val missionDate: String,
)
