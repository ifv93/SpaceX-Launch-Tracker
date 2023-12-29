package ru.fursa.launch_card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CompleteIndicator(
    isRocketFailed: Boolean = false,
    modifier: Modifier = Modifier,
) {
    if (isRocketFailed) {
        Box(
            modifier = modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Colors.RedColor),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                tint = Color.White,
                painter = painterResource(id = R.drawable.round_close_24),
                contentDescription = ""
            )
        }
    } else {
        Box(
            modifier = modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Colors.GreenColor),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                tint = Color.White,
                painter = painterResource(id = R.drawable.round_done_24),
                contentDescription = ""
            )
        }
    }
}

@Preview
@Composable
fun PreviewCompleteIndicator() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(all = 40.dp)
    ) {
        CompleteIndicator(isRocketFailed = false)
        Spacer(modifier = Modifier.size(40.dp))
        CompleteIndicator(isRocketFailed = true)
    }
}