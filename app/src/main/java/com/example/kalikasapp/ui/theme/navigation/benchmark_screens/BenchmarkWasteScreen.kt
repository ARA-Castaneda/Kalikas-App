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
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.WasteFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.wasteCategoryCard
import com.example.kalikasapp.ui.theme.robotoFamily

val wasteTopBgColor = Color(0XFF61332B)
val wasteTopMidBgColor = Color(0XFF8A483D)
val wasteBotMidBgColor = Color(0XFFCA9086)
val wasteBotBgColor = Color(0XFFDCB6AF)
val wasteBenchmarkCard = Color(0XFFE8CFCA)
val wasteBenchmarkText = Color(0xFF0F0807)
val wasteBackButtonContent = Color(0XFFA55649)
val wasteToggleButtonContainer = Color(0XFFDCB6AF)
val wasteToggleButtonContent = Color(0XFFA55649)
val wasteDropdownContainer = Color(0XFFDCB6AF)
val wasteDropdownContent = Color(0XFFA55649)

var benchmarkWasteFootprint = WasteFootprint()

@Composable
fun BenchmarkWasteScreen(
    navController: NavController, benchmarkQuestions: @Composable () -> Unit, nextRoute: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        wasteTopBgColor, wasteTopMidBgColor,
                        wasteBotMidBgColor, wasteBotBgColor
                    )
                )
            )
    ) {
        BenchmarksOverlay(
            modifier = Modifier, wasteCategoryCard
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            BenchmarksCategoryDisplay(
                benchmarksCategory = "Let's Check Your\nWaste Productions",
                textColor = wasteBenchmarkText,
                cardColor = wasteBenchmarkCard
            )

            // change benchmark questions for each screen
            benchmarkQuestions()

            // change next route for each screen
            BenchmarksNextButton(
                navController, nextRoute,
                wasteBackButtonContent
            )
        }
    }
}

@Composable
fun WasteDropDown(items: List<String>, fxn: (String) -> Unit) {
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
                wasteDropdownContainer, wasteDropdownContent,
                wasteDropdownContainer, wasteDropdownContent
            )
        ) {
            Text(
                text = selectedItem,
                textAlign = TextAlign.Center,
                color = wasteBenchmarkText,
                fontSize = 12.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(wasteDropdownContainer)
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
                        color = wasteBenchmarkText,
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
