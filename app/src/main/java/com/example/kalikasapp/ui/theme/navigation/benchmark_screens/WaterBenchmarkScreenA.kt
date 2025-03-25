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
fun WaterBenchmarkScreenA(navController: NavController) {
    BenchmarkWaterScreen(
        navController, { WaterQuestionsSetA() }, Screen.WaterBenchmarkScreenB.route,
    )
}

@Composable
fun WaterQuestionsSetA() {
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
            // water benchmark Q1
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = waterBenchmarks[0],
                    color = waterBenchmarkText,
                    fontSize = 16.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                WaterCounterToggle(
                    fxn = {
                        count -> benchmarkWaterFootprint.household = count
                    }
                )
            }

            // water benchmark Q2
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = waterBenchmarks[1],
                    color = waterBenchmarkText,
                    fontSize = 16.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                WaterDropDown(
                    items = waterOpts2,
                    fxn = {
                        selectedItem -> benchmarkWaterFootprint.showerDuration = selectedItem
                    }
                )
            }

            // water benchmark Q3
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = waterBenchmarks[2],
                    color = waterBenchmarkText,
                    fontSize = 16.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                WaterDropDown(
                    items = waterOpts3,
                    fxn = {
                        selectedItem -> benchmarkWaterFootprint.sinkDuration = selectedItem
                    }
                )
            }

            // water benchmark Q4
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = waterBenchmarks[3],
                    color = waterBenchmarkText,
                    fontSize = 16.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                WaterDropDown(
                    items = waterOpts4,
                    fxn = {
                        selectedItem -> benchmarkWaterFootprint.toiletUsage = selectedItem
                    }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WaterBenchmarkScreenAPreview() {
    val navController = rememberNavController()
    WaterBenchmarkScreenA(navController = navController)
}
