package com.example.kalikasapp.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kalikasapp.ui.theme.navigation.landing_screens.AppBenchmarkScreen
import com.example.kalikasapp.ui.theme.navigation.landing_screens.AppLoginScreen
import com.example.kalikasapp.ui.theme.navigation.landing_screens.AppMainScreen
import com.example.kalikasapp.ui.theme.navigation.landing_screens.AppSignupScreen
import com.example.kalikasapp.ui.theme.navigation.landing_screens.PageProfileScreen
import com.example.kalikasapp.ui.theme.navigation.signup_screens.SignupStudentScreen
import com.example.kalikasapp.ui.theme.navigation.profile_utilscreens.ProfileSettingsScreen

// a reusable Composable for navigating screens
// can insert multiple Composables
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.AppMainScreen.route) {

        // Main KalikasApp landing screen
        composable(route = Screen.AppMainScreen.route) {
            AppMainScreen(navController = navController)
        }

        // Signup screens
        composable(route = Screen.AppSignupScreen.route) {
            AppSignupScreen(navController = navController)
        }
        // student signup
        composable(route = Screen.SignupStudentScreen.route) {
            SignupStudentScreen(navController = navController)
        }

        // Login screen
        composable(route = Screen.AppLoginScreen.route) {
            AppLoginScreen(navController = navController)
        }

        // Benchmarks screen for testing carbon and ecological footprints
        composable(route = Screen.AppBenchmarkScreen.route) {
            AppBenchmarkScreen(navController = navController)
        }

        // User profile screen and utilities
        composable(route = Screen.PageProfileScreen.route) {
            PageProfileScreen(navController = navController)
        }
        // user profile settings
        composable(route = Screen.ProfileSettingsScreen.route) {
            ProfileSettingsScreen(navController = navController)
        }
    }
}