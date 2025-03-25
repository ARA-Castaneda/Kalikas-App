package com.example.kalikasapp.ui.theme.navigation.benchmark_screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.kalikasapp.ui.theme.navigation.Screen
import com.example.kalikasapp.ui.theme.robotoFamily

@Composable
fun WaterBenchmarkScreenC(navController: NavController) {
    BenchmarkWaterScreen(
        navController, { WaterQuestionsSetC() }, Screen.EnergyBenchmarkScreenA.route,
    )
}

@Composable
fun WaterQuestionsSetC() {
    Card(
        modifier = Modifier
            .absolutePadding(20.dp, 20.dp, 20.dp, 20.dp)
            .alpha(0.8f),
        colors = CardDefaults.cardColors(
            containerColor = waterBenchmarkCard
        )
    ) {
        Column(
            modifier = Modifier
                .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // water benchmark Q8
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = waterBenchmarks[7],
                    color = waterBenchmarkText,
                    fontSize = 16.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                WaterDropDown(
                    items = waterOpts8,
                    fxn = {
                        selectedItem -> benchmarkWaterFootprint.laundryContrib.t1 = selectedItem
                    }
                )
            }

            // water benchmark Q9
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = waterBenchmarks[8],
                    color = waterBenchmarkText,
                    fontSize = 16.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                WaterDropDown(
                    items = waterOpts9,
                    fxn = {
                        selectedItem -> if (selectedItem == "own washing machine") {
                            benchmarkWaterFootprint.laundryContrib.t2 = "own"
                        } else {
                            benchmarkWaterFootprint.laundryContrib.t2 = "laundromat"
                        }
                    }
                )
            }

            // water benchmark Q10
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = waterBenchmarks[9],
                    color = waterBenchmarkText,
                    fontSize = 16.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                WaterDropDown(
                    items = waterOpts10,
                    fxn = {
                        selectedItem -> benchmarkWaterFootprint.laundryContrib.t3 = selectedItem
                    }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WaterBenchmarkScreenCPreview() {
    val navController = rememberNavController()
    WaterBenchmarkScreenC(navController = navController)
}
