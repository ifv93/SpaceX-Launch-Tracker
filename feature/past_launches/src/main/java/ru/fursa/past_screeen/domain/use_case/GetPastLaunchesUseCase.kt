package ru.fursa.past_screeen.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.fursa.api.request.NetworkRequest
import ru.fursa.data.model.LaunchModel
import ru.fursa.data.repository.past_launch.PastLaunchRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetPastLaunchesUseCase @Inject constructor(
    private val repository: PastLaunchRepository
): PastLaunchesUseCase {
    override operator fun invoke(): Flow<NetworkRequest<List<LaunchModel>>> = flow {
        try {
            emit(NetworkRequest.Loading())
            val launchesResponse = repository.loadPastLaunches()
            emit(NetworkRequest.Success(launchesResponse))
        } catch (e: Exception) {
            emit(NetworkRequest.Error(e.message.toString()))
        }
    }
}