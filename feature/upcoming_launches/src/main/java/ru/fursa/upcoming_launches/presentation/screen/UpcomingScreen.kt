package ru.fursa.upcoming_launches.presentation.screen

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
import ru.fursa.launch_card.LaunchCard
import ru.fursa.upcoming_launches.presentation.UpcomingScreenViewState

@Composable
fun UpcomingScreen(
    modifier: Modifier = Modifier,
    viewState: UpcomingScreenViewState,
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
                LazyColumn(
                    modifier = modifier.fillMaxSize(),
                    contentPadding = PaddingValues(all = 6.dp),
                    content = {
                        items(viewState.data) {
                            LaunchCard(
                                missionName = it.missionName,
                                flightNumber = it.flightNumber,
                                missionLogoUrl = it.logoUrl,
                                missionDate = it.missionDate,
                                launchSite = it.launchSite
                            )
                        }
                    })
            }
        }
    }

    LaunchedEffect(key1 = Unit, block = {
        onLoad()
    })
}