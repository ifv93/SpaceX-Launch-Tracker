package ru.fursa.past_screeen.domain.use_case

import kotlinx.coroutines.flow.Flow
import ru.fursa.api.request.NetworkRequest
import ru.fursa.data.model.LaunchModel

interface PastLaunchesUseCase {
    operator fun invoke(): Flow<NetworkRequest<List<LaunchModel>>>
}