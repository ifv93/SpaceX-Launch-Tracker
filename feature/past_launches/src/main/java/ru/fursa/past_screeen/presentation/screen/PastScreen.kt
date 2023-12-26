package ru.fursa.past_screeen.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.fursa.past_screeen.presentation.PastLaunchesState
import ru.fursa.search_bar.SearchBar

@Composable
fun PastScreen(
    modifier: Modifier = Modifier,
    viewState: PastLaunchesState,
    onLoad: () -> Unit,
    onSearchTextChanged: (String) -> Unit,
    onSearchBarCloseClicked: () -> Unit,
) {

    Column {
        SearchBar(
            onTextChanged = onSearchTextChanged,
            onCloseClicked = onSearchBarCloseClicked,
            onSearchClicked = { }
        )
        Column(modifier = modifier.fillMaxSize()) {
            when (viewState) {
                is PastLaunchesState.Loading -> BoxContainer {
                    CircularProgressIndicator()
                }

                is PastLaunchesState.Success -> {
                    ListView(data = viewState.data)
                }

                is PastLaunchesState.Error -> BoxContainer(
                    modifier = modifier.padding(all = 8.dp)
                ) {
                    Text(text = viewState.message)
                }
                else -> Unit
            }
        }
    }

    LaunchedEffect(key1 = Unit, block = {
        onLoad()
    })
}