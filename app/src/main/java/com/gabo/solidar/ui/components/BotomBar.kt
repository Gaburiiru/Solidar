package com.gabo.solidar.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.gabo.solidar.ui.navigation.NavigationRoutes

@SuppressLint("SuspiciousIndentation")
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
    Surface(
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        modifier = Modifier.shadow(elevation = 24.dp, shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
        color = Color.White,
    ) {
        NavigationBar(
            containerColor = Color.Transparent, // ya se lo da el Surface
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
}
