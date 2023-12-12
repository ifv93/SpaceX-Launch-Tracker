package ru.fursa.spacex.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp(navController: NavHostController) {
    Scaffold(
        topBar = {},
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) {
        NavigationGraph(navController = navController)
    }
}