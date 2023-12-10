package ru.fursa.past_launches_screen.domain

import ru.fursa.past_launches_screen.data.Launch

interface PastLaunchRepository {
  suspend fun getPastLaunches(): List<Launch>
}