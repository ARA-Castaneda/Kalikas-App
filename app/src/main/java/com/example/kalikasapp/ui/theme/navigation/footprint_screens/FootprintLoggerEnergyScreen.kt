package com.example.kalikasapp.ui.theme.navigation.footprint_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kalikasapp.R
import com.example.kalikasapp.ui.theme.navigation.landing_screens.userChallengesProgress
import com.example.kalikasapp.ui.theme.navigation.landing_screens.userDailiesProgress
import com.example.kalikasapp.ui.theme.robotoFamily

val energyLoggerText = Color(0xFF150E00)
val energyLoggerTextBg = Color(0xFFEDA400)
val energyCategoryCard = Color(0XFFFFD577)
val energyCategoryIcon = Color(0XFFFFD577)
val energyExpCard = Color(0XFFFFD577)
val energyChecked = Color(0xFFEDA400)
val energyUnchecked = Color(0xFFEDA400)
val energyChallengeCard = Color(0XFFFFD577)
val energyProgressBarExp = Color(0xFFFFD400)

@Composable
fun FootprintLoggerEnergyScreen(navController: NavController) {
    // initialize energy challenge badges
    val badgeA = painterResource(id = R.drawable.badgeenergy1)
    val badgeB = painterResource(id = R.drawable.badgeenergy2)
    val badgeC = painterResource(id = R.drawable.badgeenergy3)
    val button = painterResource(id = R.drawable.logbuttonenergy)

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CategoryCard(
            badge = null, streak = null,
            categoryButton = button, navController = navController,
            title = "Energy Consumption",
            titlePainter = painterResource(id = R.drawable.carbonenergy),
            cardColor = energyCategoryCard,
            iconColor = energyCategoryIcon,
            categoryTextColor = energyLoggerText,
            categoryTextBgColor = energyLoggerTextBg
        )

        DailiesInterface(
            energyLoggerDailies, energyLoggerExpMap,
            energyCategoryCard, energyLoggerText,
            energyExpCard, { EnergyDailiesTracker() },
            energyChecked, energyUnchecked,
            userDailiesProgress.energyDailies,
            (::userEnergyDailiesCounter)
        )

        ChallengesInterface(
            energyLoggerChallenges, energyCategoryCard,
            energyLoggerText, { EnergyChallengesTracker() },
            badgeA, badgeB, badgeC,
            userChallengesProgress.energyChallenges, energyProgressBarExp,
            { energyChallengesCounter() }, energyChallengeCard
        )
    }
}

@Composable
fun EnergyDailiesTracker() {
    var total by remember { mutableIntStateOf(energyDailiesDone) }

    Row(
        modifier = Modifier
    ) {
        Image(
            modifier = Modifier
                .width(54.dp)
                .height(54.dp),
            painter = painterResource(id = R.drawable.composable_dailies),
            contentDescription = null
        )

        Column(
            modifier = Modifier
                .absolutePadding(20.dp, 6.dp, 0.dp, 0.dp)
        ) {
            Text(
                text = "Daily Targets",
                color = energyLoggerText,
                fontSize = 24.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 0.dp, 0.dp, 0.dp)
            ) {
                Text(
                    text = "$total/3",
                    color = energyLoggerText,
                    fontSize = 18.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
fun EnergyChallengesTracker() {
    var total by remember { mutableIntStateOf(energyChallengesDone) }

    Row(
        modifier = Modifier
    ) {
        Image(
            modifier = Modifier
                .width(54.dp)
                .height(54.dp),
            painter = painterResource(id = R.drawable.composable_weeklies),
            contentDescription = null
        )

        Column(
            modifier = Modifier
                .absolutePadding(20.dp, 6.dp, 0.dp, 0.dp)
        ) {
            Text(
                text = "Challenges",
                color = energyLoggerText,
                fontSize = 24.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 0.dp, 0.dp, 0.dp)
            ) {
                Text(
                    text = "$total/3",
                    color = energyLoggerText,
                    fontSize = 18.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FootprintLoggerEnergyScreenPreview() {
    val navController = rememberNavController()
    FootprintLoggerEnergyScreen(navController = navController)
}
