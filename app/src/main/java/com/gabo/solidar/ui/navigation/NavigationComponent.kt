package com.gabo.solidar.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.gabo.solidar.data.MockPosts
import com.gabo.solidar.data.MockProjects
import com.gabo.solidar.ui.screens.discover.Discover
import com.gabo.solidar.ui.screens.home.Home
import com.gabo.solidar.ui.screens.home.PostDetails
import com.gabo.solidar.ui.screens.login.Login
import com.gabo.solidar.ui.screens.login.Register
import com.gabo.solidar.ui.screens.post.Post
import com.gabo.solidar.ui.screens.proyect.ProjectDetails
import com.gabo.solidar.ui.screens.proyect.Proyect
import com.gabo.solidar.ui.screens.splash.Splash
import com.gabo.solidar.ui.screens.userProfile.EditUserProfile
import com.gabo.solidar.ui.screens.userProfile.UserProfile

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun NavigationComponent(
    navigationController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val postMock = MockPosts.entries.map { it.toPostModel() }
    val projectMock = MockProjects.entries.map { it.toProjectModel() }

    NavHost(
        navController = navigationController,
        startDestination = NavigationRoutes.Splash.route,
        modifier = modifier,
    ) {
        composable(NavigationRoutes.Splash.route) {
            Splash(navController = navigationController)
        }
        composable(NavigationRoutes.Home.route) {
            Home(posts = postMock, navController = navigationController)
        }
        composable(NavigationRoutes.UserProfile.route) {
            UserProfile(navController = navigationController)
        }

        composable(NavigationRoutes.EditUserProfile.route) {
            EditUserProfile(navController = navigationController)
        }

        composable(NavigationRoutes.Proyect.route) {
            Proyect(projectMock, navController = navigationController)
        }
        composable(NavigationRoutes.Post.route) {
            Post(navController = navigationController)
        }
        composable(NavigationRoutes.Login.route) {
            Login(navController = navigationController)
        }
        composable(NavigationRoutes.Register.route) {
            Register(navController = navigationController)
        }
        composable(NavigationRoutes.Discover.route) {
            Discover(projectMock, navController = navigationController)
        }
        composable(
            NavigationRoutes.ProjectDetails.route + "/{projectId}",
            arguments = listOf(navArgument("projectId") { type = NavType.LongType }),
        ) { backStackEntry ->
            val projectId = backStackEntry.arguments?.getLong("projectId")
            ProjectDetails(
                projectId = projectId,
                navController = navigationController,
            )
        }
        composable(NavigationRoutes.PostDetails.route) {
            PostDetails(
                navController = navigationController,
            )
        }
    }
}
