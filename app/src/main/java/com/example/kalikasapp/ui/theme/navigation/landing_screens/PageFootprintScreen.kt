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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
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
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.FootprintPieChart
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.userEcoFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.userCarbonFootprint
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

val userCarbonFootprint = userCarbonFootprint(
    household = userWaterFootprint.household,
    waterComponent = userWaterFootprint,
    energyComponent = userEnergyFootprint,
    transpoComponent = userTranspoFootprint,
    foodComponent = userFoodFootprint,
    wasteComponent = userWasteFootprint,
)
val userEcoFootprint = userEcoFootprint(userCarbonFootprint)

val userDailyCarbonFootprint = userCarbonFootprint.total / 30.0f

val userDailyWater = String.format(Locale.US, "%.2f",
    (userCarbonFootprint.water / userCarbonFootprint.total) * 100.0f
).toFloat()

val userDailyEnergy = String.format(Locale.US, "%.2f",
    (userCarbonFootprint.energy / userCarbonFootprint.total) * 100.0f
).toFloat()

val userDailyTranspo = String.format(Locale.US, "%.2f",
    (userCarbonFootprint.transpo / userCarbonFootprint.total) * 100.0f
).toFloat()

val userDailyFood = String.format(Locale.US, "%.2f",
    (userCarbonFootprint.food / userCarbonFootprint.total) * 100.0f
).toFloat()

val userDailyWaste = String.format(Locale.US, "%.2f",
    (userCarbonFootprint.waste / userCarbonFootprint.total) * 100.0f
).toFloat()

val userDailies = listOf(
    FootprintModel(userDailyWater, waterPrint),
    FootprintModel(userDailyEnergy, energyPrint),
    FootprintModel(userDailyTranspo, transpoPrint),
    FootprintModel(userDailyFood, foodPrint),
    FootprintModel(userDailyWaste, wastePrint)
)

@Composable
fun PageFootprintScreen(navController: NavController) {
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

                    CarbonFootprint()
                    DailyCarbonFootprint()
                }
            }
        }
    )
}

@Composable
fun DailyCarbonFootprint() {
    Column(
        modifier = Modifier
            .absolutePadding(200.dp, 650.dp, 20.dp, 20.dp),
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
            Text(
                text = String.format(Locale.US, "%.2f", userDailyCarbonFootprint)
                    .toFloat().toString(),
                textAlign = TextAlign.Center,
                color = Color.DarkGray,
                fontSize = 40.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Text(
                text = "grams",
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
    val dailyWater = String.format(Locale.US, "%.2f",
        (userCarbonFootprint.water / 30f)
    ).toFloat()

    Row(
        modifier = Modifier.width(140.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LogFootprintButton(
            painterResource(R.drawable.carbonwater),
            "water", waterPrint, navController
        )

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
    val dailyEnergy = String.format(Locale.US, "%.2f",
        (userCarbonFootprint.energy / 30f)).toFloat()

    Row(
        modifier = Modifier.width(140.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LogFootprintButton(
            painterResource(R.drawable.carbonenergy),
            "energy", energyPrint, navController
        )

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
    val dailyTranspo = String.format(Locale.US, "%.2f",
        (userCarbonFootprint.transpo / 30f)).toFloat()

    Row(
        modifier = Modifier.width(140.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LogFootprintButton(
            painterResource(R.drawable.carbontranspo),
            "transpo", transpoPrint, navController
        )

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
    val dailyFood = String.format(Locale.US, "%.2f",
        (userCarbonFootprint.food / 30f)).toFloat()

    Row(
        modifier = Modifier.width(140.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LogFootprintButton(
            painterResource(R.drawable.carbonfood),
            "food", foodPrint, navController
        )

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
    val dailyWaste = String.format(Locale.US, "%.2f",
        (userCarbonFootprint.waste / 30f)).toFloat()

    Row(
        modifier = Modifier.width(140.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LogFootprintButton(
            painterResource(R.drawable.carbonwaste),
            "waste", wastePrint, navController
        )

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
            Text(text = String.format(Locale.US, "%.2f", userEcoFootprint.ecoGha)
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
            Text(text = String.format(Locale.US, "%.2f", userEcoFootprint.carbonGha)
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
            Text(text = String.format(Locale.US, "%.2f", userEcoFootprint.countriesNeeded)
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
    colorPrint: Color, navController: NavController
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { /***/ }
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
