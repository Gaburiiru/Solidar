package com.gabo.solidar.ui.navigation

sealed class NavigationRoutes(
    val route: String,
) {
    object Splash : NavigationRoutes("Splash")

    object Home : NavigationRoutes("Home")

    object Proyect : NavigationRoutes("Proyect")

    object ProjectDetails : NavigationRoutes("ProjectDetails")

    object UserProfile : NavigationRoutes("UserProfile")

    object EditUserProfile : NavigationRoutes("EditUserProfile")

    object Login : NavigationRoutes("Login")

    object Register : NavigationRoutes("Register")

    object Post : NavigationRoutes("Post")

    object Discover : NavigationRoutes("Discover")

    object PostDetails : NavigationRoutes("PostDetails")
}
