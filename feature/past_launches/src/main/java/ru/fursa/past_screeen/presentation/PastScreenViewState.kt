package ru.fursa.past_screeen.presentation

import ru.fursa.data.model.LaunchModel
import ru.fursa.past_screeen.domain.model.PastLaunchModel

sealed class PastLaunchesState {
    object Idle: PastLaunchesState()
    object Loading: PastLaunchesState()
    data class Success(val data: List<LaunchModel>): PastLaunchesState()
    data class Error(val message: String): PastLaunchesState()
}