package ru.fursa.data.repository.past_launch

import kotlinx.coroutines.flow.Flow
import ru.fursa.data.model.LaunchModel

interface PastLaunchRepository {
    suspend fun loadPastLaunches(): List<LaunchModel>
}