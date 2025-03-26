package com.example.kalikasapp.ui.theme.navigation.benchmark_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.kalikasapp.R
import com.example.kalikasapp.ui.theme.navigation.Screen
import com.example.kalikasapp.ui.theme.robotoFamily

@Composable
fun TranspoBenchmarkScreenB(navController: NavController) {
    BenchmarkTranspoScreen(
        navController, { TranspoQuestionsSetB() }, Screen.FoodBenchmarkScreenA.route,
    )
}

@Composable
fun TranspoQuestionsSetB() {
    Card(
        modifier = Modifier
            .absolutePadding(20.dp, 20.dp, 20.dp, 20.dp)
            .alpha(0.8f),
        colors = CardDefaults.cardColors(
            containerColor = transpoBenchmarkCard
        )
    ) {
        Column(
            modifier = Modifier
                .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .absolutePadding(10.dp, 0.dp, 10.dp, 10.dp)
                    .height(60.dp),
                colors = CardDefaults.cardColors(
                    containerColor = transpoTopBgColor.copy(alpha = 0.6f)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "How long does it take to reach\n your destination using ...",
                        color = transpoBenchmarkText,
                        fontSize = 18.sp,
                        fontFamily = robotoFamily,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                    )
                }
            }

            // transpo benchmark Q5
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = transpoBenchmarks[4],
                    color = transpoBenchmarkText,
                    fontSize = 16.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                TranspoDropDown(
                    items = transpoOpts,
                    fxn = {
                        selectedItem ->

                        var newSelected = ""
                        newSelected = when (selectedItem) {
                            "mode not used" -> "0 mins"
                            "less than 30 mins" -> "30 mins"
                            "30 mins to 1 hour" -> "60 mins"
                            "1 hour to 2 hours" -> "90 mins"
                            "2 hours to 3 hours" -> "150 mins"
                            "more than 3 hours" -> "200 mins"
                            else -> "0 mins"
                        }
                        benchmarkTranspoFootprint.busDuration = newSelected
                    }
                )
            }

            // transpo benchmark Q6
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = transpoBenchmarks[5],
                    color = transpoBenchmarkText,
                    fontSize = 16.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                TranspoDropDown(
                    items = transpoOpts,
                    fxn = {
                        selectedItem ->

                        var newSelected = ""
                        newSelected = when (selectedItem) {
                            "mode not used" -> "0 mins"
                            "less than 30 mins" -> "30 mins"
                            "30 mins to 1 hour" -> "60 mins"
                            "1 hour to 2 hours" -> "90 mins"
                            "2 hours to 3 hours" -> "150 mins"
                            "more than 3 hours" -> "200 mins"
                            else -> "0 mins"
                        }
                        benchmarkTranspoFootprint.puvDuration = newSelected
                    }
                )
            }

            // transpo benchmark Q7
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = transpoBenchmarks[6],
                    color = transpoBenchmarkText,
                    fontSize = 16.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                TranspoDropDown(
                    items = transpoOpts,
                    fxn = {
                        selectedItem ->

                        var newSelected = ""
                        newSelected = when (selectedItem) {
                            "mode not used" -> "0 mins"
                            "less than 30 mins" -> "30 mins"
                            "30 mins to 1 hour" -> "60 mins"
                            "1 hour to 2 hours" -> "90 mins"
                            "2 hours to 3 hours" -> "150 mins"
                            "more than 3 hours" -> "200 mins"
                            else -> "0 mins"
                        }
                        benchmarkTranspoFootprint.tricycleDuration = newSelected
                    }
                )
            }

            Image(
                painter = painterResource(R.drawable.transpobench_b),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TranspoBenchmarkScreenBPreview() {
    val navController = rememberNavController()
    TranspoBenchmarkScreenB(navController = navController)
}
