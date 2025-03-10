package com.example.kalikasapp.ui.theme.navigation.footprint_screens

import com.example.kalikasapp.ui.theme.navigation.landing_screens.BottomNavBar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kalikasapp.R
import com.example.kalikasapp.ui.theme.montserratFamily
import com.example.kalikasapp.ui.theme.navigation.Screen
import com.example.kalikasapp.ui.theme.navigation.landing_screens.EcologicalFootprint
import com.example.kalikasapp.ui.theme.navigation.landing_screens.CarbonFootprint
import com.example.kalikasapp.ui.theme.navigation.landing_screens.FootprintModel
import com.example.kalikasapp.ui.theme.navigation.landing_screens.FootprintPageBackdrop
import com.example.kalikasapp.ui.theme.navigation.landing_screens.LogFootprintButton
import com.example.kalikasapp.ui.theme.navigation.landing_screens.NeededCountries
import com.example.kalikasapp.ui.theme.navigation.landing_screens.TopNavBar
import com.example.kalikasapp.ui.theme.navigation.landing_screens.energyPrint
import com.example.kalikasapp.ui.theme.navigation.landing_screens.foodPrint
import com.example.kalikasapp.ui.theme.navigation.landing_screens.transpoPrint
import com.example.kalikasapp.ui.theme.navigation.landing_screens.wastePrint
import com.example.kalikasapp.ui.theme.navigation.landing_screens.waterPrint
import com.example.kalikasapp.ui.theme.navigation.landing_screens.userCarbonFootprint
import java.util.Locale

/*
if (userDailiesProgress.waterDailies.d1.t2 || userDailiesProgress.waterDailies.d2.t2 ||
        userDailiesProgress.waterDailies.d3.t2
        ) {

    } else {

    }
*/

var userWeeklyCarbonFootprint = userCarbonFootprint.total / 4f

var userWeeklyWater = String.format(Locale.US, "%.2f",
    (userCarbonFootprint.water / userCarbonFootprint.total) * 100.0f
).toFloat()

var userWeeklyEnergy = String.format(Locale.US, "%.2f",
    (userCarbonFootprint.energy / userCarbonFootprint.total) * 100.0f
).toFloat()

var userWeeklyTranspo = String.format(Locale.US, "%.2f",
    (userCarbonFootprint.transpo / userCarbonFootprint.total) * 100.0f
).toFloat()

var userWeeklyFood = String.format(Locale.US, "%.2f",
    (userCarbonFootprint.food / userCarbonFootprint.total) * 100.0f
).toFloat()

var userWeeklyWaste = String.format(Locale.US, "%.2f",
    (userCarbonFootprint.waste / userCarbonFootprint.total) * 100.0f
).toFloat()

var userWeeklies = listOf(
    FootprintModel(userWeeklyWater, waterPrint),
    FootprintModel(userWeeklyEnergy, energyPrint),
    FootprintModel(userWeeklyTranspo, transpoPrint),
    FootprintModel(userWeeklyFood, foodPrint),
    FootprintModel(userWeeklyWaste, wastePrint)
)

@Composable
fun FootprintWeeklyScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomNavBar(navController)
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    FootprintPageBackdrop(modifier = Modifier)
                    TopNavBar(navController)

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .absolutePadding(20.dp, 100.dp, 20.dp, 0.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            modifier = Modifier,
                            verticalArrangement = Arrangement.SpaceEvenly,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            WeeklyWaterLogsButton(navController)
                            WeeklyEnergyLogsButton(navController)
                            WeeklyTranspoLogsButton(navController)
                            WeeklyFoodLogsButton(navController)
                        }

                        Column(
                            modifier = Modifier.height(310.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            WeeklyWasteLogsButton(navController)
                            Box(
                                modifier = Modifier
                                    .absolutePadding(0.dp, 40.dp, 20.dp, 0.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Footprint by\nCategory",
                                    textAlign = TextAlign.Center,
                                    color = Color.White,
                                    fontSize = 16.sp,
                                    fontFamily = montserratFamily,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                )

                                FootprintPieChart(userWeeklies)
                            }
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .absolutePadding(20.dp, 430.dp, 20.dp, 0.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        EcologicalFootprint()
                        NeededCountries()
                    }

                    CarbonFootprint()
                    WeeklyCarbonFootprint()
                }
            }
        }
    )
}

@Composable
fun WeeklyCarbonFootprint() {
    Column(
        modifier = Modifier
            .absolutePadding(200.dp, 644.dp, 20.dp, 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "CO2 per week",
                textAlign = TextAlign.Center,
                color = Color.DarkGray,
                fontSize = 20.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Text(
                text = String.format(Locale.US, "%.2f", userWeeklyCarbonFootprint)
                    .toFloat().toString(),
                textAlign = TextAlign.Center,
                color = Color.DarkGray,
                fontSize = 30.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Text(
                text = "kilograms",
                textAlign = TextAlign.Center,
                color = Color.DarkGray,
                fontSize = 14.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun WeeklyWaterLogsButton(navController: NavController){
    val weeklyWater = String.format(Locale.US, "%.2f",
        (userCarbonFootprint.water / 4f)
    ).toFloat()

    Row(
        modifier = Modifier.width(140.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LogFootprintButton(
            painterResource(R.drawable.carbonwater),
            "water", waterPrint, navController, Screen.FootprintLoggerWaterScreen.route
        )

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$userWeeklyWater%",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Text(
                text = "$weeklyWater CO2\nper liter",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 12.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun WeeklyEnergyLogsButton(navController: NavController){
    val weeklyEnergy = String.format(Locale.US, "%.2f",
        (userCarbonFootprint.energy / 4f)).toFloat()

    Row(
        modifier = Modifier.width(140.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LogFootprintButton(
            painterResource(R.drawable.carbonenergy),
            "energy", energyPrint, navController, Screen.FootprintLoggerEnergyScreen.route
        )

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$userWeeklyEnergy%",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Text(
                text = "$weeklyEnergy CO2\nx kWh",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 12.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun WeeklyTranspoLogsButton(navController: NavController){
    val weeklyTranspo = String.format(Locale.US, "%.2f",
        (userCarbonFootprint.transpo / 4f)).toFloat()

    Row(
        modifier = Modifier.width(140.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LogFootprintButton(
            painterResource(R.drawable.carbontranspo),
            "transpo", transpoPrint, navController, Screen.FootprintLoggerTranspoScreen.route
        )

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$userWeeklyTranspo%",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Text(
                text = "$weeklyTranspo CO2\nper km",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 12.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun WeeklyFoodLogsButton(navController: NavController){
    val weeklyFood = String.format(Locale.US, "%.2f",
        (userCarbonFootprint.food / 4f)).toFloat()

    Row(
        modifier = Modifier.width(140.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LogFootprintButton(
            painterResource(R.drawable.carbonfood),
            "food", foodPrint, navController, Screen.FootprintLoggerFoodScreen.route
        )

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$userWeeklyFood%",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Text(
                text = "$weeklyFood CO2\nper plate",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 12.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun WeeklyWasteLogsButton(navController: NavController){
    val weeklyWaste = String.format(Locale.US, "%.2f",
        (userCarbonFootprint.waste / 4f)).toFloat()

    Row(
        modifier = Modifier.width(140.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LogFootprintButton(
            painterResource(R.drawable.carbonwaste),
            "waste", wastePrint, navController,Screen.FootprintLoggerWasteScreen.route
        )

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$userWeeklyWaste%",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Text(
                text = "$weeklyWaste CO2\nx kg",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 12.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FootprintWeeklyScreenPreview() {
    val navController = rememberNavController()
    FootprintWeeklyScreen(navController = navController)
}
