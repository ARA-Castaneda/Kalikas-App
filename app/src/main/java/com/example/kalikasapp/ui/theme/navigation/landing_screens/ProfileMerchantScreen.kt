package com.example.kalikasapp.ui.theme.navigation.landing_screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kalikasapp.R
import com.example.kalikasapp.ui.theme.navigation.Screen

@Composable
fun ProfileMerchantScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomNavBar(navController)
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                    ) {
                        Box(modifier = Modifier) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .absolutePadding(20.dp, 20.dp, 20.dp, 20.dp)
                            ) {
                                ProfileCoverPhoto()
                                ProfileDisplayPhoto()
                                ProfileUserInfo(
                                    "Kalikas Merchant", null, null, null
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .absolutePadding(5.dp, 20.dp, 0.dp, 0.dp)
                            ) {
                                SettingsButton(
                                    settingsIcon = painterResource(id = R.drawable.settingsbutton),
                                    onClick = {
                                        navController.navigate(Screen.ProfileSettingsScreen.route)
                                    }
                                )
                            }

                            ProfileNavBar()
                            ProfileLevelCard(
                                level = null,
                                streak = null,
                                title = null,
                                titlePainter = painterResource(id = R.drawable.level1),
                                levelExp = null,
                                nextLevelExp = null
                            )
                        }
                    }
                }
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun ProfileMerchantScreenPreview() {
    val navController = rememberNavController()
    ProfileMerchantScreen(navController = navController)
}
