package ru.fursa.data.repository.upcoming_launches

import ru.fursa.data.model.LaunchModel

interface UpcomingRepository {
    suspend fun getUpcomingLaunches(): List<LaunchModel>
}