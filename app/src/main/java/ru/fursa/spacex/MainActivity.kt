package ru.fursa.spacex

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import dagger.hilt.android.AndroidEntryPoint
import ru.fursa.core_api.service.ApiService
import ru.fursa.spacex.ui.theme.SpaceXTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceXTheme {
                LaunchedEffect(key1 = Unit, block = {
                    apiService.getPastLaunches().forEach { launch ->
                        Log.d("SpaceX Main", launch.toString())
                    }
                })
            }
        }
    }
}


