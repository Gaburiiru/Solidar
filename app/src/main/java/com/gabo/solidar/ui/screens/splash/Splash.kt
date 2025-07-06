package com.gabo.solidar.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gabo.solidar.R
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

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.icon_solidar),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier.size(200.dp), // opcional
        )
        /* Spacer(modifier = Modifier.height(8.dp)) // reduce o ajusta el espacio
        Text(
            text = "SOLIDAR",
            style = MaterialTheme.typography.titleLarge,
        ) */
    }
}
