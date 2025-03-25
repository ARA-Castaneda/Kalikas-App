package com.example.kalikasapp.ui.theme.navigation.benchmark_screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.kalikasapp.ui.theme.navigation.Screen
import com.example.kalikasapp.ui.theme.robotoFamily

@Composable
fun EnergyBenchmarkScreenD(navController: NavController) {
    BenchmarkEnergyScreen(
        navController, { EnergyQuestionsSetD() },  Screen.TranspoBenchmarkScreenA.route,
    )
}

@Composable
fun EnergyQuestionsSetD() {
    Card(
        modifier = Modifier
            .absolutePadding(20.dp, 20.dp, 20.dp, 20.dp)
            .alpha(0.8f),
        colors = CardDefaults.cardColors(
            containerColor = energyBenchmarkCard
        )
    ) {
        Column(
            modifier = Modifier
                .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                modifier = Modifier
                    .absolutePadding(10.dp, 0.dp, 10.dp, 10.dp)
                    .height(60.dp),
                colors = CardDefaults.cardColors(
                    containerColor = energyTopBgColor.copy(alpha = 0.6f)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "How many sets of each are\nin your household?",
                        color = energyBenchmarkText,
                        fontSize = 18.sp,
                        fontFamily = robotoFamily,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                    )
                }
            }

            // energy benchmark Q14
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = energyBenchmarks[13],
                    color = energyBenchmarkText,
                    fontSize = 16.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                EnergyCounterToggle(
                    fxn = {
                        count -> benchmarkEnergyFootprint.dispenserCountUnplugged.t1 = count
                    }
                )
            }

            // energy benchmark Q15
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = energyBenchmarks[14],
                    color = energyBenchmarkText,
                    fontSize = 16.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                EnergyCounterToggle(
                    fxn = {
                        count -> benchmarkEnergyFootprint.kettleCountUnplugged.t1 = count
                    }
                )
            }

            // energy benchmark Q16
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = energyBenchmarks[15],
                    color = energyBenchmarkText,
                    fontSize = 16.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                EnergyCounterToggle(
                    fxn = {
                        count -> benchmarkEnergyFootprint.washingmachineCountUnplugged.t1 = count
                    }
                )
            }

            // energy benchmark Q17
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = energyBenchmarks[16],
                    color = energyBenchmarkText,
                    fontSize = 16.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                EnergyCounterToggle(
                    fxn = {
                        count -> benchmarkEnergyFootprint.dryerCountUnplugged.t1 = count
                    }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun EnergyBenchmarkScreenDPreview() {
    val navController = rememberNavController()
    EnergyBenchmarkScreenD(navController = navController)
}
