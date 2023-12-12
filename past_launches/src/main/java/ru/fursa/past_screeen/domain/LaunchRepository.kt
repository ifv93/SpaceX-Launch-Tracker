package ru.fursa.past_screeen.domain

import ru.fursa.past_screeen.model.PastLaunchModel

interface LaunchRepository {
    suspend fun loadPastLaunches(): List<PastLaunchModel>
}