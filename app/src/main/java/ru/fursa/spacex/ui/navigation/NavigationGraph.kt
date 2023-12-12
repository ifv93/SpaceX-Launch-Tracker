package ru.fursa.spacex.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.fursa.spacex.features.past.PastLaunchesViewModel
import ru.fursa.spacex.features.past.PastScreen
import ru.fursa.spacex.features.upcoming.UpcomingScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Upcoming.route) {
       composable(route = "upcoming") {
           UpcomingScreen()
       }
       composable(route = "past") {
           val viewModel = hiltViewModel<PastLaunchesViewModel>()
           val viewState = viewModel.viewState.collectAsState()
           PastScreen(
               viewState = viewState.value,
               onLoad = { viewModel.loadData() }
           )
       }
    }
}