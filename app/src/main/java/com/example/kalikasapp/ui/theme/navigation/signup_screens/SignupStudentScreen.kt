package com.example.kalikasapp.ui.theme.navigation.signup_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults.elevatedButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kalikasapp.ui.theme.Account_circle
import com.example.kalikasapp.ui.theme.App_registration
import com.example.kalikasapp.ui.theme.navigation.Screen
import com.example.kalikasapp.ui.theme.soraFamily

@Composable
fun SignupStudentScreen(navController: NavController) {
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    // val darkGreen = Color(0xFF15472B)
    val green = Color(0xFF1E653E)
    // val lightGreen = Color(0xFF39C076)
    // val lightBlue = Color(0xFF9FE3BE)
    val blackGreen = Color(0xFF113822)
    val whiteGreen = Color(0xFFFAFEFC)

    Box(
        modifier = Modifier
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
                        navController.navigate(Screen.AppSignupScreen.route)
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

            Row(
                modifier = Modifier
                    .absolutePadding(20.dp, 0.dp, 20.dp, 0.dp)
                    .width(150.dp)
                    .height(40.dp)
                    .background(green)
            ) {
                Icon(
                    imageVector = Account_circle,
                    tint = Color.White,
                    contentDescription = null,
                    modifier = Modifier.absolutePadding(38.dp, 8.dp, 0.dp, 0.dp)
                )
                Text(
                    text = " Student",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.absolutePadding(0.dp, 11.dp, 0.dp, 0.dp)
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .absolutePadding(20.dp, 40.dp, 20.dp, 20.dp)
                    .fillMaxSize()
            ) {
                OutlinedTextField(
                    value = firstName,
                    onValueChange = { firstName = it },
                    label = { Text("First Name") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = blackGreen,
                        unfocusedTextColor = blackGreen,
                        focusedBorderColor = blackGreen,
                        unfocusedBorderColor = blackGreen)
                )

                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = lastName,
                    onValueChange = { lastName = it },
                    label = { Text("Last Name") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = blackGreen,
                        unfocusedTextColor = blackGreen,
                        focusedBorderColor = blackGreen,
                        unfocusedBorderColor = blackGreen)
                )

                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = blackGreen,
                        unfocusedTextColor = blackGreen,
                        focusedBorderColor = blackGreen,
                        unfocusedBorderColor = blackGreen)
                )

                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = blackGreen,
                        unfocusedTextColor = blackGreen,
                        focusedBorderColor = blackGreen,
                        unfocusedBorderColor = blackGreen),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Confirm Password") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = blackGreen,
                        unfocusedTextColor = blackGreen,
                        focusedBorderColor = blackGreen,
                        unfocusedBorderColor = blackGreen),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                Spacer(modifier = Modifier.height(60.dp))
                TextButton(
                    onClick = {
                        navController.navigate(Screen.AppLoginScreen.route)
                    }
                ) {
                    Text(
                        text = "Already have an account?",
                        textDecoration = TextDecoration.Underline,
                        color = blackGreen
                    )
                }

                ElevatedButton(
                    onClick = {
                        navController.navigate(Screen.AppBenchmarkScreen.route)
                    },
                    colors = elevatedButtonColors(green, Color.White, green, Color.White),
                    modifier = Modifier
                        .width(250.dp)
                        .height(50.dp)
                ) {
                    Icon(imageVector = App_registration, null)
                    Text(text = " Sign Up", color = Color.White)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SignupStudentScreenPreview() {
    val navController = rememberNavController()
    SignupStudentScreen(navController = navController)
}
