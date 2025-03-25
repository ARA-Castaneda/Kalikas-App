package com.example.kalikasapp.ui.theme.navigation

// only classes inside this class file
// can inherit from Screen
sealed class Screen(val route: String) {
    object AppMainScreen : Screen("main_screen")
    object AppLoginScreen : Screen("login_screen")
    object AppSignupScreen : Screen("signup_screen")
    object AppBenchmarkScreen : Screen("benchmark_screen")

    object PageProfileScreen : Screen("profilepage_screen")
    object PageFootprintScreen : Screen("footprintpage_screen")
    object PageExploreScreen : Screen("explorepage_screen")
    object PageLearnScreen : Screen("learnpage_screen")
    object PageNotifsScreen : Screen("notifspage_screen")

    object SignupStudentScreen : Screen("studentsignup_screen")
    object SignupEducatorScreen : Screen("educatorsignup_screen")
    object SignupMerchantScreen : Screen("merchantsignup_screen")

    object BenchmarkDoneScreen : Screen("benchmark_done")
    object WaterBenchmarkScreenA : Screen("water_benchmarkA")
    object WaterBenchmarkScreenB : Screen("water_benchmarkB")
    object WaterBenchmarkScreenC : Screen("water_benchmarkC")
    object EnergyBenchmarkScreenA : Screen("energy_benchmarkA")
    object EnergyBenchmarkScreenB : Screen("energy_benchmarkB")
    object EnergyBenchmarkScreenC : Screen("energy_benchmarkC")
    object EnergyBenchmarkScreenD : Screen("energy_benchmarkD")
    object TranspoBenchmarkScreenA : Screen("transpo_benchmarkA")
    object TranspoBenchmarkScreenB : Screen("transpo_benchmarkB")
    object FoodBenchmarkScreenA : Screen("food_benchmarkA")
    object FoodBenchmarkScreenB : Screen("food_benchmarkB")
    object FoodBenchmarkScreenC : Screen("food_benchmarkC")
    object WasteBenchmarkScreenA : Screen("waste_benchmarkA")
    object WasteBenchmarkScreenB : Screen("waste_benchmarkB")
    object WasteBenchmarkScreenC : Screen("waste_benchmarkC")
    object WasteBenchmarkScreenD : Screen("waste_benchmarkD")

    object ProfileBadgesScreen : Screen("profile_badges")
    object ProfileConnectsScreen : Screen("profile_connects")
    object ProfileMilestonesScreen : Screen("profile_milestones")
    object ProfileSettingsScreen : Screen("profile_settings")

    object FootprintWeeklyScreen : Screen("footprint_weekly")
    object FootprintMonthlyScreen : Screen("footprint_monthly")
    object FootprintYearlyScreen : Screen("footprint_yearly")

    object FootprintLoggerWaterScreen : Screen("water_logger")
    object FootprintLoggerEnergyScreen : Screen("energy_logger")
    object FootprintLoggerTranspoScreen : Screen("transpo_logger")
    object FootprintLoggerFoodScreen : Screen("food_logger")
    object FootprintLoggerWasteScreen : Screen("waste_logger")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}