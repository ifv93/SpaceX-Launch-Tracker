package ru.fursa.past_launches_screen.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.fursa.past_launches_screen.presentation.components.LaunchCard
import ru.fursa.past_launches_screen.presentation.components.SearchBar
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PastLaunchesScreen(
    viewModel: PastLaunchesViewModel = viewModel(),
    modifier: Modifier = Modifier,
) {
    val searchText = remember { mutableStateOf("") }
    val viewState = viewModel.viewState.collectAsState()

    Column(modifier = Modifier.padding(all = 16.dp)) {
        SearchBar(onSearch = { }, onClose = { })
        Spacer(modifier = Modifier.size(16.dp))
        LazyColumn(content = {
            items(viewState.value.data) {
                LaunchCard(
                    title = it.missionName,
                    flightNumber = it.flightNumber
                )
            }
        })
    }
}
