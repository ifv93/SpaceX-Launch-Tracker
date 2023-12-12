package ru.fursa.past_screeen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.fursa.past_screeen.domain.LaunchRepository
import javax.inject.Inject

@HiltViewModel
class PastLaunchesViewModel @Inject constructor(
    private val repository: LaunchRepository,
) : ViewModel() {

    private val _viewState = MutableStateFlow(PastScreenViewState())
    val viewState = _viewState.asStateFlow()

    fun loadData() {
        viewModelScope.launch {
            _viewState.update { it.copy(loading = true) }
            try {
                val data = repository.loadPastLaunches()
                _viewState.update { it.copy(loading = false, data = data) }
            } catch (e: Exception) {
                _viewState.update { it.copy(error = true, errorMessage = e.message.orEmpty()) }
            }
        }
    }
}