package ru.fursa.past_screeen.presentation

import ru.fursa.past_screeen.domain.model.PastLaunchModel

data class PastScreenViewState(
    val loading: Boolean = false,
    val data: List<PastLaunchModel> = emptyList(),
    val error: Boolean = false,
    val errorMessage: String = ""
)