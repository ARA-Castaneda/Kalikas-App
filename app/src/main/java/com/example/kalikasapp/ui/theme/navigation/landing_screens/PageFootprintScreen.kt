package com.example.kalikasapp.ui.theme.navigation.landing_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
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
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.CarbonFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.ChallengesProgress
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.DailiesProgress
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.FootprintPieChart
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.adjustEnergyEmission
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.adjustFoodEmission
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.adjustTranspoEmission
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.adjustWasteEmission
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.adjustWaterEmission
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.userEcoFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.userCarbonFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.userDailiesDone
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.userRecalcCarbonFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.userRecalcEnergyFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.userRecalcFoodFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.userRecalcTranspoFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.userRecalcWasteFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.userRecalcWaterFootprint
import java.util.Locale

data class TopNavigationItem(
    var route: String,
    var selectedIcon: Int,
    var unselectedIcon: Int,
    var hasNews: Boolean,
    var badgeCount: Int? = null
)

data class FootprintModel(
    val value: Float,
    val color: Color
)

val waterPrint = Color(0XFF1F5D9E)
val energyPrint = Color(0XFFFFD577)
val transpoPrint = Color(0XFF866ABF)
val foodPrint = Color(0XFFF07579)
val wastePrint = Color(0XFFA55649)

// initialize user dailies progress
var userDailiesProgress = DailiesProgress()

// initialize user challenges progresss
var userChallengesProgress = ChallengesProgress()

// initial benchmarks of new user
var userCarbonFootprint = userCarbonFootprint(
    household = userWaterFootprint.household,
    waterComponent = userWaterFootprint,
    energyComponent = userEnergyFootprint,
    transpoComponent = userTranspoFootprint,
    foodComponent = userFoodFootprint,
    wasteComponent = userWasteFootprint,
)

// recalculated daily benchmarks of user
var userRecalcCarbonFootprint = userRecalcCarbonFootprint(
    household = userRecalcWaterFootprint.household,
    waterComponent = userRecalcWaterFootprint,
    energyComponent = userRecalcEnergyFootprint,
    transpoComponent = userRecalcTranspoFootprint,
    foodComponent = userRecalcFoodFootprint,
    wasteComponent = userRecalcWasteFootprint
)

// overall ecofootprint of user
var userEcoFootprint = {
    if (userDailiesDone.waterDailiesDone > 0 || userDailiesDone.energyDailiesDone > 0 ||
        userDailiesDone.transpoDailiesDone > 0 || userDailiesDone.foodDailiesDone > 0 ||
        userDailiesDone.wasteDailiesDone > 0
    ) {
        userEcoFootprint(userRecalcCarbonFootprint)
    } else {
        userEcoFootprint(userCarbonFootprint)
    }
}

// need to refactor variables
/*
// daily carbon footprint of user
var userDailyCarbonFootprint = {
    // logic must consider other categories
    if (userDailiesDone.waterDailiesDone > 0 || userDailiesDone.energyDailiesDone > 0 ||
        userDailiesDone.transpoDailiesDone > 0 || userDailiesDone.foodDailiesDone > 0 ||
        userDailiesDone.wasteDailiesDone > 0
    ) {
        userRecalcCarbonFootprint.total / 30.0f
    } else {
        userCarbonFootprint.total / 30.0f
    }
}

// percent of daily water consumption
var userDailyWater = {
    if (userDailiesDone.waterDailiesDone > 0) {
        String.format(Locale.US, "%.2f",
            (userRecalcCarbonFootprint.water / userRecalcCarbonFootprint.total) * 100.0f
        ).toFloat()
    } else {
        String.format(
            Locale.US, "%.2f",
            (userCarbonFootprint.water / userCarbonFootprint.total) * 100.0f
        ).toFloat()
    }
}
// consumption per liter
var dailyWater = {
    if (userDailiesDone.waterDailiesDone > 0) {
        String.format(Locale.US, "%.2f",
            (userRecalcCarbonFootprint.water / 30f)
        ).toFloat()
    } else {
        String.format(Locale.US, "%.2f",
            (userCarbonFootprint.water / 30f)
        ).toFloat()
    }
}

// percent of daily energy consumption
var userDailyEnergy = {
    if (userDailiesDone.energyDailiesDone > 0) {
        String.format(Locale.US, "%.2f",
            (userRecalcCarbonFootprint.energy / userRecalcCarbonFootprint.total) * 100.0f
        ).toFloat()
    } else {
        String.format(
            Locale.US, "%.2f",
            (userCarbonFootprint.energy / userCarbonFootprint.total) * 100.0f
        ).toFloat()
    }
}
// consumption per kWh
var dailyEnergy = {
    if (userDailiesDone.energyDailiesDone > 0) {
        String.format(Locale.US, "%.2f",
            (userRecalcCarbonFootprint.energy / 30f)).toFloat()
    } else {
        String.format(Locale.US, "%.2f",
            (userCarbonFootprint.energy / 30f)).toFloat()
    }
}

// percent of daily transpo consumption
var userDailyTranspo = {
    if (userDailiesDone.transpoDailiesDone > 0) {
        String.format(Locale.US, "%.2f",
            (userRecalcCarbonFootprint.transpo / userRecalcCarbonFootprint.total) * 100.0f
        ).toFloat()
    } else {
        String.format(
            Locale.US, "%.2f",
            (userCarbonFootprint.transpo / userCarbonFootprint.total) * 100.0f
        ).toFloat()
    }
}
// consumption per km
var dailyTranspo = {
    if (userDailiesDone.transpoDailiesDone > 0) {
        String.format(Locale.US, "%.2f",
            (userRecalcCarbonFootprint.transpo / 30f)).toFloat()
    } else {
        String.format(Locale.US, "%.2f",
            (userCarbonFootprint.transpo / 30f)).toFloat()
    }
}

// percent of daily food consumption
var userDailyFood = {
    if (userDailiesDone.foodDailiesDone > 0) {
        String.format(Locale.US, "%.2f",
            (userRecalcCarbonFootprint.food / userRecalcCarbonFootprint.total) * 100.0f
        ).toFloat()
    } else {
        String.format(
            Locale.US, "%.2f",
            (userCarbonFootprint.food / userCarbonFootprint.total) * 100.0f
        ).toFloat()
    }
}
// consumption per serving
var dailyFood = {
    if (userDailiesDone.foodDailiesDone > 0) {
        String.format(Locale.US, "%.2f",
            (userRecalcCarbonFootprint.food / 30f)).toFloat()
    } else {
        String.format(Locale.US, "%.2f",
            (userCarbonFootprint.food / 30f)).toFloat()
    }
}

// percent of daily waste production
var userDailyWaste = {
    if (userDailiesDone.wasteDailiesDone > 0) {
        String.format(Locale.US, "%.2f",
            (userRecalcCarbonFootprint.waste / userRecalcCarbonFootprint.total) * 100.0f
        ).toFloat()
    } else {
        String.format(
            Locale.US, "%.2f",
            (userCarbonFootprint.waste / userCarbonFootprint.total) * 100.0f
        ).toFloat()
    }
}
// production per kg
var dailyWaste = {
    if (userDailiesDone.wasteDailiesDone > 0) {
        String.format(Locale.US, "%.2f",
            (userRecalcCarbonFootprint.waste / 30f)).toFloat()
    } else {
        String.format(Locale.US, "%.2f",
            (userCarbonFootprint.waste / 30f)).toFloat()
    }
}
*/

@Composable
fun PageFootprintScreen(navController: NavController) {
    // need to fix LaunchedEffect() logic
    /*
    var doneWater by rememberSaveable { mutableIntStateOf(userDailiesDone.waterDailiesDone) }
    var doneEnergy by rememberSaveable { mutableIntStateOf(userDailiesDone.energyDailiesDone) }
    var doneTranspo by rememberSaveable { mutableIntStateOf(userDailiesDone.transpoDailiesDone) }
    var doneFood by rememberSaveable { mutableIntStateOf(userDailiesDone.foodDailiesDone) }
    var doneWaste by rememberSaveable { mutableIntStateOf(userDailiesDone.wasteDailiesDone) }
    */

    var userDailyWater by rememberSaveable { mutableFloatStateOf(0f) }
    var userDailyEnergy by rememberSaveable { mutableFloatStateOf(0f) }
    var userDailyTranspo by rememberSaveable { mutableFloatStateOf(0f) }
    var userDailyFood by rememberSaveable { mutableFloatStateOf(0f) }
    var userDailyWaste by rememberSaveable { mutableFloatStateOf(0f) }

    var userDailies: List<FootprintModel>
    // var recalc: CarbonFootprint

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
                            DailyWaterLogsButton(navController)
                            DailyEnergyLogsButton(navController)
                            DailyTranspoLogsButton(navController)
                            DailyFoodLogsButton(navController)
                        }

                        Column(
                            modifier = Modifier.height(310.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            DailyWasteLogsButton(navController)
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

                                LaunchedEffect(userDailiesDone) {
                                    /*
                                    doneWater = userDailiesDone.waterDailiesDone
                                    doneEnergy = userDailiesDone.energyDailiesDone
                                    doneTranspo = userDailiesDone.transpoDailiesDone
                                    doneFood = userDailiesDone.foodDailiesDone
                                    doneWaste = userDailiesDone.wasteDailiesDone

                                    recalc = userRecalcCarbonFootprint(
                                        household = adjustWaterEmission().household,
                                        waterComponent = adjustWaterEmission(),
                                        energyComponent = adjustEnergyEmission(),
                                        transpoComponent = adjustTranspoEmission(),
                                        foodComponent = adjustFoodEmission(),
                                        wasteComponent = adjustWasteEmission()
                                    )
                                    */

                                    userDailyWater =
                                        String.format(
                                            Locale.US, "%.2f",
                                            (userCarbonFootprint.water / userCarbonFootprint.total) * 100.0f
                                        ).toFloat()

                                    userDailyEnergy =
                                        String.format(
                                            Locale.US, "%.2f",
                                            (userCarbonFootprint.energy / userCarbonFootprint.total) * 100.0f
                                        ).toFloat()

                                    userDailyTranspo =
                                        String.format(
                                            Locale.US, "%.2f",
                                            (userCarbonFootprint.transpo / userCarbonFootprint.total) * 100.0f
                                        ).toFloat()

                                    userDailyFood =
                                        String.format(
                                            Locale.US, "%.2f",
                                            (userCarbonFootprint.food / userCarbonFootprint.total) * 100.0f
                                        ).toFloat()

                                    userDailyWaste =
                                        String.format(
                                            Locale.US, "%.2f",
                                            (userCarbonFootprint.waste / userCarbonFootprint.total) * 100.0f
                                        ).toFloat()
                                }
                                userDailies = listOf(
                                    FootprintModel(userDailyWater, waterPrint),
                                    FootprintModel(userDailyEnergy, energyPrint),
                                    FootprintModel(userDailyTranspo, transpoPrint),
                                    FootprintModel(userDailyFood, foodPrint),
                                    FootprintModel(userDailyWaste, wastePrint)
                                )
                                FootprintPieChart(userDailies)
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

                    com.example.kalikasapp.ui.theme.navigation.landing_screens.CarbonFootprint()
                    DailyCarbonFootprint()
                }
            }
        }
    )
}

@Composable
fun DailyCarbonFootprint() {
    var doneWater by rememberSaveable { mutableIntStateOf(userDailiesDone.waterDailiesDone) }
    var doneEnergy by rememberSaveable { mutableIntStateOf(userDailiesDone.energyDailiesDone) }
    var doneTranspo by rememberSaveable { mutableIntStateOf(userDailiesDone.transpoDailiesDone) }
    var doneFood by rememberSaveable { mutableIntStateOf(userDailiesDone.foodDailiesDone) }
    var doneWaste by rememberSaveable { mutableIntStateOf(userDailiesDone.wasteDailiesDone) }
    var userDailyCarbonFootprint by rememberSaveable { mutableFloatStateOf(0f) }
    var recalc: CarbonFootprint

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
                text = "CO2 per day",
                textAlign = TextAlign.Center,
                color = Color.DarkGray,
                fontSize = 20.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )

            LaunchedEffect(userDailiesDone) {
                doneWater = userDailiesDone.waterDailiesDone
                doneEnergy = userDailiesDone.energyDailiesDone
                doneTranspo = userDailiesDone.transpoDailiesDone
                doneFood = userDailiesDone.foodDailiesDone
                doneWaste = userDailiesDone.wasteDailiesDone

                userDailyCarbonFootprint = if (doneWater > 0 || doneEnergy > 0 ||
                    doneTranspo > 0 || doneFood > 0 || doneWaste > 0
                ) {
                    recalc = userRecalcCarbonFootprint(
                        household = adjustWaterEmission().household,
                        waterComponent = adjustWaterEmission(),
                        energyComponent = adjustEnergyEmission(),
                        transpoComponent = adjustTranspoEmission(),
                        foodComponent = adjustFoodEmission(),
                        wasteComponent = adjustWasteEmission()
                    )
                    recalc.total / 30.0f
                } else {
                    userCarbonFootprint.total / 30.0f
                }
            }
            Text(
                text = String.format(Locale.US, "%.2f", userDailyCarbonFootprint)
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
fun DailyWaterLogsButton(navController: NavController){
    var dailyOne by rememberSaveable { mutableStateOf(userDailiesProgress.waterDailies.d1.t2) }
    var dailyTwo by rememberSaveable { mutableStateOf(userDailiesProgress.waterDailies.d2.t2) }
    var dailyThree by rememberSaveable { mutableStateOf(userDailiesProgress.waterDailies.d3.t2) }

    var dailyWater by rememberSaveable { mutableFloatStateOf(0f) }
    var userDailyWater by rememberSaveable { mutableFloatStateOf(0f) }
    var recalc: CarbonFootprint

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
            LaunchedEffect(userDailiesProgress.waterDailies) {
                dailyOne = userDailiesProgress.waterDailies.d1.t2
                dailyTwo = userDailiesProgress.waterDailies.d2.t2
                dailyThree =  userDailiesProgress.waterDailies.d3.t2

                recalc = userRecalcCarbonFootprint(
                    household = adjustWaterEmission().household,
                    waterComponent = adjustWaterEmission(),
                    energyComponent = adjustEnergyEmission(),
                    transpoComponent = adjustTranspoEmission(),
                    foodComponent = adjustFoodEmission(),
                    wasteComponent = adjustWasteEmission()
                )

                // consumption per liter
                dailyWater = if (dailyOne || dailyTwo || dailyThree) {
                    String.format(Locale.US, "%.2f",
                        (recalc.water / 30f)
                    ).toFloat()
                } else {
                    String.format(Locale.US, "%.2f",
                        (userCarbonFootprint.water / 30f)
                    ).toFloat()
                }

                // consumption percentage
                userDailyWater =
                    String.format(Locale.US, "%.2f",
                        (userCarbonFootprint.water / userCarbonFootprint.total) * 100.0f
                    ).toFloat()
            }
            Text(
                text = "$userDailyWater%",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Text(
                text = "$dailyWater CO2\nper liter",
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
fun DailyEnergyLogsButton(navController: NavController){
    var dailyOne by rememberSaveable { mutableStateOf(userDailiesProgress.energyDailies.d1.t2) }
    var dailyTwo by rememberSaveable { mutableStateOf(userDailiesProgress.energyDailies.d2.t2) }
    var dailyThree by rememberSaveable { mutableStateOf(userDailiesProgress.energyDailies.d3.t2) }

    var dailyEnergy by rememberSaveable { mutableFloatStateOf(0f) }
    var userDailyEnergy by rememberSaveable { mutableFloatStateOf(0f) }
    var recalc: CarbonFootprint

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
            LaunchedEffect(userDailiesProgress.energyDailies) {
                dailyOne = userDailiesProgress.energyDailies.d1.t2
                dailyTwo = userDailiesProgress.energyDailies.d2.t2
                dailyThree =  userDailiesProgress.energyDailies.d3.t2

                recalc = userRecalcCarbonFootprint(
                    household = adjustWaterEmission().household,
                    waterComponent = adjustWaterEmission(),
                    energyComponent = adjustEnergyEmission(),
                    transpoComponent = adjustTranspoEmission(),
                    foodComponent = adjustFoodEmission(),
                    wasteComponent = adjustWasteEmission()
                )

                // consumption per kWh
                dailyEnergy = if (dailyOne || dailyTwo || dailyThree) {
                    String.format(Locale.US, "%.2f",
                        (recalc.energy / 30f)).toFloat()
                } else {
                    String.format(Locale.US, "%.2f",
                        (userCarbonFootprint.energy / 30f)).toFloat()
                }

                // consumption percentage
                userDailyEnergy =
                    String.format(Locale.US, "%.2f",
                        (userCarbonFootprint.energy / userCarbonFootprint.total) * 100.0f
                    ).toFloat()
            }
            Text(
                text = "$userDailyEnergy%",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Text(
                text = "$dailyEnergy CO2\nx kWh",
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
fun DailyTranspoLogsButton(navController: NavController){
    var dailyOne by rememberSaveable { mutableStateOf(userDailiesProgress.transpoDailies.d1.t2) }
    var dailyTwo by rememberSaveable { mutableStateOf(userDailiesProgress.transpoDailies.d2.t2) }
    var dailyThree by rememberSaveable { mutableStateOf(userDailiesProgress.transpoDailies.d3.t2) }

    var dailyTranspo by rememberSaveable { mutableFloatStateOf(0f) }
    var userDailyTranspo by rememberSaveable { mutableFloatStateOf(0f) }
    var recalc: CarbonFootprint

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
            LaunchedEffect(userDailiesProgress.transpoDailies) {
                dailyOne = userDailiesProgress.transpoDailies.d1.t2
                dailyTwo = userDailiesProgress.transpoDailies.d2.t2
                dailyThree =  userDailiesProgress.transpoDailies.d3.t2

                recalc = userRecalcCarbonFootprint(
                    household = adjustWaterEmission().household,
                    waterComponent = adjustWaterEmission(),
                    energyComponent = adjustEnergyEmission(),
                    transpoComponent = adjustTranspoEmission(),
                    foodComponent = adjustFoodEmission(),
                    wasteComponent = adjustWasteEmission()
                )

                // consumption per km
                dailyTranspo = if (dailyOne || dailyTwo || dailyThree) {
                    String.format(Locale.US, "%.2f",
                        (recalc.transpo / 30f)).toFloat()
                } else {
                    String.format(Locale.US, "%.2f",
                        (userCarbonFootprint.transpo / 30f)).toFloat()
                }

                // consumption percentage
                userDailyTranspo =
                    String.format(Locale.US, "%.2f",
                        (userCarbonFootprint.transpo / userCarbonFootprint.total) * 100.0f
                    ).toFloat()
            }
            Text(
                text = "$userDailyTranspo%",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Text(
                text = "$dailyTranspo CO2\nper km",
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
fun DailyFoodLogsButton(navController: NavController){
    var dailyOne by rememberSaveable { mutableStateOf(userDailiesProgress.foodDailies.d1.t2) }
    var dailyTwo by rememberSaveable { mutableStateOf(userDailiesProgress.foodDailies.d2.t2) }
    var dailyThree by rememberSaveable { mutableStateOf(userDailiesProgress.foodDailies.d3.t2) }

    var dailyFood by rememberSaveable { mutableFloatStateOf(0f) }
    var userDailyFood by rememberSaveable { mutableFloatStateOf(0f) }
    var recalc: CarbonFootprint

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
            LaunchedEffect(userDailiesProgress.foodDailies) {
                dailyOne = userDailiesProgress.foodDailies.d1.t2
                dailyTwo = userDailiesProgress.foodDailies.d2.t2
                dailyThree =  userDailiesProgress.foodDailies.d3.t2

                recalc = userRecalcCarbonFootprint(
                    household = adjustWaterEmission().household,
                    waterComponent = adjustWaterEmission(),
                    energyComponent = adjustEnergyEmission(),
                    transpoComponent = adjustTranspoEmission(),
                    foodComponent = adjustFoodEmission(),
                    wasteComponent = adjustWasteEmission()
                )

                // consumption per serving
                dailyFood = if (dailyOne || dailyTwo || dailyThree) {
                    String.format(Locale.US, "%.2f",
                        (recalc.food / 30f)).toFloat()
                } else {
                    String.format(Locale.US, "%.2f",
                        (userCarbonFootprint.food / 30f)).toFloat()
                }

                // consumption percentage
                userDailyFood =
                    String.format(Locale.US, "%.2f",
                        (userCarbonFootprint.food / userCarbonFootprint.total) * 100.0f
                    ).toFloat()
            }
            Text(
                text = "$userDailyFood%",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Text(
                text = "$dailyFood CO2\nper plate",
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
fun DailyWasteLogsButton(navController: NavController){
    var dailyOne by rememberSaveable { mutableStateOf(userDailiesProgress.wasteDailies.d1.t2) }
    var dailyTwo by rememberSaveable { mutableStateOf(userDailiesProgress.wasteDailies.d2.t2) }
    var dailyThree by rememberSaveable { mutableStateOf(userDailiesProgress.wasteDailies.d3.t2) }

    var dailyWaste by rememberSaveable { mutableFloatStateOf(0f) }
    var userDailyWaste by rememberSaveable { mutableFloatStateOf(0f) }
    var recalc: CarbonFootprint

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
            LaunchedEffect(userDailiesProgress.wasteDailies) {
                dailyOne = userDailiesProgress.wasteDailies.d1.t2
                dailyTwo = userDailiesProgress.wasteDailies.d2.t2
                dailyThree =  userDailiesProgress.wasteDailies.d3.t2

                recalc = userRecalcCarbonFootprint(
                    household = adjustWaterEmission().household,
                    waterComponent = adjustWaterEmission(),
                    energyComponent = adjustEnergyEmission(),
                    transpoComponent = adjustTranspoEmission(),
                    foodComponent = adjustFoodEmission(),
                    wasteComponent = adjustWasteEmission()
                )

                // production per kg
                dailyWaste = if (dailyOne || dailyTwo || dailyThree) {
                    String.format(Locale.US, "%.2f",
                        (recalc.waste / 30f)).toFloat()
                } else {
                    String.format(Locale.US, "%.2f",
                        (userCarbonFootprint.waste / 30f)).toFloat()
                }

                // production percentage
                userDailyWaste =
                    String.format(Locale.US, "%.2f",
                        (userCarbonFootprint.waste / userCarbonFootprint.total) * 100.0f
                    ).toFloat()
            }
            Text(
                text = "$userDailyWaste%",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Text(
                text = "$dailyWaste CO2\nx kg",
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
fun EcologicalFootprint() {
    var doneWater by rememberSaveable { mutableIntStateOf(userDailiesDone.waterDailiesDone) }
    var doneEnergy by rememberSaveable { mutableIntStateOf(userDailiesDone.energyDailiesDone) }
    var doneTranspo by rememberSaveable { mutableIntStateOf(userDailiesDone.transpoDailiesDone) }
    var doneFood by rememberSaveable { mutableIntStateOf(userDailiesDone.foodDailiesDone) }
    var doneWaste by rememberSaveable { mutableIntStateOf(userDailiesDone.wasteDailiesDone) }
    var userDailyEcoFootprint by rememberSaveable { mutableFloatStateOf(userEcoFootprint().ecoGha) }
    var recalc: CarbonFootprint

    Row(
        modifier = Modifier
            .absolutePadding(0.dp, 14.dp, 0.dp, 0.dp)
    ) {
        Image(
            modifier = Modifier
                .width(120.dp)
                .height(120.dp),
            painter = painterResource(R.drawable.footprinteco),
            contentDescription = null
        )

        Column(
            modifier = Modifier
        ) {
            Text(text = "Ecological\nFootprint",
                color = Color.White,
                fontSize = 18.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )

            LaunchedEffect(userDailiesDone) {
                doneWater = userDailiesDone.waterDailiesDone
                doneEnergy = userDailiesDone.energyDailiesDone
                doneTranspo = userDailiesDone.transpoDailiesDone
                doneFood = userDailiesDone.foodDailiesDone
                doneWaste = userDailiesDone.wasteDailiesDone

                userDailyEcoFootprint = if (doneWater > 0 || doneEnergy > 0 ||
                    doneTranspo > 0 || doneFood > 0 || doneWaste > 0
                ) {
                    recalc = userRecalcCarbonFootprint(
                        household = adjustWaterEmission().household,
                        waterComponent = adjustWaterEmission(),
                        energyComponent = adjustEnergyEmission(),
                        transpoComponent = adjustTranspoEmission(),
                        foodComponent = adjustFoodEmission(),
                        wasteComponent = adjustWasteEmission()
                    )
                    userEcoFootprint(recalc).ecoGha
                } else {
                    userEcoFootprint(userCarbonFootprint).ecoGha
                }
            }
            Text(text = String.format(Locale.US, "%.2f", userDailyEcoFootprint)
                .toFloat().toString() + " gha",
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )

            Text(text = "(global hectares)",
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
fun CarbonFootprint() {
    var doneWater by rememberSaveable { mutableIntStateOf(userDailiesDone.waterDailiesDone) }
    var doneEnergy by rememberSaveable { mutableIntStateOf(userDailiesDone.energyDailiesDone) }
    var doneTranspo by rememberSaveable { mutableIntStateOf(userDailiesDone.transpoDailiesDone) }
    var doneFood by rememberSaveable { mutableIntStateOf(userDailiesDone.foodDailiesDone) }
    var doneWaste by rememberSaveable { mutableIntStateOf(userDailiesDone.wasteDailiesDone) }
    var userDailyEcoFootprint by rememberSaveable { mutableFloatStateOf(userEcoFootprint().carbonGha) }
    var recalc: CarbonFootprint

    Column(
        modifier = Modifier
            .absolutePadding(20.dp, 560.dp, 20.dp, 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Carbon Footprint",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 18.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )

            LaunchedEffect(userDailiesDone) {
                doneWater = userDailiesDone.waterDailiesDone
                doneEnergy = userDailiesDone.energyDailiesDone
                doneTranspo = userDailiesDone.transpoDailiesDone
                doneFood = userDailiesDone.foodDailiesDone
                doneWaste = userDailiesDone.wasteDailiesDone

                userDailyEcoFootprint = if (doneWater > 0 || doneEnergy > 0 ||
                    doneTranspo > 0 || doneFood > 0 || doneWaste > 0
                ) {
                    recalc = userRecalcCarbonFootprint(
                        household = adjustWaterEmission().household,
                        waterComponent = adjustWaterEmission(),
                        energyComponent = adjustEnergyEmission(),
                        transpoComponent = adjustTranspoEmission(),
                        foodComponent = adjustFoodEmission(),
                        wasteComponent = adjustWasteEmission()
                    )
                    userEcoFootprint(recalc).carbonGha
                } else {
                    userEcoFootprint(userCarbonFootprint).carbonGha
                }
            }
            Text(text = String.format(Locale.US, "%.2f", userDailyEcoFootprint)
                .toFloat().toString() + " gha",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )

            Text(text = "(global hectares)",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 12.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
        }

        Image(
            modifier = Modifier
                .width(180.dp)
                .height(180.dp),
            painter = painterResource(R.drawable.footprintcarbon3),
            contentDescription = null
        )
    }
}

@Composable
fun NeededCountries() {
    var doneWater by rememberSaveable { mutableIntStateOf(userDailiesDone.waterDailiesDone) }
    var doneEnergy by rememberSaveable { mutableIntStateOf(userDailiesDone.energyDailiesDone) }
    var doneTranspo by rememberSaveable { mutableIntStateOf(userDailiesDone.transpoDailiesDone) }
    var doneFood by rememberSaveable { mutableIntStateOf(userDailiesDone.foodDailiesDone) }
    var doneWaste by rememberSaveable { mutableIntStateOf(userDailiesDone.wasteDailiesDone) }
    var userDailyEcoFootprint by rememberSaveable { mutableFloatStateOf(userEcoFootprint().countriesNeeded) }
    var recalc: CarbonFootprint

    Box(
        modifier = Modifier
    ) {
        Image(
            modifier = Modifier
                .width(120.dp)
                .height(120.dp),
            painter = painterResource(R.drawable.footprinteco2),
            contentDescription = null
        )

        Column(
            modifier = Modifier
                .absolutePadding(0.dp, 110.dp, 0.dp, 0.dp)
        ) {
            LaunchedEffect(userDailiesDone) {
                doneWater = userDailiesDone.waterDailiesDone
                doneEnergy = userDailiesDone.energyDailiesDone
                doneTranspo = userDailiesDone.transpoDailiesDone
                doneFood = userDailiesDone.foodDailiesDone
                doneWaste = userDailiesDone.wasteDailiesDone

                userDailyEcoFootprint = if (doneWater > 0 || doneEnergy > 0 ||
                    doneTranspo > 0 || doneFood > 0 || doneWaste > 0
                ) {
                    recalc = userRecalcCarbonFootprint(
                        household = adjustWaterEmission().household,
                        waterComponent = adjustWaterEmission(),
                        energyComponent = adjustEnergyEmission(),
                        transpoComponent = adjustTranspoEmission(),
                        foodComponent = adjustFoodEmission(),
                        wasteComponent = adjustWasteEmission()
                    )
                    userEcoFootprint(recalc).countriesNeeded
                } else {
                    userEcoFootprint(userCarbonFootprint).countriesNeeded
                }
            }
            Text(text = String.format(Locale.US, "%.2f", userDailyEcoFootprint)
                .toFloat().toString() + "x of \nPhilippines",
                color = Color.White,
                fontSize = 18.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )

            Text(text = "is needed if all\nFilipinos followed\nyour lifestyle",
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
fun TopNavBar(navController: NavController) {
    val navGreen = Color(0XFF719B8E)

    val items = listOf(
        TopNavigationItem(
            route = Screen.PageFootprintScreen.route,
            selectedIcon = R.drawable.topselecteddaily,
            unselectedIcon = R.drawable.topunselecteddaily,
            hasNews = false
        ),
        TopNavigationItem(
            route = Screen.FootprintWeeklyScreen.route,
            selectedIcon = R.drawable.topselectedweekly,
            unselectedIcon = R.drawable.topunselectedweekly,
            hasNews = false
        ),
        TopNavigationItem(
            route = Screen.FootprintMonthlyScreen.route,
            selectedIcon = R.drawable.topselectedmonthly,
            unselectedIcon = R.drawable.topunselectedmonthly,
            hasNews = false
        ),
        TopNavigationItem(
            route = Screen.FootprintYearlyScreen.route,
            selectedIcon = R.drawable.topselectedyearly,
            unselectedIcon = R.drawable.topunselectedyearly,
            hasNews = false
        )
    )

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .absolutePadding(20.dp, 20.dp, 20.dp, 20.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 40.dp, topEnd = 40.dp,
                    bottomStart = 40.dp, bottomEnd = 40.dp
                )
            )
    ) {
        NavigationBar(
            modifier = Modifier
                .height(60.dp),
            containerColor = navGreen
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = selectedItemIndex == index,
                    onClick = {
                        selectedItemIndex = index
                        navController.navigate(item.route)
                    },
                    icon = {
                        BadgedBox(
                            badge = {
                                if(item.badgeCount != null) {
                                    Badge {
                                        Text(text = item.badgeCount.toString())
                                    }
                                } else if(item.hasNews) {
                                    Badge()
                                }
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = item.selectedIcon),
                                tint = Color.Unspecified,
                                contentDescription = null,
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(40.dp)
                            )
                            /*
                            if(index == selectedItemIndex) {
                                Icon(
                                    painter = painterResource(id = item.selectedIcon),
                                    tint = Color.Unspecified,
                                    contentDescription = null,
                                    modifier = Modifier.width(50.dp).height(40.dp)
                                )
                            } else {
                                Icon(
                                    painter = painterResource(id = item.unselectedIcon),
                                    tint = Color.Unspecified,
                                    contentDescription = null,
                                    modifier = Modifier.width(50.dp).height(40.dp)
                                )
                            }
                            */
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun FootprintPageBackdrop(modifier: Modifier) {
    val image = painterResource(R.drawable.footprintpage)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@Composable
fun LogFootprintButton(
    painter: Painter, category: String,
    colorPrint: Color, navController: NavController, route: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(
                onClick = { navController.navigate(route) }
            )
    ) {
       Image(
           painter = painter,
           contentDescription = null,
           modifier = Modifier.size(64.dp)
       )

        Text(
            text = category,
            textAlign = TextAlign.Center,
            color = colorPrint,
            fontSize = 12.sp,
            fontFamily = montserratFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PageFootprintScreenPreview() {
    val navController = rememberNavController()
    PageFootprintScreen(navController = navController)
}
