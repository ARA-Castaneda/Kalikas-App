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

val wasteLoggerText = Color(0xFF0F0807)
val wasteLoggerTextBg = Color(0xFFC38277)
val wasteCategoryCard = Color(0XFFA55649)
val wasteCategoryIcon = Color(0XFFA55649)
val wasteExpCard = Color(0XFFA55649)
val wasteChecked = Color(0xFFC38277)
val wasteUnchecked = Color(0xFFC38277)
val wasteChallengeCard = Color(0XFFA55649)
val wasteProgressBarExp = Color(0xFFFFD400)

@Composable
fun FootprintLoggerWasteScreen(navController: NavController) {
    // initialize waste challenge badges
    val badgeA = painterResource(id = R.drawable.badgewaste1)
    val badgeB = painterResource(id = R.drawable.badgewaste2)
    val badgeC = painterResource(id = R.drawable.badgewaste3)
    val button = painterResource(id = R.drawable.logbuttonwaste)

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CategoryCard(
            badge = null, streak = null,
            categoryButton = button, navController = navController,
            title = "Waste Consumption",
            titlePainter = painterResource(id = R.drawable.carbonwaste),
            cardColor = wasteCategoryCard,
            iconColor = wasteCategoryIcon,
            categoryTextColor = wasteLoggerText,
            categoryTextBgColor = wasteLoggerTextBg
        )

        DailiesInterface(
            wasteLoggerDailies, wasteLoggerExpMap,
            wasteCategoryCard, wasteLoggerText,
            wasteExpCard, { WasteDailiesTracker() },
            wasteChecked, wasteUnchecked,
            userDailiesProgress.wasteDailies,
            (::userWasteDailiesCounter)
        )

        ChallengesInterface(
            wasteLoggerChallenges, wasteCategoryCard,
            wasteLoggerText, { WasteChallengesTracker() },
            badgeA, badgeB, badgeC,
            userChallengesProgress.wasteChallenges, wasteProgressBarExp,
            { wasteChallengesCounter() }, wasteChallengeCard
        )
    }
}

@Composable
fun WasteDailiesTracker() {
    var total by remember { mutableIntStateOf(wasteDailiesDone) }

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
                color = wasteLoggerText,
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
                    color = wasteLoggerText,
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
fun WasteChallengesTracker() {
    var total by remember { mutableIntStateOf(wasteChallengesDone) }

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
                color = wasteLoggerText,
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
                    color = wasteLoggerText,
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
fun FootprintLoggerWasteScreenPreview() {
    val navController = rememberNavController()
    FootprintLoggerWasteScreen(navController = navController)
}
