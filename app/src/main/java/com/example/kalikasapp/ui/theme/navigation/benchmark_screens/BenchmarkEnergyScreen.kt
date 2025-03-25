package com.example.kalikasapp.ui.theme.navigation.benchmark_screens

import androidx.compose.material.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.EnergyFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.energyCategoryCard
import com.example.kalikasapp.ui.theme.robotoFamily

val energyTopBgColor = Color(0XFFFFB715)
val energyTopMidBgColor = Color(0XFFFFC950)
val energyBotMidBgColor = Color(0XFFFFF3D9)
val energyBotBgColor = Color(0XFFFFF9ED)
val energyBenchmarkCard = Color(0XFFFFE7B2)
val energyBenchmarkText = Color(0xFF150E00)
val energyBackButtonContent = Color(0XFFFFD577)
val energyToggleButtonContainer = Color(0XFFFFF9ED)
val energyToggleButtonContent = Color(0XFFFFD577)
val energyDropdownContainer = Color(0XFFFFF9ED)
val energyDropdownContent = Color(0XFFFFD577)

var benchmarkEnergyFootprint = EnergyFootprint()

@Composable
fun BenchmarkEnergyScreen(
    navController: NavController, benchmarkQuestions: @Composable () -> Unit, nextRoute: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        energyTopBgColor, energyTopMidBgColor,
                        energyBotMidBgColor, energyBotBgColor
                    )
                )
            )
    ) {
        BenchmarksOverlay(
            modifier = Modifier, energyCategoryCard
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            BenchmarksCategoryDisplay(
                benchmarksCategory = "Let's Check Your\nEnergy Consumptions",
                textColor = energyBenchmarkText,
                cardColor = energyBenchmarkCard
            )

            // change benchmark questions for each screen
            benchmarkQuestions()

            // change next route for each screen
            BenchmarksNextButton(
                navController, nextRoute,
                energyBackButtonContent
            )
        }
    }
}

@Composable
fun EnergyCounterToggle(fxn: (Int) -> Unit) {
    var count by rememberSaveable { mutableIntStateOf(0) }

    Row(
        modifier = Modifier.width(130.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = {
                if (count > 0) {
                    count--
                    fxn(count)
                }
            },
            colors = ButtonDefaults.buttonColors(
                energyToggleButtonContainer, energyToggleButtonContent,
                energyToggleButtonContainer, energyToggleButtonContent
            ),
            shape = CircleShape,
            modifier = Modifier.size(40.dp)
        ) {
            Text(
                text = "–",
                textAlign = TextAlign.Center,
                color = energyBenchmarkText,
                fontSize = 20.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
        }

        Text(
            text = "$count",
            textAlign = TextAlign.Center,
            color = energyBenchmarkText,
            fontSize = 20.sp,
            fontFamily = robotoFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
        )

        Button(
            onClick = {
                if (count < 50) {
                    count++
                    fxn(count)
                }
            },
            colors = ButtonDefaults.buttonColors(
                energyToggleButtonContainer, energyToggleButtonContent,
                energyToggleButtonContainer, energyToggleButtonContent
            ),
            shape = CircleShape,
            modifier = Modifier.size(40.dp)
        ) {
            Text(
                text = "+",
                textAlign = TextAlign.Center,
                color = energyBenchmarkText,
                fontSize = 18.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
        }
    }
}
