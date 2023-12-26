package ru.fursa.common

sealed class Routes constructor(val routeName: String = "") {
    object PastLaunchesScreen : Routes(routeName = "past_launches_screen")
    object UpcomingLaunchesScreen : Routes(routeName = "upcoming_launches_screen")
}