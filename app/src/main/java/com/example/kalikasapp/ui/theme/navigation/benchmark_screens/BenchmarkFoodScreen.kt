package com.example.kalikasapp.ui.theme.navigation.benchmark_screens

import androidx.compose.material.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
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
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.FoodFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.foodCategoryCard
import com.example.kalikasapp.ui.theme.robotoFamily

val foodTopBgColor = Color(0XFFE61D23)
val foodTopMidBgColor = Color(0XFFEC5257)
val foodBotMidBgColor = Color(0XFFFACDCF)
val foodBotBgColor = Color(0XFFFDF1F1)
val foodBenchmarkCard = Color(0XFFF8BCBE)
val foodBenchmarkText = Color(0xFF150203)
val foodBackButtonContent = Color(0XFFF07579)
val foodToggleButtonContainer = Color(0XFFFDF1F1)
val foodToggleButtonContent = Color(0XFFF07579)
val foodDropdownContainer = Color(0XFFFDF1F1)
val foodDropdownContent = Color(0XFFF07579)

var benchmarkFoodFootprint = FoodFootprint()

@Composable
fun BenchmarkFoodScreen(
    navController: NavController, benchmarkQuestions: @Composable () -> Unit, nextRoute: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        foodTopBgColor, foodTopMidBgColor,
                        foodBotMidBgColor, foodBotBgColor
                    )
                )
            )
    ) {
        BenchmarksOverlay(
            modifier = Modifier, foodCategoryCard
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            BenchmarksCategoryDisplay(
                benchmarksCategory = "Let's Check Your\nFood Consumptions",
                textColor = foodBenchmarkText,
                cardColor = foodBenchmarkCard
            )

            // change benchmark questions for each screen
            benchmarkQuestions()

            // change next route for each screen
            BenchmarksNextButton(
                navController, nextRoute,
                foodBackButtonContent
            )
        }
    }
}

@Composable
fun FoodDropDown(items: List<String>, fxn: (String) -> Unit) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    var selectedItem by rememberSaveable { mutableStateOf("choose >>") }

    Box(
        modifier = Modifier
            .width(130.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { expanded = true },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                foodDropdownContainer, foodDropdownContent,
                foodDropdownContainer, foodDropdownContent
            )
        ) {
            Text(
                text = selectedItem,
                textAlign = TextAlign.Center,
                color = foodBenchmarkText,
                fontSize = 12.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(foodDropdownContainer)
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    onClick = {
                        selectedItem = item
                        expanded = false
                        fxn(selectedItem)
                    }
                ) {
                    Text(
                        text = item,
                        textAlign = TextAlign.Center,
                        color = foodBenchmarkText,
                        fontSize = 12.sp,
                        fontFamily = robotoFamily,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}
