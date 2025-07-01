package com.gabo.solidar.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gabo.solidar.data.MockPosts
import com.gabo.solidar.ui.screens.discover.Discover
import com.gabo.solidar.ui.screens.home.Home
import com.gabo.solidar.ui.screens.login.Login
import com.gabo.solidar.ui.screens.login.Register
import com.gabo.solidar.ui.screens.post.Post
import com.gabo.solidar.ui.screens.proyect.Proyect
import com.gabo.solidar.ui.screens.splash.Splash
import com.gabo.solidar.ui.screens.userProfile.UserProfile

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun NavigationComponent(
    navigationController: NavHostController,
    modifier: Modifier = Modifier,
) {

    val postMock = MockPosts.entries.map { it.toPostModel() }

    NavHost(
        navController = navigationController,
        startDestination = NavigationRoutes.Splash.route,
        modifier = modifier,
    ) {
        composable(NavigationRoutes.Splash.route) {
            Splash(navController = navigationController)
        }
        composable(NavigationRoutes.Home.route) {
            Home(post = postMock)
        }
        composable(NavigationRoutes.UserProfile.route) {
            UserProfile()
        }
        composable(NavigationRoutes.Proyect.route) {
            Proyect()
        }
        composable(NavigationRoutes.Post.route) {
            Post()
        }
        composable(NavigationRoutes.Login.route) {
            Login(navController = navigationController)
        }
        composable(NavigationRoutes.Register.route) {
            Register(navController = navigationController)
        }
        composable(NavigationRoutes.Discover.route) {
            Discover()
        }
    }
}
