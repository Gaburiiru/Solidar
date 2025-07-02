package com.gabo.solidar.ui.screens.main

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gabo.solidar.ui.components.BottomBar
import com.gabo.solidar.ui.navigation.NavigationComponent
import com.gabo.solidar.ui.navigation.NavigationRoutes

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun Main() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        contentWindowInsets = WindowInsets(0),
        bottomBar = {
            if (currentRoute != NavigationRoutes.Splash.route &&
                currentRoute != NavigationRoutes.Login.route &&
                currentRoute != NavigationRoutes.Register.route
            ) {
                BottomBar(controller = navController)
            }
        },
        modifier = Modifier.fillMaxSize(),
    ) { paddingValue ->
        NavigationComponent(
            navigationController = navController,
            modifier = Modifier.padding(paddingValue),
        )
    }
}
