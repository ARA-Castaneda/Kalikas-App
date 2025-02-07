package com.example.kalikasapp.ui.theme.navigation.landing_screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/*
@Composable
fun AppSignupScreen(name: String?) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Hello, $name")
    }
}

/*
@Preview(showBackground = true)
@Composable
fun AppSignupScreenPreview() {

}
*/
*/

// composable in Navigation.kt for passing string to Signup screen
/*
composable(
            route = Screen.AppSignupScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Iskolar"
                    nullable = true
                }
            )
        ) { entry ->
            AppSignupScreen(name = entry.arguments?.getString("name"), navController = navController)
        }
*/