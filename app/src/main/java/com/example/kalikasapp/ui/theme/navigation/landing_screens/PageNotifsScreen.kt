package com.example.kalikasapp.ui.theme.navigation.landing_screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun PageNotifsScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomNavBar(navController)
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    FootprintPageBackdrop(modifier = Modifier)
                }
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun PageNotifsPreview() {
    val navController = rememberNavController()
    PageNotifsScreen(navController = navController)
}
