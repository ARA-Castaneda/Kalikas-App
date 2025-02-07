package com.example.kalikasapp.ui.theme.navigation.landing_screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun PageProfileScreen(navController : NavController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Hello")
    }
}


@Preview(showBackground = true)
@Composable
fun PageProfileScreenPreview() {
    val navController = rememberNavController()
    PageProfileScreen(navController = navController)
}