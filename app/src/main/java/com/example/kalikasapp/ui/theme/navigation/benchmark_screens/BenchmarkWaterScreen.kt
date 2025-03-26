package com.example.kalikasapp.ui.theme.navigation.benchmark_screens

import androidx.compose.foundation.Image
import androidx.compose.material.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kalikasapp.R
import com.example.kalikasapp.ui.theme.montserratFamily
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.WaterFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.waterCategoryCard
import com.example.kalikasapp.ui.theme.robotoFamily

val waterTopBgColor = Color(0XFF0F2D4C)
val waterTopMidBgColor = Color(0XFF194A7D)
val waterBotMidBgColor = Color(0XFF458EDA)
val waterBotBgColor = Color(0XFF76ACE4)
val waterBenchmarkCard = Color(0XFFC8DDF4)
val waterBenchmarkText = Color(0xFF05101B)
val waterBackButtonContent = Color(0XFF1F5D9E)
val waterToggleButtonContainer = Color(0XFF76ACE4)
val waterToggleButtonContent = Color(0XFF1F5D9E)
val waterDropdownContainer = Color(0XFF76ACE4)
val waterDropdownContent = Color(0XFF1F5D9E)

var benchmarkWaterFootprint = WaterFootprint()

@Composable
fun BenchmarkWaterScreen(
    navController: NavController, benchmarkQuestions: @Composable () -> Unit, nextRoute: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        waterTopBgColor, waterTopMidBgColor,
                        waterBotMidBgColor, waterBotBgColor
                    )
                )
            )
    ) {
        BenchmarksOverlay(
            modifier = Modifier, waterCategoryCard
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            BenchmarksCategoryDisplay(
                benchmarksCategory = "Let's Check Your\nWater Consumptions",
                textColor = waterBenchmarkText,
                cardColor = waterBenchmarkCard
            )

            // change benchmark questions for each screen
            benchmarkQuestions()

            // change next route for each screen
            BenchmarksNextButton(
                navController, nextRoute,
                waterBackButtonContent
            )
        }
    }
}

// modifiable to other categories
@Composable
fun WaterCounterToggle(fxn: (Int) -> Unit) {
    var count by rememberSaveable { mutableIntStateOf(1) }

    Row(
        modifier = Modifier.width(130.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = {
                if (count > 1) {
                    count--
                    fxn(count)
                }
            },
            colors = ButtonDefaults.buttonColors(
                waterToggleButtonContainer, waterToggleButtonContent,
                waterToggleButtonContainer, waterToggleButtonContent
            ),
            shape = CircleShape,
            modifier = Modifier.size(40.dp)
        ) {
            Text(
                text = "–",
                textAlign = TextAlign.Center,
                color = waterBenchmarkText,
                fontSize = 20.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
        }

        Text(
            text = "$count",
            textAlign = TextAlign.Center,
            color = waterBenchmarkText,
            fontSize = 20.sp,
            fontFamily = robotoFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
        )

        Button(
            onClick = {
                if (count < 50) {
                    count++
                    fxn(count)
                }
            },
            colors = ButtonDefaults.buttonColors(
                waterToggleButtonContainer, waterToggleButtonContent,
                waterToggleButtonContainer, waterToggleButtonContent
            ),
            shape = CircleShape,
            modifier = Modifier.size(40.dp)
        ) {
            Text(
                text = "+",
                textAlign = TextAlign.Center,
                color = waterBenchmarkText,
                fontSize = 18.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
        }
    }
}

// modifiable to other categories
@Composable
fun WaterDropDown(items: List<String>, fxn: (String) -> Unit) {
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
                waterDropdownContainer, waterDropdownContent,
                waterDropdownContainer, waterDropdownContent
            )
        ) {
            Text(
                text = selectedItem,
                textAlign = TextAlign.Center,
                color = waterBenchmarkText,
                fontSize = 12.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(waterDropdownContainer)
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
                        color = waterBenchmarkText,
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

// package-level composable
@Composable
fun BenchmarksOverlay(
    modifier: Modifier, bgColor: Color
) {
    val image = painterResource(R.drawable.overlay)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            colorFilter = ColorFilter.tint(bgColor)
        )
    }
}

// package-level composable
@Composable
fun BenchmarksNextButton(
    navController: NavController, route: String, contentColor: Color
) {
    Scaffold(
        containerColor = Color.Transparent,
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(route)
                },
                shape = CircleShape,
                containerColor = Color.Transparent,
                contentColor = contentColor
            ) {
                Box(
                    modifier = Modifier.size(80.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowForward,
                        null,
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
        ) {}
    }
}

// package-level composable
@Composable
fun BenchmarksCategoryDisplay(
    benchmarksCategory: String, textColor: Color, cardColor: Color
) {
    Card(
        modifier = Modifier
            .absolutePadding(20.dp, 20.dp, 20.dp, 20.dp)
            .height(100.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardColor
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = benchmarksCategory,
                color = textColor,
                fontSize = 24.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
            )
        }
    }
}

// back button not necessary to implement for now
/*
@Composable
fun BenchmarksBackButton(
    navController: NavController, route: String,
    containerColor: Color, contentColor: Color
) {
    Row(
        modifier = Modifier
            .absolutePadding(20.dp, 20.dp, 20.dp, 20.dp)
    ) {
        ElevatedButton(
            onClick = {
                navController.navigate(route)
            },
            colors = elevatedButtonColors(
                containerColor, contentColor, containerColor, contentColor
            ),
            modifier = Modifier
                .width(75.dp)
                .height(50.dp)
                .clip(shape = RoundedCornerShape(10.dp))
        ) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
        }
    }
}
*/
