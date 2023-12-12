package ru.fursa.spacex.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.fursa.spacex.features.PastScreen
import ru.fursa.spacex.features.UpcomingScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Upcoming.route) {
       composable(route = "upcoming") {
           UpcomingScreen()
       }
       composable(route = "past") {
           PastScreen()
       }
    }
}