package com.example.kalikasapp.ui.theme.navigation.landing_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults.elevatedButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kalikasapp.R
import com.example.kalikasapp.ui.theme.Account_circle
import com.example.kalikasapp.ui.theme.Card_travel
import com.example.kalikasapp.ui.theme.Menu_book
import com.example.kalikasapp.ui.theme.navigation.Screen
import com.example.kalikasapp.ui.theme.solwayFamily
import com.example.kalikasapp.ui.theme.soraFamily

@Composable
fun LandingLogoImage(modifier: Modifier) {
    val image = painterResource(R.drawable.logo)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = 100.dp)
                .width(200.dp)
                .height(300.dp)
        )
    }
}

@Composable
fun AppSignupScreen(navController: NavController) {
    val darkGreen = Color(0xFF15472B)
    val green = Color(0xFF1E653E)
    val lightGreen = Color(0xFF39C076)
    val lightBlue = Color(0xFF9FE3BE)
    val blackGreen = Color(0xFF113822)
    val whiteGreen = Color(0xFFFAFEFC)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(darkGreen, green, lightGreen, lightBlue)
                )
            )
    ) {
        OverlayImage(modifier = Modifier)
        LandingLogoImage(modifier = Modifier)
        Text(
            text = "KalikasApp",
            color = Color.White,
            fontSize = 56.sp,
            fontFamily = solwayFamily,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 230.dp)
        )
    }

    Box(
        modifier = Modifier
            .absolutePadding(0.dp, 320.dp, 0.dp, 0.dp)
            .clip(shape = RoundedCornerShape(50.dp, 50.dp))
            .background(color = whiteGreen)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .absolutePadding(20.dp, 20.dp, 20.dp, 20.dp)
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
            ) {
                ElevatedButton(
                    onClick = {
                        navController.navigate(Screen.AppMainScreen.route)
                    },
                    colors = elevatedButtonColors(Color.Transparent, blackGreen, green, blackGreen),
                    modifier = Modifier
                        .width(75.dp)
                        .height(50.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                ) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
                }
            }

            Row(
                modifier = Modifier
                    .absolutePadding(20.dp, 10.dp, 20.dp, 10.dp)
            ) {
                Text(
                    text = "Sign Up",
                    color = blackGreen,
                    fontSize = 36.sp,
                    fontFamily = soraFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .absolutePadding(20.dp, 40.dp, 20.dp, 20.dp)
                    .fillMaxSize()
            ) {
                ElevatedButton(
                    onClick = {
                        navController.navigate(Screen.SignupStudentScreen.route)
                    },
                    colors = elevatedButtonColors(green, Color.White, green, Color.White),
                    modifier = Modifier
                        .width(250.dp)
                        .height(50.dp)
                ) {
                    Icon(imageVector = Account_circle, null)
                    Text(text = " Student", color = Color.White)
                }

                Spacer(modifier = Modifier.height(30.dp))
                ElevatedButton(
                    onClick = {
                        navController.navigate(Screen.SignupEducatorScreen.route)
                    },
                    colors = elevatedButtonColors(green, Color.White, green, Color.White),
                    modifier = Modifier
                        .width(250.dp)
                        .height(50.dp)
                ) {
                    Icon(imageVector = Menu_book, null)
                    Text(text = " Educator", color = Color.White)
                }

                Spacer(modifier = Modifier.height(30.dp))
                ElevatedButton(
                    onClick = {
                        navController.navigate(Screen.SignupMerchantScreen.route)
                    },
                    colors = elevatedButtonColors(green, Color.White, green, Color.White),
                    modifier = Modifier
                        .width(250.dp)
                        .height(50.dp)
                ) {
                    Icon(imageVector = Card_travel, null)
                    Text(text = " Merchant", color = Color.White)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AppSignupScreenPreview() {
    val navController = rememberNavController()
    AppSignupScreen(navController = navController)
}
