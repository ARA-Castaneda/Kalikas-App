package com.example.kalikasapp.ui.theme.navigation.benchmark_screens

import com.example.kalikasapp.ui.theme.navigation.landing_screens.LogoImage
import com.example.kalikasapp.ui.theme.navigation.landing_screens.OverlayImage
import com.example.kalikasapp.ui.theme.navigation.landing_screens.Footprints
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition.Companion.None
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kalikasapp.ui.theme.navigation.Screen
import com.example.kalikasapp.ui.theme.soraFamily

@Composable
fun BenchmarkDoneScreen(navController: NavController) {
    var visible by remember { mutableStateOf(true) }

    val darkGreen = Color(0xFF15472B)
    val green = Color(0xFF1E653E)
    val lightGreen = Color(0xFF39C076)
    val lightBlue = Color(0xFF9FE3BE)
    val blackGreen = Color(0xFF113822)

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

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .absolutePadding(20.dp, 420.dp, 20.dp, 0.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Calculating your Footprint ...",
                color = blackGreen,
                fontSize = 36.sp,
                fontFamily = soraFamily,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(),
            exit = None
        ) {
            Box(
                modifier = Modifier
                    .absolutePadding(0.dp, 500.dp, 0.dp, 0.dp)
                    .fillMaxWidth()
            ) {
                Footprints(modifier = Modifier
                    .absolutePadding(20.dp, 0.dp, 0.dp, 0.dp)
                    .rotate(-80f)
                    .animateEnterExit(enter = fadeIn(animationSpec = tween(durationMillis = 200)))
                )
                Footprints(modifier = Modifier
                    .absolutePadding(80.dp, 10.dp, 0.dp, 0.dp)
                    .rotate(-75f)
                    .animateEnterExit(enter = fadeIn(animationSpec = tween(durationMillis = 400)))
                )
                Footprints(modifier = Modifier
                    .absolutePadding(150.dp, 20.dp, 0.dp, 0.dp)
                    .rotate(-80f)
                    .animateEnterExit(enter = fadeIn(animationSpec = tween(durationMillis = 600)))
                )
                Footprints(modifier = Modifier
                    .absolutePadding(210.dp, 10.dp, 0.dp, 0.dp)
                    .rotate(-100f)
                    .animateEnterExit(enter = fadeIn(animationSpec = tween(durationMillis = 800)))
                )
                Footprints(modifier = Modifier
                    .absolutePadding(270.dp, 10.dp, 0.dp, 0.dp)
                    .rotate(-60f)
                    .animateEnterExit(enter = fadeIn(animationSpec = tween(durationMillis = 1000)))
                )
            }
        }

        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(),
            exit = None
        ) {
            Box(
                modifier = Modifier
                    .absolutePadding(0.dp, 590.dp, 0.dp, 0.dp)
                    .fillMaxWidth()
            ) {
                Footprints(modifier = Modifier
                    .absolutePadding(280.dp, 0.dp, 0.dp, 0.dp)
                    .rotate(30f)
                    .animateEnterExit(enter = fadeIn(animationSpec = tween(durationMillis = 1200)))
                )
                Footprints(modifier = Modifier
                    .absolutePadding(210.dp, 20.dp, 0.dp, 0.dp)
                    .rotate(90f)
                    .animateEnterExit(enter = fadeIn(animationSpec = tween(durationMillis = 1400)))
                )
                Footprints(modifier = Modifier
                    .absolutePadding(150.dp, 30.dp, 0.dp, 0.dp)
                    .rotate(90f)
                    .animateEnterExit(enter = fadeIn(animationSpec = tween(durationMillis = 1600)))
                )
                Footprints(modifier = Modifier
                    .absolutePadding(70.dp, 30.dp, 0.dp, 0.dp)
                    .rotate(75f)
                    .animateEnterExit(enter = fadeIn(animationSpec = tween(durationMillis = 1800)))
                )
                Footprints(modifier = Modifier
                    .absolutePadding(25.dp, 80.dp, 0.dp, 0.dp)
                    .rotate(20f)
                    .animateEnterExit(enter = fadeIn(animationSpec = tween(durationMillis = 2000)))
                )
            }
        }

        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(),
            exit = None
        ) {
            Box(
                modifier = Modifier
                    .absolutePadding(0.dp, 710.dp, 0.dp, 0.dp)
                    .fillMaxWidth()
            ) {
                Footprints(modifier = Modifier
                    .absolutePadding(75.dp, 10.dp, 0.dp, 0.dp)
                    .rotate(-75f)
                    .animateEnterExit(enter = fadeIn(animationSpec = tween(durationMillis = 2200)))
                )
                Footprints(modifier = Modifier
                    .absolutePadding(145.dp, 20.dp, 0.dp, 0.dp)
                    .rotate(-90f)
                    .animateEnterExit(enter = fadeIn(animationSpec = tween(durationMillis = 2400)))
                )
            }
        }

        Scaffold(
            containerColor = Color.Transparent,
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = {
                LargeFloatingActionButton(
                    onClick = {
                        navController.navigate(Screen.PageProfileScreen.route)
                    },
                    shape = CircleShape,
                    containerColor = Color.Transparent,
                    contentColor = green
                ) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowForward,
                        null,
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
            ) {}
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BenchmarkDoneScreenPreview() {
    val navController = rememberNavController()
    BenchmarkDoneScreen(navController = navController)
}