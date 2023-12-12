package ru.fursa.spacex.features.past

import ru.fursa.spacex.api.responses.PastLaunchResponse

data class PastScreenViewState(
    val loading: Boolean = false,
    val data: List<PastLaunchResponse> = emptyList(),
    val error: Boolean = false,
    val errorMessage: String = ""
)