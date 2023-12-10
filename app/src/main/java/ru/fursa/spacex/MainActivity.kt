package ru.fursa.spacex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import dagger.hilt.android.AndroidEntryPoint
import ru.fursa.past_launches_screen.presentation.PastLaunchesScreen
import ru.fursa.past_launches_screen.presentation.PastLaunchesViewModel
import ru.fursa.spacex.ui.theme.SpaceXTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PastLaunchesScreen()
        }
    }
}


