package ru.fursa.upcoming_launches.presentation

import ru.fursa.upcoming_launches.domain.UpcomingLaunchModel

data class UpcomingScreenViewState(
    val loading: Boolean = false,
    val data: List<UpcomingLaunchModel> = emptyList(),
    val error: Boolean = false,
    val errorMessage: String = ""
)
