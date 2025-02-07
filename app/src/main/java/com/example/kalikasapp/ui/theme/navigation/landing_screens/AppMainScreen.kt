package com.example.kalikasapp.ui.theme.navigation.landing_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults.elevatedButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.kalikasapp.ui.theme.App_registration
import com.example.kalikasapp.ui.theme.Login
import com.example.kalikasapp.ui.theme.navigation.Screen
import com.example.kalikasapp.ui.theme.solwayFamily

@Composable
fun LogoImage(modifier: Modifier) {
    val image = painterResource(R.drawable.logo)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = 50.dp)
                .width(300.dp)
                .height(500.dp)
        )
    }
}

@Composable
fun OverlayImage(modifier: Modifier) {
    val image = painterResource(R.drawable.overlay)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@Composable
fun AppMainScreen(navController: NavController) {
    val darkGreen = Color(0xFF15472B)
    val green = Color(0xFF1E653E)
    val lightGreen = Color(0xFF39C076)
    val lightBlue = Color(0xFF9FE3BE)
    val blackGreen = Color(0xFF113822)
    // val whiteGreen = Color(0xFFFAFEFC)

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
        LogoImage(modifier = Modifier)
        Text(
            text = "KalikasApp",
            color = Color.White,
            fontSize = 56.sp,
            fontFamily = solwayFamily,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 380.dp)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .absolutePadding(0.dp, 600.dp, 0.dp, 0.dp)
                .fillMaxSize()
        ) {
            ElevatedButton(
                onClick = {
                    navController.navigate(Screen.AppSignupScreen.route)
                },
                colors = elevatedButtonColors(Color.White, blackGreen, green, blackGreen),
                modifier = Modifier
                    .width(250.dp)
                    .height(50.dp)
            ) {
                Icon(imageVector = App_registration, null)
                Text(text = " Sign Up", color = blackGreen)
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .absolutePadding(0.dp, 675.dp, 0.dp, 0.dp)
                .fillMaxSize()
        ) {
            ElevatedButton(
                onClick = {
                    navController.navigate(Screen.AppLoginScreen.route)
                },
                colors = elevatedButtonColors(Color.White, blackGreen, green, blackGreen),
                modifier = Modifier
                    .width(250.dp)
                    .height(50.dp)
            ) {
                Icon(imageVector = Login, null)
                Text(text = " Login", color = blackGreen)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AppMainScreenPreview() {
    val navController = rememberNavController()
    AppMainScreen(navController = navController)
}
