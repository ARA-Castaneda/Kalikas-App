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
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.TranspoFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.transpoCategoryCard
import com.example.kalikasapp.ui.theme.robotoFamily

val transpoTopBgColor = Color(0XFF563C8B)
val transpoTopMidBgColor = Color(0XFF704FB3)
val transpoBotMidBgColor = Color(0XFFBEAFDC)
val transpoBotBgColor = Color(0XFFDFD8EE)
val transpoBenchmarkCard = Color(0XFFD4CAE8)
val transpoBenchmarkText = Color(0xFF0A0710)
val transpoBackButtonContent = Color(0XFF866ABF)
val transpoToggleButtonContainer = Color(0XFFDFD8EE)
val transpoToggleButtonContent = Color(0XFF866ABF)
val transpoDropdownContainer = Color(0XFFDFD8EE)
val transpoDropdownContent = Color(0XFF866ABF)

var benchmarkTranspoFootprint = TranspoFootprint()

@Composable
fun BenchmarkTranspoScreen(
    navController: NavController, benchmarkQuestions: @Composable () -> Unit, nextRoute: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        transpoTopBgColor, transpoTopMidBgColor,
                        transpoBotMidBgColor, transpoBotBgColor
                    )
                )
            )
    ) {
        BenchmarksOverlay(
            modifier = Modifier, transpoCategoryCard
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            BenchmarksCategoryDisplay(
                benchmarksCategory = "Let's Check Your\nTranspo Consumptions",
                textColor = transpoBenchmarkText,
                cardColor = transpoBenchmarkCard
            )

            // change benchmark questions for each screen
            benchmarkQuestions()

            // change next route for each screen
            BenchmarksNextButton(
                navController, nextRoute,
                transpoBackButtonContent
            )
        }
    }
}

@Composable
fun TranspoDropDown(items: List<String>, fxn: (String) -> Unit) {
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
                transpoDropdownContainer, transpoDropdownContent,
                transpoDropdownContainer, transpoDropdownContent
            )
        ) {
            Text(
                text = selectedItem,
                textAlign = TextAlign.Center,
                color = transpoBenchmarkText,
                fontSize = 12.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(transpoDropdownContainer)
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
                        color = transpoBenchmarkText,
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
