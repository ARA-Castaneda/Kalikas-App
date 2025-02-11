package com.example.kalikasapp.ui.theme.navigation.landing_screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.IconButton
import coil3.compose.rememberAsyncImagePainter
import com.example.kalikasapp.R
import com.example.kalikasapp.ui.theme.Account_balance
import com.example.kalikasapp.ui.theme.Photo_camera
import com.example.kalikasapp.ui.theme.Share_location
import com.example.kalikasapp.ui.theme.montserratFamily
import com.example.kalikasapp.ui.theme.navigation.Screen
import com.example.kalikasapp.ui.theme.robotoFamily
import com.example.kalikasapp.ui.theme.soraFamily

@Composable
fun PageProfileScreen(navController: NavController) {
    // val darkGreen = Color(0xFF15472B)
    // val whiteGreen = Color(0xFFFAFEFC)

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
                        null, null, null, null
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

@Composable
fun SettingsButton(settingsIcon: Painter, onClick: () -> Unit) {
    Box(modifier = Modifier) {
        Button(
            modifier = Modifier,
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(Color.Transparent)
        ) {
            Image(
                painter = settingsIcon,
                contentDescription = null,
                modifier = Modifier.width(30.dp).height(30.dp)
            )
        }
    }
}

@Composable
fun ProfileCoverPhoto() {
    val imageUri = rememberSaveable { mutableStateOf("") }
    val painter = rememberAsyncImagePainter(
        model = imageUri.value.ifEmpty { R.drawable.ic_background }
    )
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: android.net.Uri? ->
        uri.let {imageUri.value = it.toString() }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .height(200.dp)
                        .wrapContentSize(),
                    contentScale = ContentScale.Crop
                )
            }

            IconButton(
                onClick = {
                    launcher.launch("image/*")
                },
                modifier = Modifier
                    .absolutePadding(310.dp, 156.dp, 0.dp, 0.dp)
                    .width(40.dp)
                    .height(40.dp)
                    .background(Color.Transparent)
            ) {
                Icon(
                    imageVector = Photo_camera,
                    null,
                    modifier = Modifier.alpha(0.2f)
                )
            }
        }
    }
}

@Composable
fun ProfileDisplayPhoto() {
    val imageUri = rememberSaveable { mutableStateOf("") }
    val painter = rememberAsyncImagePainter(
        model = imageUri.value.ifEmpty { R.drawable.ic_user }
    )
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: android.net.Uri? ->
        uri.let {imageUri.value = it.toString() }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .absolutePadding(20.dp, 140.dp, 20.dp, 20.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier.size(100.dp),
            shape = CircleShape
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize(),
                contentScale = ContentScale.Crop
            )
        }

        IconButton(
            onClick = {
                launcher.launch("image/*")
            },
            modifier = Modifier
                .absolutePadding(0.dp, 70.dp, 0.dp, 0.dp)
                .width(26.dp)
                .height(26.dp)
                .background(Color.Transparent)
        ) {
            Icon(
                imageVector = Photo_camera,
                null,
                modifier = Modifier.alpha(0.2f)
            )
        }
    }
}

@Composable
fun ProfileUserInfo(
    name: String?, location: String?,
    institution: String?, bio: String?
) {
    val blackGreen = Color(0xFF113822)
    val green = Color(0xFF1E653E)
    val lightGreen = Color(0xFF39C076)

    val userName = name ?: "Kalikas Admin"
    val userLoc = location ?: "Add location"
    val userInst = institution ?: "Add institution"
    val userBio = bio ?: "Welcome to Kalikas App. The sustainable living journey starts here. This user has yet to add an introduction."
    // var userBio by rememberSaveable { mutableStateOf("This user needs an introduction") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .absolutePadding(20.dp, 250.dp, 20.dp, 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = userName,
            color = blackGreen,
            fontSize = 24.sp,
            fontFamily = soraFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
        )

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Share_location,
                null,
                tint = lightGreen,
                modifier = Modifier.absolutePadding(0.dp, 0.dp, 5.dp, 0.dp)
            )
            Text(
                text = userLoc,
                color = green,
                fontSize = 12.sp,
                fontFamily = soraFamily,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
            )
        }

        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Account_balance,
                null,
                tint = lightGreen,
                modifier = Modifier.absolutePadding(0.dp, 0.dp, 5.dp, 0.dp)
            )
            Text(
                text = userInst,
                color = green,
                fontSize = 12.sp,
                fontFamily = soraFamily,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier,
            verticalAlignment  = Alignment.CenterVertically
        ) {
            Text(
                text = userBio,
                textAlign = TextAlign.Center,
                color = blackGreen,
                fontSize = 14.sp,
                fontFamily = soraFamily,
                fontWeight = FontWeight.Light,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun ProfileNavBar() {
    val lightBlue = Color(0xFF9FE3BE)
    val green = Color(0xFF1E653E)
    val lightGreen = Color(0xFF39C076)

    Column(
        modifier = Modifier
            .absolutePadding(10.dp, 460.dp, 10.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalDivider(color = lightBlue, thickness = 2.dp)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .absolutePadding(20.dp, 0.dp, 20.dp, 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextButton(
                    onClick = { /***/ },
                    modifier = Modifier
                ) {
                    Text(
                        text = "BADGES",
                        color = lightGreen,
                        fontSize = 10.sp,
                        fontFamily = montserratFamily,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                    )
                }
                Text(
                    text = "0",
                    color = green,
                    fontSize = 28.sp,
                    fontFamily = montserratFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
            }

            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextButton(
                    onClick = { /***/ },
                    modifier = Modifier
                ) {
                    Text(
                        text = "MILESTONES",
                        color = lightGreen,
                        fontSize = 10.sp,
                        fontFamily = montserratFamily,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                    )
                }
                Text(
                    text = "0",
                    color = green,
                    fontSize = 28.sp,
                    fontFamily = montserratFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
            }

            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextButton(
                    onClick = { /***/ },
                    modifier = Modifier
                ) {
                    Text(
                        text = "CONNECTS",
                        color = lightGreen,
                        fontSize = 10.sp,
                        fontFamily = montserratFamily,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                    )
                }
                Text(
                    text = "0",
                    color = green,
                    fontSize = 28.sp,
                    fontFamily = montserratFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
            }
        }

        HorizontalDivider(color = lightBlue, thickness = 2.dp)
    }
}

@Composable
fun ProfileLevelCard(
    level: Int?, streak: Int?,
    title: String?, titlePainter: Painter,
    levelExp: Int?, nextLevelExp: Int?
) {
    val lightBlue = Color(0xFF9FE3BE)
    val lightGreen = Color(0xFF39C076)
    val green = Color(0xFF1E653E)
    val darkGreen = Color(0xFF15472B)

    val userLevel = level ?: 1
    val userStreak = streak ?: 0
    val userTitle = title ?: "Nature Newbie"
    val userLevelExp = levelExp ?: 70
    val userNextLevelExp = nextLevelExp ?: 200
    val currentExp = userLevelExp.toFloat() / userNextLevelExp.toFloat()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .absolutePadding(20.dp, 510.dp, 20.dp, 20.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(300.dp)
                .height(200.dp)
                .absolutePadding(0.dp, 90.dp, 0.dp, 0.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                listOf(lightBlue, lightGreen, green, darkGreen)
                            )
                        )
                ) {
                    Image(
                        painter = painterResource(R.drawable.card_level),
                        contentDescription = null,
                        modifier = Modifier
                            .wrapContentSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .absolutePadding(8.dp, 8.dp, 8.dp, 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(modifier = Modifier) {
                        Image(
                            painter = painterResource(R.drawable.trophy),
                            contentDescription = null,
                            modifier = Modifier
                                .absolutePadding(0.dp, 0.dp, 4.dp, 0.dp)
                                .width(16.dp).height(16.dp)

                        )
                        Text(
                            text = "Level ",
                            color = green,
                            fontSize = 14.sp,
                            fontFamily = robotoFamily,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                        )
                    }
                    Text(
                        text = userLevel.toString(),
                        color = green,
                        fontSize = 16.sp,
                        fontFamily = robotoFamily,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                    )
                }

                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(modifier = Modifier) {
                        Image(
                            painter = painterResource(R.drawable.streak),
                            contentDescription = null,
                            modifier = Modifier
                                .absolutePadding(0.dp, 0.dp, 4.dp, 0.dp)
                                .width(16.dp).height(16.dp)

                        )
                        Text(
                            text = "Streak ",
                            color = green,
                            fontSize = 14.sp,
                            fontFamily = robotoFamily,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                        )
                    }
                    Text(
                        text = userStreak.toString(),
                        color = green,
                        fontSize = 16.sp,
                        fontFamily = robotoFamily,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                    )
                }
            }
        }

        Box(
            modifier = Modifier,
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = titlePainter,
                    contentDescription = null,
                    modifier = Modifier
                        .width(80.dp).height(80.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = userTitle,
                    color = darkGreen,
                    fontSize = 18.sp,
                    fontFamily = montserratFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
            }
        }

        Box(
            modifier = Modifier
                .width(300.dp)
                .height(200.dp)
                .absolutePadding(0.dp, 160.dp, 0.dp, 0.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .absolutePadding(20.dp, 8.dp, 20.dp, 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "EXP",
                    color = darkGreen,
                    fontSize = 10.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )

                Text(
                    text = "$userLevelExp/$userNextLevelExp",
                    color = darkGreen,
                    fontSize = 10.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                )
            }
        }

        Box(
            modifier = Modifier
                .absolutePadding(0.dp, 180.dp, 0.dp, 0.dp)
        ) {
            ProfileLevelBar(currentExp)
        }
    }
}

@Composable
fun ProfileLevelBar(exp: Float) {
    val progressBarExp = Color(0xFFFFD400)
    var progress by remember { mutableStateOf(value = exp) }

    val coroutineScope = rememberCoroutineScope()

    LinearProgressIndicator(
        progress = { progress },
        color = progressBarExp
    )
}


@Preview(showBackground = true)
@Composable
fun PageProfileScreenPreview() {
    val navController = rememberNavController()
    PageProfileScreen(navController = navController)
}
