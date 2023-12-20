package ru.fursa.data.repository.past_launch

import ru.fursa.data.model.LaunchModel

interface PastLaunchRepository {
    suspend fun getPastLaunches(): List<LaunchModel>
}