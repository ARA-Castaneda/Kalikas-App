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
fun FoodBenchmarkScreenC(navController: NavController) {
    BenchmarkFoodScreen(
        navController, { FoodQuestionsSetC() }, Screen.WasteBenchmarkScreenA.route,
    )
}

@Composable
fun FoodQuestionsSetC() {
    Card(
        modifier = Modifier
            .absolutePadding(20.dp, 20.dp, 20.dp, 20.dp)
            .alpha(0.8f),
        colors = CardDefaults.cardColors(
            containerColor = foodBenchmarkCard
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
                    containerColor = foodTopBgColor.copy(alpha = 0.6f)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "How many servings of each\ndo you eat per week?",
                        color = foodBenchmarkText,
                        fontSize = 18.sp,
                        fontFamily = robotoFamily,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                    )
                }
            }

            // food benchmark Q9
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = foodBenchmarks[8],
                    color = foodBenchmarkText,
                    fontSize = 16.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                FoodDropDown(
                    items = foodOpts,
                    fxn = {
                        selectedItem -> benchmarkFoodFootprint.riceServings = selectedItem
                    }
                )
            }

            // food benchmark Q10
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = foodBenchmarks[9],
                    color = foodBenchmarkText,
                    fontSize = 16.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                FoodDropDown(
                    items = foodOpts,
                    fxn = {
                        selectedItem -> benchmarkFoodFootprint.fruitServings = selectedItem
                    }
                )
            }

            // food benchmark Q11
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = foodBenchmarks[10],
                    color = foodBenchmarkText,
                    fontSize = 16.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                FoodDropDown(
                    items = foodOpts,
                    fxn = {
                        selectedItem -> benchmarkFoodFootprint.vegetableServings = selectedItem
                    }
                )
            }

            // food benchmark Q12
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = foodBenchmarks[11],
                    color = foodBenchmarkText,
                    fontSize = 16.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                FoodDropDown(
                    items = foodOpts,
                    fxn = {
                        selectedItem -> benchmarkFoodFootprint.wheatServings = selectedItem
                    }
                )
            }

            Image(
                painter = painterResource(R.drawable.foodbench_c),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FoodBenchmarkScreenCPreview() {
    val navController = rememberNavController()
    FoodBenchmarkScreenC(navController = navController)
}
