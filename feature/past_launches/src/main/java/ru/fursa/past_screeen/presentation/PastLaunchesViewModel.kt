package ru.fursa.past_screeen.presentation

import android.util.Log
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.fursa.api.request.NetworkRequest
import ru.fursa.data.model.LaunchModel
import ru.fursa.data.repository.past_launch.PastLaunchRepository
import ru.fursa.past_screeen.domain.model.PastLaunchModel
import ru.fursa.past_screeen.domain.use_case.GetPastLaunchesUseCase
import ru.fursa.past_screeen.domain.use_case.PastLaunchesUseCase
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class PastLaunchesViewModel @Inject constructor(
    private val getPastLaunchesUseCase: PastLaunchesUseCase,
) : ViewModel() {

    private val _viewState = MutableStateFlow<PastLaunchesState>(PastLaunchesState.Idle)
    val viewState = _viewState.asStateFlow()

    fun loadData() {
        getPastLaunchesUseCase()
            .onEach { requestState ->
                when (requestState) {
                    is NetworkRequest.Loading -> _viewState.value = PastLaunchesState.Loading
                    is NetworkRequest.Success -> _viewState.value =
                        PastLaunchesState.Success(requestState.data ?: emptyList())

                    is NetworkRequest.Error -> _viewState.value =
                        PastLaunchesState.Error(requestState.message.orEmpty())
                }
            }
            .launchIn(viewModelScope)
    }
}