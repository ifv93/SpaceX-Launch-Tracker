package ru.fursa.past_launches_screen.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun LaunchCard(
    modifier: Modifier = Modifier,
    title: String,
    flightNumber: Int,
) {
    Column(modifier = modifier.padding(all = 16.dp)) {
        Text(text = "#$flightNumber", fontWeight = FontWeight.Bold)
        Text(text = title, fontWeight = FontWeight.Medium)
    }
}