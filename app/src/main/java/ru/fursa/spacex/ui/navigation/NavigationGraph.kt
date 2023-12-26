package ru.fursa.spacex.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.fursa.common.Routes
import ru.fursa.past_screeen.presentation.PastLaunchesViewModel
import ru.fursa.past_screeen.presentation.screen.PastScreen
import ru.fursa.upcoming_launches.UpcomingViewModel
import ru.fursa.upcoming_launches.presentation.screen.UpcomingScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Routes.UpcomingLaunchesScreen.routeName) {

        composable(route = Routes.UpcomingLaunchesScreen.routeName) {
            val viewModel = hiltViewModel<UpcomingViewModel>()
            val viewState = viewModel.viewState.collectAsState()

            UpcomingScreen(
                viewState = viewState.value,
                onLoad = { viewModel.loadData() }
            )
        }

        composable(route = Routes.PastLaunchesScreen.routeName) {
            val viewModel = hiltViewModel<PastLaunchesViewModel>()
            val viewState = viewModel.viewState.collectAsState()

            PastScreen(
                viewState = viewState.value,
                onLoad = { viewModel.loadData() },
                onSearchTextChanged = { },
                onSearchBarCloseClicked = { viewModel.loadData() }
            )
        }
    }
}
