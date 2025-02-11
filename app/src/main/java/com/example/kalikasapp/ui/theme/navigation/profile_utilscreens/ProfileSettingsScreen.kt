package com.example.kalikasapp.ui.theme.navigation.profile_utilscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ButtonDefaults.elevatedButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.IconButton
import com.example.kalikasapp.ui.theme.Logout
import com.example.kalikasapp.ui.theme.navigation.Screen
import com.example.kalikasapp.ui.theme.opensansFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileSettingsScreen(navController: NavController) {
    // val darkGreen = Color(0xFF15472B)
    val green = Color(0xFF1E653E)
    val lightGreen = Color(0xFF39C076)
    val lightBlue = Color(0xFF9FE3BE)
    val blackGreen = Color(0xFF113822)
    // val whiteGreen = Color(0xFFFAFEFC)

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp,
                            bottomStart = 0.dp,
                            bottomEnd = 0.dp
                        )
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Brush.verticalGradient(
                            listOf(green, lightGreen, lightBlue))
                        ),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        TopAppBar(
                            modifier = Modifier
                                .absolutePadding(8.dp, 8.dp, 8.dp, 8.dp),
                            colors = topAppBarColors(
                                containerColor = Color.Transparent,
                                titleContentColor = Color.White,
                                navigationIconContentColor = Color.White
                            ),
                            title = {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Settings",
                                        textAlign = TextAlign.Center,
                                        fontSize = 28.sp,
                                        fontFamily = opensansFamily,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier
                                    )
                                }
                            }
                        )
                    }
                }
            }
        },
        bottomBar = {},
        floatingActionButton = {},
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            Box(
                modifier = Modifier
                    .absolutePadding(8.dp, 10.dp, 8.dp, 8.dp),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = {
                        navController.navigate(Screen.PageProfileScreen.route)
                    }
                ) {
                    Icon(
                        Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        null,
                        modifier = Modifier
                            .width(32.dp)
                            .height(32.dp)
                    )
                }
            }
            
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .absolutePadding(0.dp, 10.dp, 0.dp, 0.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "About You",
                        color = blackGreen,
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                        fontFamily = opensansFamily,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .absolutePadding(8.dp, 0.dp, 8.dp, 0.dp)
                    )
                }
                SettingEditPhoto()
                SettingEditName()
                SettingEditLocation()
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .absolutePadding(0.dp, 20.dp, 0.dp, 0.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Notifications",
                        color = blackGreen,
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                        fontFamily = opensansFamily,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .absolutePadding(8.dp, 0.dp, 8.dp, 0.dp)
                    )
                }
                SettingPushNotifications()
                SettingEmailNotifications()
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .absolutePadding(0.dp, 20.dp, 0.dp, 0.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Privacy",
                        color = blackGreen,
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                        fontFamily = opensansFamily,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .absolutePadding(8.dp, 0.dp, 8.dp, 0.dp)
                    )
                }
                SettingPrivateProfile()
                SettingBlocking()
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .absolutePadding(0.dp, 20.dp, 0.dp, 0.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Actions",
                        color = blackGreen,
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                        fontFamily = opensansFamily,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .absolutePadding(8.dp, 0.dp, 8.dp, 0.dp)
                    )
                }
                SettingDownloadData()
                SettingSyncData()
                SettingDeleteAccount()
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .absolutePadding(0.dp, 80.dp, 0.dp, 0.dp)
                    .fillMaxSize()
            ) {
                ElevatedButton(
                    onClick = {
                        navController.navigate(Screen.AppMainScreen.route)
                    },
                    colors = elevatedButtonColors(
                        lightGreen,
                        Color.White,
                        lightGreen,
                        Color.White
                    ),
                    modifier = Modifier
                        .width(250.dp)
                        .height(50.dp)
                ) {
                    Icon(imageVector = Logout, null)
                    Text(text = " Logout", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun SettingEditPhoto() {
    val blackGreen = Color(0xFF113822)
    val green = Color(0xFF1E653E)
    val lightGray = Color(0xFFFAFAFA)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
            .background(lightGray),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Edit Photo",
            color = blackGreen,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = opensansFamily,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .clickable(onClick = { } )
                .absolutePadding(16.dp, 0.dp, 0.dp, 0.dp)
        )
        Text(
            text = ">",
            color = green,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = opensansFamily,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .clickable(onClick = { } )
                .absolutePadding(0.dp, 0.dp, 32.dp, 0.dp)
        )
    }
}

@Composable
fun SettingEditName() {
    val blackGreen = Color(0xFF113822)
    val green = Color(0xFF1E653E)
    val lightGray = Color(0xFFFAFAFA)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
            .background(lightGray),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Edit Name",
            color = blackGreen,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = opensansFamily,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .clickable(onClick = { } )
                .absolutePadding(16.dp, 0.dp, 0.dp, 0.dp)
        )
        Text(
            text = ">",
            color = green,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = opensansFamily,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .clickable(onClick = { } )
                .absolutePadding(0.dp, 0.dp, 32.dp, 0.dp)
        )
    }
}

@Composable
fun SettingEditLocation() {
    val blackGreen = Color(0xFF113822)
    val green = Color(0xFF1E653E)
    val lightGray = Color(0xFFFAFAFA)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
            .background(lightGray),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Edit Location",
            color = blackGreen,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = opensansFamily,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .clickable(onClick = { } )
                .absolutePadding(16.dp, 0.dp, 0.dp, 0.dp)
        )
        Text(
            text = ">",
            color = green,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = opensansFamily,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .clickable(onClick = { } )
                .absolutePadding(0.dp, 0.dp, 32.dp, 0.dp)
        )
    }
}

@Composable
fun SettingPushNotifications() {
    val blackGreen = Color(0xFF113822)
    val green = Color(0xFF1E653E)
    val lightGray = Color(0xFFFAFAFA)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
            .background(lightGray),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Push Notifications",
            color = blackGreen,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = opensansFamily,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .clickable(onClick = { } )
                .absolutePadding(16.dp, 0.dp, 0.dp, 0.dp)
        )
        Text(
            text = ">",
            color = green,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = opensansFamily,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .clickable(onClick = { } )
                .absolutePadding(0.dp, 0.dp, 32.dp, 0.dp)
        )
    }
}

@Composable
fun SettingEmailNotifications() {
    val blackGreen = Color(0xFF113822)
    val green = Color(0xFF1E653E)
    val lightGray = Color(0xFFFAFAFA)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
            .background(lightGray),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Email Notifications",
            color = blackGreen,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = opensansFamily,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .clickable(onClick = { } )
                .absolutePadding(16.dp, 0.dp, 0.dp, 0.dp)
        )
        Text(
            text = ">",
            color = green,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = opensansFamily,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .clickable(onClick = { } )
                .absolutePadding(0.dp, 0.dp, 32.dp, 0.dp)
        )
    }
}

@Composable
fun SettingPrivateProfile() {
    val blackGreen = Color(0xFF113822)
    val green = Color(0xFF1E653E)
    val lightGray = Color(0xFFFAFAFA)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
            .background(lightGray),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Private Profile",
            color = blackGreen,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = opensansFamily,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .clickable(onClick = { } )
                .absolutePadding(16.dp, 0.dp, 0.dp, 0.dp)
        )
        Text(
            text = ">",
            color = green,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = opensansFamily,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .clickable(onClick = { } )
                .absolutePadding(0.dp, 0.dp, 32.dp, 0.dp)
        )
    }
}

@Composable
fun SettingBlocking() {
    val blackGreen = Color(0xFF113822)
    val green = Color(0xFF1E653E)
    val lightGray = Color(0xFFFAFAFA)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
            .background(lightGray),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Blocking",
            color = blackGreen,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = opensansFamily,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .clickable(onClick = { } )
                .absolutePadding(16.dp, 0.dp, 0.dp, 0.dp)
        )
        Text(
            text = ">",
            color = green,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = opensansFamily,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .clickable(onClick = { } )
                .absolutePadding(0.dp, 0.dp, 32.dp, 0.dp)
        )
    }
}

@Composable
fun SettingDownloadData() {
    val blackGreen = Color(0xFF113822)
    val green = Color(0xFF1E653E)
    val lightGray = Color(0xFFFAFAFA)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
            .background(lightGray),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Download Data",
            color = blackGreen,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = opensansFamily,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .clickable(onClick = { } )
                .absolutePadding(16.dp, 0.dp, 0.dp, 0.dp)
        )
        Text(
            text = ">",
            color = green,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = opensansFamily,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .clickable(onClick = { } )
                .absolutePadding(0.dp, 0.dp, 32.dp, 0.dp)
        )
    }
}

@Composable
fun SettingSyncData() {
    val blackGreen = Color(0xFF113822)
    val green = Color(0xFF1E653E)
    val lightGray = Color(0xFFFAFAFA)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
            .background(lightGray),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Sync Data",
            color = blackGreen,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = opensansFamily,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .clickable(onClick = { } )
                .absolutePadding(16.dp, 0.dp, 0.dp, 0.dp)
        )
        Text(
            text = ">",
            color = green,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = opensansFamily,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .clickable(onClick = { } )
                .absolutePadding(0.dp, 0.dp, 32.dp, 0.dp)
        )
    }
}

@Composable
fun SettingDeleteAccount() {
    val blackGreen = Color(0xFF113822)
    val green = Color(0xFF1E653E)
    val lightGray = Color(0xFFFAFAFA)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
            .background(lightGray),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Delete Account",
            color = blackGreen,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = opensansFamily,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .clickable(onClick = { } )
                .absolutePadding(16.dp, 0.dp, 0.dp, 0.dp)
        )
        Text(
            text = ">",
            color = green,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = opensansFamily,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .clickable(onClick = { } )
                .absolutePadding(0.dp, 0.dp, 32.dp, 0.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PageProfileScreenPreview() {
    val navController = rememberNavController()
    ProfileSettingsScreen(navController = navController)
}
