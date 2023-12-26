package ru.fursa.past_screeen.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ru.fursa.data.model.LaunchModel
import ru.fursa.past_screeen.domain.model.PastLaunchModel

@Composable
fun ListView(
    modifier: Modifier = Modifier,
    data: List<LaunchModel>
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(all = 6.dp),
        content = {
            items(data) { launchModel ->
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(all = 6.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "#${launchModel.flightNumber}")
                    Text(
                        text = launchModel.missionName,
                        style = TextStyle(fontWeight = FontWeight.Medium)
                    )
                }
            }
        })
}