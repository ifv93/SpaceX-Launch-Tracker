package ru.fursa.spacex.ui.navigation

import androidx.annotation.DrawableRes
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.fursa.spacex.R

sealed class BottomNavItem(
    val route: String,
    @DrawableRes val icon: Int,
    @DrawableRes val selectedIcon: Int,
    val label: String,
) {
    object Upcoming :
        BottomNavItem(
            route = "upcoming",
            icon = R.drawable.ic_done,
            selectedIcon = R.drawable.ic_done_selected,
            label = "Upcoming"
        )

    object Past : BottomNavItem(
        route = "past",
        icon = R.drawable.ic_next,
        selectedIcon = R.drawable.ic_next_selected,
        label = "past"
    )
}

@Composable
fun BottomNavigationBar(navController: NavController) {

    val items = listOf(
        BottomNavItem.Upcoming,
        BottomNavItem.Past
    )

    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route)
                },
                icon = {
                    if (item.route == currentRoute) {
                        Icon(
                            painterResource(id = item.selectedIcon),
                            contentDescription = item.label
                        )
                    } else {
                        Icon(painterResource(id = item.icon), contentDescription = item.label)
                    }
                })
        }
    }
}

