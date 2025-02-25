package com.example.kalikasapp.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.FootprintMonthlyScreen
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.FootprintWeeklyScreen
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.FootprintYearlyScreen
import com.example.kalikasapp.ui.theme.navigation.landing_screens.AppBenchmarkScreen
import com.example.kalikasapp.ui.theme.navigation.landing_screens.AppLoginScreen
import com.example.kalikasapp.ui.theme.navigation.landing_screens.AppMainScreen
import com.example.kalikasapp.ui.theme.navigation.landing_screens.AppSignupScreen
import com.example.kalikasapp.ui.theme.navigation.landing_screens.PageExploreScreen
import com.example.kalikasapp.ui.theme.navigation.landing_screens.PageFootprintScreen
import com.example.kalikasapp.ui.theme.navigation.landing_screens.PageLearnScreen
import com.example.kalikasapp.ui.theme.navigation.landing_screens.PageNotifsScreen
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

        // Benchmarks screens for testing carbon and ecological footprints
        composable(route = Screen.AppBenchmarkScreen.route) {
            AppBenchmarkScreen(navController = navController)
        }

        // User profiles screen and utilities
        composable(route = Screen.PageProfileScreen.route) {
            PageProfileScreen(navController = navController)
        }
        // user profile settings
        composable(route = Screen.ProfileSettingsScreen.route) {
            ProfileSettingsScreen(navController = navController)
        }

        // Footprint calculator screens
        composable(route = Screen.PageFootprintScreen.route) {
            PageFootprintScreen(navController = navController)
        }
        // weekly footprint
        composable(route = Screen.FootprintWeeklyScreen.route) {
            FootprintWeeklyScreen(navController = navController)
        }
        // monthly footprint
        composable(route = Screen.FootprintMonthlyScreen.route) {
            FootprintMonthlyScreen(navController = navController)
        }
        // yearly footprint
        composable(route = Screen.FootprintYearlyScreen.route) {
            FootprintYearlyScreen(navController = navController)
        }

        // Explore page screen
        composable(route = Screen.PageExploreScreen.route) {
            PageExploreScreen(navController = navController)
        }

        // Learn page screen and lessons utilities
        composable(route = Screen.PageLearnScreen.route) {
            PageLearnScreen(navController = navController)
        }

        // Notifs page screen
        composable(route = Screen.PageNotifsScreen.route) {
            PageNotifsScreen(navController = navController)
        }
    }
}