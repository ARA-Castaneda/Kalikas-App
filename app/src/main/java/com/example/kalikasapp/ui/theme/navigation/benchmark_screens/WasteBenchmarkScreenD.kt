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
fun WasteBenchmarkScreenD(navController: NavController) {
    BenchmarkWasteScreen(
        navController, { WasteQuestionsSetD() }, Screen.BenchmarkDoneScreen.route,
    )
}

@Composable
fun WasteQuestionsSetD() {
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
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // waste benchmark Q7
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = wasteBenchmarks[6],
                    color = wasteBenchmarkText,
                    fontSize = 16.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                WasteDropDown(
                    items = wasteWeightOpts,
                    fxn = {
                        selectedItem -> benchmarkWasteFootprint.nonbioWeight = selectedItem
                    }
                )
            }

            // waste benchmark Q8
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = wasteBenchmarks[7],
                    color = wasteBenchmarkText,
                    fontSize = 16.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                WasteDropDown(
                    items = wasteRecycledOpts,
                    fxn = {
                        selectedItem -> benchmarkWasteFootprint.recycledNonBio = selectedItem
                    }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WasteBenchmarkScreenDPreview() {
    val navController = rememberNavController()
    WasteBenchmarkScreenD(navController = navController)
}
