package ru.fursa.upcoming_launches

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.fursa.data.repository.upcoming_launches.UpcomingRepository
import ru.fursa.upcoming_launches.domain.UpcomingLaunchModel
import ru.fursa.upcoming_launches.presentation.UpcomingScreenViewState
import javax.inject.Inject

@HiltViewModel
class UpcomingViewModel @Inject constructor(
    private val repository: UpcomingRepository,
) : ViewModel() {

    private val _viewState = MutableStateFlow(UpcomingScreenViewState())
    val viewState = _viewState.asStateFlow()

    fun loadData() {
        viewModelScope.launch {
            _viewState.update { it.copy(loading = true) }
            try {
                val data = repository.getUpcomingLaunches().map {
                    UpcomingLaunchModel(
                        flightNumber = it.flightNumber,
                        missionName = it.missionName
                    )
                }
                _viewState.update { it.copy(loading = false, data = data) }
            } catch (e: Exception) {
                _viewState.update {
                    it.copy(
                        error = true,
                        loading = false,
                        errorMessage = e.message.toString()
                    )
                }
            }
        }
    }

}