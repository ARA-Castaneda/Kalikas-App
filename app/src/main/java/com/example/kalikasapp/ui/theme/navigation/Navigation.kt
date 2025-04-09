package com.example.kalikasapp.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kalikasapp.ui.theme.navigation.benchmark_screens.BenchmarkDoneScreen
import com.example.kalikasapp.ui.theme.navigation.benchmark_screens.WaterBenchmarkScreenA
import com.example.kalikasapp.ui.theme.navigation.benchmark_screens.WaterBenchmarkScreenB
import com.example.kalikasapp.ui.theme.navigation.benchmark_screens.WaterBenchmarkScreenC
import com.example.kalikasapp.ui.theme.navigation.benchmark_screens.EnergyBenchmarkScreenA
import com.example.kalikasapp.ui.theme.navigation.benchmark_screens.EnergyBenchmarkScreenB
import com.example.kalikasapp.ui.theme.navigation.benchmark_screens.EnergyBenchmarkScreenC
import com.example.kalikasapp.ui.theme.navigation.benchmark_screens.EnergyBenchmarkScreenD
import com.example.kalikasapp.ui.theme.navigation.benchmark_screens.FoodBenchmarkScreenA
import com.example.kalikasapp.ui.theme.navigation.benchmark_screens.FoodBenchmarkScreenB
import com.example.kalikasapp.ui.theme.navigation.benchmark_screens.FoodBenchmarkScreenC
import com.example.kalikasapp.ui.theme.navigation.benchmark_screens.TranspoBenchmarkScreenA
import com.example.kalikasapp.ui.theme.navigation.benchmark_screens.TranspoBenchmarkScreenB
import com.example.kalikasapp.ui.theme.navigation.benchmark_screens.WasteBenchmarkScreenA
import com.example.kalikasapp.ui.theme.navigation.benchmark_screens.WasteBenchmarkScreenB
import com.example.kalikasapp.ui.theme.navigation.benchmark_screens.WasteBenchmarkScreenC
import com.example.kalikasapp.ui.theme.navigation.benchmark_screens.WasteBenchmarkScreenD
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.FootprintLoggerEnergyScreen
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.FootprintLoggerFoodScreen
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.FootprintLoggerTranspoScreen
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.FootprintLoggerWasteScreen
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.FootprintLoggerWaterScreen
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
import com.example.kalikasapp.ui.theme.navigation.landing_screens.ProfileEducatorScreen
import com.example.kalikasapp.ui.theme.navigation.landing_screens.ProfileMerchantScreen
import com.example.kalikasapp.ui.theme.navigation.signup_screens.SignupStudentScreen
import com.example.kalikasapp.ui.theme.navigation.signup_screens.SignupEducatorScreen
import com.example.kalikasapp.ui.theme.navigation.signup_screens.SignupMerchantScreen
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
        // educator signup
        composable(route = Screen.SignupEducatorScreen.route) {
            SignupEducatorScreen(navController = navController)
        }
        // merchant signup
        composable(route = Screen.SignupMerchantScreen.route) {
            SignupMerchantScreen(navController = navController)
        }

        // Login screen
        composable(route = Screen.AppLoginScreen.route) {
            AppLoginScreen(navController = navController)
        }

        // Benchmarks screens for testing carbon and ecological footprints
        composable(route = Screen.AppBenchmarkScreen.route) {
            AppBenchmarkScreen(navController = navController)
        }
        // landing benchmark screen after answering all question sets
        composable(route = Screen.BenchmarkDoneScreen.route) {
            BenchmarkDoneScreen(navController = navController)
        }
        // water benchmark screens of question sets A to C
        composable(route = Screen.WaterBenchmarkScreenA.route) {
            WaterBenchmarkScreenA(navController = navController)
        }
        composable(route = Screen.WaterBenchmarkScreenB.route) {
            WaterBenchmarkScreenB(navController = navController)
        }
        composable(route = Screen.WaterBenchmarkScreenC.route) {
            WaterBenchmarkScreenC(navController = navController)
        }
        // energy benchmark screens of question sets A to D
        composable(route = Screen.EnergyBenchmarkScreenA.route) {
            EnergyBenchmarkScreenA(navController = navController)
        }
        composable(route = Screen.EnergyBenchmarkScreenB.route) {
            EnergyBenchmarkScreenB(navController = navController)
        }
        composable(route = Screen.EnergyBenchmarkScreenC.route) {
            EnergyBenchmarkScreenC(navController = navController)
        }
        composable(route = Screen.EnergyBenchmarkScreenD.route) {
            EnergyBenchmarkScreenD(navController = navController)
        }
        // transpo benchmark screens of question sets A to B
        composable(route = Screen.TranspoBenchmarkScreenA.route) {
            TranspoBenchmarkScreenA(navController = navController)
        }
        composable(route = Screen.TranspoBenchmarkScreenB.route) {
            TranspoBenchmarkScreenB(navController = navController)
        }
        // food benchmark screens of question sets A to C
        composable(route = Screen.FoodBenchmarkScreenA.route) {
            FoodBenchmarkScreenA(navController = navController)
        }
        composable(route = Screen.FoodBenchmarkScreenB.route) {
            FoodBenchmarkScreenB(navController = navController)
        }
        composable(route = Screen.FoodBenchmarkScreenC.route) {
            FoodBenchmarkScreenC(navController = navController)
        }
        // waste benchmark screens of question sets A to D
        composable(route = Screen.WasteBenchmarkScreenA.route) {
            WasteBenchmarkScreenA(navController = navController)
        }
        composable(route = Screen.WasteBenchmarkScreenB.route) {
            WasteBenchmarkScreenB(navController = navController)
        }
        composable(route = Screen.WasteBenchmarkScreenC.route) {
            WasteBenchmarkScreenC(navController = navController)
        }
        composable(route = Screen.WasteBenchmarkScreenD.route) {
            WasteBenchmarkScreenD(navController = navController)
        }

        // User profiles screen and utilities
        composable(route = Screen.PageProfileScreen.route) {
            PageProfileScreen(navController = navController)
        }
        // user profile settings
        composable(route = Screen.ProfileSettingsScreen.route) {
            ProfileSettingsScreen(navController = navController)
        }
        // educator profile screen
        composable(route = Screen.ProfileEducatorScreen.route) {
            ProfileEducatorScreen(navController = navController)
        }
        // merchant profile screen
        composable(route = Screen.ProfileMerchantScreen.route) {
            ProfileMerchantScreen(navController = navController)
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

        // Footprint record logger screens
        // water footprint logger
        composable(route = Screen.FootprintLoggerWaterScreen.route) {
            FootprintLoggerWaterScreen(navController = navController)
        }
        // energy footprint logger
        composable(route = Screen.FootprintLoggerEnergyScreen.route) {
            FootprintLoggerEnergyScreen(navController = navController)
        }
        // transpo footprint logger
        composable(route = Screen.FootprintLoggerTranspoScreen.route) {
            FootprintLoggerTranspoScreen(navController = navController)
        }
        // food footprint logger
        composable(route = Screen.FootprintLoggerFoodScreen.route) {
            FootprintLoggerFoodScreen(navController = navController)
        }
        // waste footprint logger
        composable(route = Screen.FootprintLoggerWasteScreen.route) {
            FootprintLoggerWasteScreen(navController = navController)
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