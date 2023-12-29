package ru.fursa.launch_card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun LaunchCard(
    missionName: String,
    flightNumber: Int,
    missionLogoUrl: String,
    missionDate: String,
    launchSite: String,
    isAlreadyCompleted: Boolean = false,
    isRocketFailed: Boolean = false,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(all = 3.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Box(modifier = modifier.size(40.dp)) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(missionLogoUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(CircleShape)
                )

            }

            Column {
                Text(
                    text = missionName,
                    style = TextStyle(
                        fontFamily = RobotoGoogleFonts,
                        fontWeight = FontWeight.Medium
                    )
                )
                Text(text = launchSite, style = TextStyle(
                    fontFamily = RobotoGoogleFonts,
                    fontWeight = FontWeight.Normal
                ))
                Text(text = missionDate, style = TextStyle(
                    fontFamily = RobotoGoogleFonts,
                    fontWeight = FontWeight.Normal
                ))
            }

            Column(
                modifier = modifier.fillMaxWidth().padding(end = 8.dp),
                horizontalAlignment = Alignment.End
            ) {
                Text(text = "#$flightNumber", style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = RobotoGoogleFonts,
                    fontWeight = FontWeight.Light
                ))
                Spacer(modifier = Modifier.size(6.dp))
                if (isAlreadyCompleted) {
                    CompleteIndicator(
                        modifier = Modifier.size(10.dp),
                        isRocketFailed = isRocketFailed
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewLaunchCard() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LaunchCard(
            missionName = "FalconSat 1",
            flightNumber = 1,
            isAlreadyCompleted = true,
            isRocketFailed = true,
            launchSite = "Cape Canaveral",
            missionLogoUrl = "https://www.usafa.edu/app/uploads/Falcon-SAT-1.png",
            missionDate = "10 october 2006"
        )

        LaunchCard(
            missionName = "FalconSat 2",
            flightNumber = 1,
            isAlreadyCompleted = false,
            launchSite = "Cape Canaveral",
            missionLogoUrl = "https://www.usafa.edu/app/uploads/Falcon-SAT-1.png",
            missionDate = "10 october 2006"
        )
    }
}