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

var userMonthlyCarbonFootprint = userCarbonFootprint.total

var userMonthlyWater = String.format(Locale.US, "%.2f",
    (userCarbonFootprint.water / userCarbonFootprint.total) * 100.0f
).toFloat()

var userMonthlyEnergy = String.format(Locale.US, "%.2f",
    (userCarbonFootprint.energy / userCarbonFootprint.total) * 100.0f
).toFloat()

var userMonthlyTranspo = String.format(Locale.US, "%.2f",
    (userCarbonFootprint.transpo / userCarbonFootprint.total) * 100.0f
).toFloat()

var userMonthlyFood = String.format(Locale.US, "%.2f",
    (userCarbonFootprint.food / userCarbonFootprint.total) * 100.0f
).toFloat()

var userMonthlyWaste = String.format(Locale.US, "%.2f",
    (userCarbonFootprint.waste / userCarbonFootprint.total) * 100.0f
).toFloat()

var userMonthlies = listOf(
    FootprintModel(userMonthlyWater, waterPrint),
    FootprintModel(userMonthlyEnergy, energyPrint),
    FootprintModel(userMonthlyTranspo, transpoPrint),
    FootprintModel(userMonthlyFood, foodPrint),
    FootprintModel(userMonthlyWaste, wastePrint)
)

@Composable
fun FootprintMonthlyScreen(navController: NavController) {
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
                            MonthlyWaterLogsButton(navController)
                            MonthlyEnergyLogsButton(navController)
                            MonthlyTranspoLogsButton(navController)
                            MonthlyFoodLogsButton(navController)
                        }

                        Column(
                            modifier = Modifier.height(310.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            MonthlyWasteLogsButton(navController)
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

                                FootprintPieChart(userMonthlies)
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
                    MonthlyCarbonFootprint()
                }
            }
        }
    )
}

@Composable
fun MonthlyCarbonFootprint() {
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
                text = "CO2 per month",
                textAlign = TextAlign.Center,
                color = Color.DarkGray,
                fontSize = 20.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Text(
                text = String.format(Locale.US, "%.2f", userMonthlyCarbonFootprint)
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
fun MonthlyWaterLogsButton(navController: NavController){
    val monthlyWater = String.format(Locale.US, "%.2f",
        (userCarbonFootprint.water)
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
                text = "$userMonthlyWater%",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Text(
                text = "$monthlyWater CO2\nper liter",
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
fun MonthlyEnergyLogsButton(navController: NavController){
    val monthlyEnergy = String.format(Locale.US, "%.2f",
        (userCarbonFootprint.energy)).toFloat()

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
                text = "$userMonthlyEnergy%",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Text(
                text = "$monthlyEnergy CO2\nx kWh",
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
fun MonthlyTranspoLogsButton(navController: NavController){
    val monthlyTranspo = String.format(Locale.US, "%.2f",
        (userCarbonFootprint.transpo)).toFloat()

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
                text = "$userMonthlyTranspo%",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Text(
                text = "$monthlyTranspo CO2\nper km",
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
fun MonthlyFoodLogsButton(navController: NavController){
    val monthlyFood = String.format(Locale.US, "%.2f",
        (userCarbonFootprint.food)).toFloat()

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
                text = "$userMonthlyFood%",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Text(
                text = "$monthlyFood CO2\nper plate",
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
fun MonthlyWasteLogsButton(navController: NavController){
    val monthlyWaste = String.format(Locale.US, "%.2f",
        (userCarbonFootprint.waste)).toFloat()

    Row(
        modifier = Modifier.width(140.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LogFootprintButton(
            painterResource(R.drawable.carbonwaste),
            "waste", wastePrint, navController, Screen.FootprintLoggerWasteScreen.route
        )

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$userMonthlyWaste%",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Text(
                text = "$monthlyWaste CO2\nx kg",
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
fun FootprintMonthlyScreenPreview() {
    val navController = rememberNavController()
    FootprintMonthlyScreen(navController = navController)
}
