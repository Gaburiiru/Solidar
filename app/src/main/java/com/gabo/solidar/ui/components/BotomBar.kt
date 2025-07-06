package com.gabo.solidar.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.gabo.solidar.ui.navigation.NavigationRoutes
import com.gabo.solidar.ui.theme.BackgroundBlue
import com.gabo.solidar.ui.theme.BackgroundColor

@Composable
fun BottomBar(controller: NavHostController) {
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val navItemColors =
        NavigationBarItemColors(
            selectedIconColor = MaterialTheme.colorScheme.primary,
            selectedTextColor = MaterialTheme.colorScheme.secondary,
            disabledIconColor = MaterialTheme.colorScheme.primary,
            disabledTextColor = MaterialTheme.colorScheme.primary,
            selectedIndicatorColor = MaterialTheme.colorScheme.tertiary,
            unselectedIconColor = MaterialTheme.colorScheme.primary,
            unselectedTextColor = MaterialTheme.colorScheme.primary,
        )
    NavigationBar(
        containerColor = BackgroundColor
    ) {
        NavigationBarItem(
            selected = navBackStackEntry?.destination?.hierarchy?.any { it.route == NavigationRoutes.Home.route } == true,
            onClick = { controller.navigate(NavigationRoutes.Home.route) },
            colors = navItemColors,
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = NavigationRoutes.Home.route,
                )
            },
        )
        NavigationBarItem(
            selected = navBackStackEntry?.destination?.hierarchy?.any { it.route == NavigationRoutes.Discover.route } == true,
            onClick = { controller.navigate(NavigationRoutes.Discover.route) },
            colors = navItemColors,
            icon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = NavigationRoutes.Discover.route,
                )
            },
        )
        NavigationBarItem(
            selected = navBackStackEntry?.destination?.hierarchy?.any { it.route == NavigationRoutes.Post.route } == true,
            onClick = { controller.navigate(NavigationRoutes.Post.route) },
            colors = navItemColors,
            icon = {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = NavigationRoutes.Post.route,
                )
            },
        )
        NavigationBarItem(
            selected = navBackStackEntry?.destination?.hierarchy?.any { it.route == NavigationRoutes.Proyect.route } == true,
            onClick = { controller.navigate(NavigationRoutes.Proyect.route) },
            colors = navItemColors,
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = NavigationRoutes.Proyect.route,
                )
            },
        )
        NavigationBarItem(
            selected = navBackStackEntry?.destination?.hierarchy?.any { it.route == NavigationRoutes.UserProfile.route } == true,
            onClick = { controller.navigate(NavigationRoutes.UserProfile.route) },
            colors = navItemColors,
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = NavigationRoutes.UserProfile.route,
                )
            },
        )
    }
}
