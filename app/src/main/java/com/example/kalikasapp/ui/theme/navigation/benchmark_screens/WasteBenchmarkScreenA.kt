package com.example.kalikasapp.ui.theme.navigation.benchmark_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.kalikasapp.R
import com.example.kalikasapp.ui.theme.navigation.Screen
import com.example.kalikasapp.ui.theme.robotoFamily

@Composable
fun WasteBenchmarkScreenA(navController: NavController) {
    BenchmarkWasteScreen(
        navController, { WasteQuestionsSetA() }, Screen.WasteBenchmarkScreenB.route,
    )
}

@Composable
fun WasteQuestionsSetA() {
    Card(
        modifier = Modifier
            .absolutePadding(20.dp, 20.dp, 20.dp, 20.dp)
            .alpha(0.8f),
        colors = CardDefaults.cardColors(
            containerColor = wasteBenchmarkCard
        )
    ) {
        Column(
            modifier = Modifier
                .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // waste benchmark Q1
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = wasteBenchmarks[0],
                    color = wasteBenchmarkText,
                    fontSize = 16.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                WasteDropDown(
                    items = wasteWeightOpts,
                    fxn = {
                        selectedItem -> benchmarkWasteFootprint.organicWeight = selectedItem
                    }
                )
            }

            // waste benchmark Q2
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = wasteBenchmarks[1],
                    color = wasteBenchmarkText,
                    fontSize = 16.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                WasteDropDown(
                    items = wasteRecycledOpts,
                    fxn = {
                        selectedItem -> benchmarkWasteFootprint.recycledOrganic = selectedItem
                    }
                )
            }

            Image(
                painter = painterResource(R.drawable.wastebench_a),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WasteBenchmarkScreenAPreview() {
    val navController = rememberNavController()
    WasteBenchmarkScreenA(navController = navController)
}
