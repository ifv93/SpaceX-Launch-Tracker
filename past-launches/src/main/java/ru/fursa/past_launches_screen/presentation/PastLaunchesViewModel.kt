package ru.fursa.past_launches_screen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.fursa.past_launches_screen.domain.PastLaunchRepository
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class PastLaunchesViewModel @Inject constructor(
    val repository: PastLaunchRepository
) : ViewModel() {
    private val _viewState = MutableStateFlow(PastScreenState())
    val viewState = _viewState.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                _viewState.update { it.copy(isLoading = true) }
                val launches = repository.getPastLaunches()
                if (launches.isNotEmpty()) {
                    _viewState.update { it.copy(isLoading = false, data = launches) }
                }
            } catch (e: Exception) {
                _viewState.update { it.copy(isError = true, error = e.localizedMessage.toString()) }
            }

        }
    }
}