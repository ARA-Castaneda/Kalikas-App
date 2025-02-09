package com.example.kalikasapp.ui.theme.navigation.landing_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.kalikasapp.R
import com.example.kalikasapp.ui.theme.App_registration
import com.example.kalikasapp.ui.theme.Footprint
import com.example.kalikasapp.ui.theme.navigation.Screen
import com.example.kalikasapp.ui.theme.soraFamily


@Composable
fun TestBackgroundImage(modifier: Modifier) {
    val darkGreen = Color(0xFF15472B)
    Box(modifier = Modifier
        .background(darkGreen)
        .height(250.dp)
        .fillMaxWidth())
}


@Composable
fun TestLogoImage(modifier: Modifier) {
    val image = painterResource(R.drawable.logo)
    Box(modifier = Modifier.drawBehind { drawCircle(Color.White)}
        ) {

        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
        )

    }
}

@Composable
fun TopButtonRow(modifier: Modifier, navController : NavController){
    val darkGreen = Color(0xFF15472B)
    val green = Color(0xFF1E653E)
    val lightGreen = Color(0xFF39C076)
    val lightBlue = Color(0xFF9FE3BE)
    val blackGreen = Color(0xFF113822)
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
    ) {
        SmallFloatingActionButton(
            onClick = {
                navController.navigate(Screen.AppSignupScreen.route)
            },
            containerColor = Color.White,
            contentColor = blackGreen,
            shape = CircleShape,

            ) {
            Icon(imageVector = App_registration, null)
        }
        SmallFloatingActionButton(
            onClick = {
                navController.navigate(Screen.AppSignupScreen.route)
            },
            containerColor = Color.White,
            contentColor = blackGreen,
            shape = CircleShape,
            modifier = Modifier.padding(start = 280.dp)
        ) {
            Icon(imageVector = Footprint, null)
        }
    }
}

@Composable
fun PageProfileScreen(navController : NavController) {
    val darkGreen = Color(0xFF15472B)
    val green = Color(0xFF1E653E)
    val lightGreen = Color(0xFF39C076)
    val lightBlue = Color(0xFF9FE3BE)
    val blackGreen = Color(0xFF113822)
    Box(
        modifier = Modifier.fillMaxSize().background(Color.White))
    {
        TestBackgroundImage(Modifier)
        TopButtonRow(Modifier,navController)
        Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 175.dp)
        ){
        TestLogoImage(modifier = Modifier)
        Text(text = "JP Dela Cruz")
        Text(text = "[Bio]",modifier = Modifier.padding(10.dp) )
         Box{

             Box(modifier = Modifier
                 .padding(top = 25.dp, start = 10.dp, end = 10.dp)
                 .drawBehind { drawRoundRect(
                     Color(0xFFD9EEF5),
                     cornerRadius = CornerRadius(10.dp.toPx())
                 ) }
                 .padding(10.dp)
                 .fillMaxWidth()
                 .height(100.dp)
             ){
                 Column {
                     Row {
                         Text(text = "Level ")
                         Text(text = "1", fontWeight = FontWeight.Bold)
                     }
                     Row{
                         Text(text = "EXP",modifier = Modifier.padding(top = 50.dp, bottom = 5.dp))
                     }
                     Box(modifier = Modifier
                         .drawBehind { drawRoundRect(
                             blackGreen,
                         cornerRadius = CornerRadius(10.dp.toPx())) }
                         .height(5.dp)
                         .width(400.dp)
                        ){}
                 }
                }


             Row(horizontalArrangement = Arrangement.Center,
                 modifier = Modifier.fillMaxWidth())
             {
                 Box(
                     contentAlignment = Alignment.Center,
                     modifier = Modifier
                         .drawBehind { drawRoundRect(
                             Color(0xFFA4CEB7),
                             cornerRadius = CornerRadius(10.dp.toPx())
                         ) }
                         .height(75.dp)
                         .width(75.dp)
                    )
                 {} // put icon here

             }
            }
            Box(modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
                .height(400.dp)
                .background(Color(0xFFF4F4F4)),
                contentAlignment = Alignment.TopCenter
            ){
                Text(text = "No posts available"
                    , color = Color.LightGray
                    , fontSize = 20.sp
                    ,fontFamily = soraFamily
                    , fontWeight = FontWeight.Bold
                    , modifier = Modifier.padding(top = 20.dp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PageProfileScreenPreview() {
    val navController = rememberNavController()
    PageProfileScreen(navController = navController)
}