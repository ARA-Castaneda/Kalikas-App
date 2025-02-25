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

    object ProfileBadgesScreen : Screen("profile_badges")
    object ProfileConnectsScreen : Screen("profile_connects")
    object ProfileMilestonesScreen : Screen("profile_milestones")
    object ProfileSettingsScreen : Screen("profile_settings")

    object FootprintWeeklyScreen : Screen("footprint_weekly")
    object FootprintMonthlyScreen : Screen("footprint_monthly")
    object FootprintYearlyScreen : Screen("footprint_yearly")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}