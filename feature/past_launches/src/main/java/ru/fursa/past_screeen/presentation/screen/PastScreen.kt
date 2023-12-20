package ru.fursa.past_screeen.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ru.fursa.past_screeen.presentation.PastScreenViewState

@Composable
fun PastScreen(
    modifier: Modifier = Modifier,
    viewState: PastScreenViewState,
    onLoad: () -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(start = 6.dp, end = 6.dp)
            .background(Color.White),
    ) {

        when {
            viewState.loading -> Box(contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }

            viewState.error -> Box(contentAlignment = Alignment.Center) {
                Text(text = viewState.errorMessage)
            }

            else -> {
                LazyColumn(contentPadding = PaddingValues(all = 6.dp), content = {
                    items(viewState.data) {
                        Column(
                            modifier = modifier.fillMaxWidth().padding(all = 6.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(text = "#${it.flightNumber}")
                            Text(text = it.missionName.orEmpty(), style = TextStyle(fontWeight = FontWeight.Medium))
                        }
                    }
                })
            }
        }
    }

    LaunchedEffect(key1 = Unit, block = {
        onLoad()
    })
}