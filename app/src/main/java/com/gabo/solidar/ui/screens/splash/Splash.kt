package com.gabo.solidar.ui.screens.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.gabo.solidar.ui.navigation.NavigationRoutes
import kotlinx.coroutines.delay

@Composable
fun Splash(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate(NavigationRoutes.Login.route) {
            popUpTo(NavigationRoutes.Splash.route) { inclusive = true }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Cargando...")
    }
}
