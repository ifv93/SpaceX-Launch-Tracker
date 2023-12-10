package ru.fursa.past_launches_screen.presentation

import ru.fursa.past_launches_screen.data.Launch

data class PastScreenState(
  val isLoading: Boolean = false,
  val isError: Boolean = false,
  val error: String = "",
  val data: List<Launch> = emptyList(),
)
