package ru.fursa.spacex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.fursa.spacex.ui.navigation.MainApp
import ru.fursa.spacex.ui.theme.SpaceXTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            SpaceXTheme {
                MainApp(navController = navController)
            }
        }
    }
}


