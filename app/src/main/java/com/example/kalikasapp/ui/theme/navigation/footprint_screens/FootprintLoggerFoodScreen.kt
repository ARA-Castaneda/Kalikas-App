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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
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

val foodLoggerText = Color(0xFF150203)
val foodLoggerTextBg = Color(0xFFEA4045)
val foodCategoryCard = Color(0XFFF07579)
val foodCategoryIcon = Color(0XFFF07579)
val foodExpCard = Color(0XFFF07579)
val foodChecked = Color(0xFFEA4045)
val foodUnchecked = Color(0xFFEA4045)
val foodChallengeCard = Color(0XFFF07579)
val foodProgressBarExp = Color(0xFFFFD400)

@Composable
fun FootprintLoggerFoodScreen(navController: NavController) {
    // initialize food challenge badges
    val badgeA = painterResource(id = R.drawable.badgefood1)
    val badgeB = painterResource(id = R.drawable.badgefood2)
    val badgeC = painterResource(id = R.drawable.badgefood3)
    val button = painterResource(id = R.drawable.logbuttonfood)

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CategoryCard(
            badge = null, streak = null,
            categoryButton = button, navController = navController,
            title = "Food Consumption",
            titlePainter = painterResource(id = R.drawable.carbonfood),
            cardColor = foodCategoryCard,
            iconColor = foodCategoryIcon,
            categoryTextColor = foodLoggerText,
            categoryTextBgColor = foodLoggerTextBg
        )

        DailiesInterface(
            foodLoggerDailies, foodLoggerExpMap,
            foodCategoryCard, foodLoggerText,
            foodExpCard, { FoodDailiesTracker(userDailiesDone) },
            foodChecked, foodUnchecked,
            userDailiesProgress.foodDailies, (::userFoodDailiesCounter),
            (::userFoodChallengesCounter), { foodChallengesCounter() }
        )

        foodChallengesCounter()
        ChallengesInterface(
            foodLoggerChallenges, foodCategoryCard,
            foodLoggerText, { FoodChallengesTracker(userChallengesDone) },
            badgeA, badgeB, badgeC,
            userChallengesProgress.foodChallenges,
            foodProgressBarExp, foodChallengeCard
        )
    }
}

@Composable
fun FoodDailiesTracker(dailiesDone: DailiesDone) {
    var total by rememberSaveable { mutableIntStateOf(dailiesDone.foodDailiesDone) }

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
                color = foodLoggerText,
                fontSize = 24.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 0.dp, 0.dp, 0.dp)
            ) {
                LaunchedEffect(dailiesDone.foodDailiesDone) {
                    total = dailiesDone.foodDailiesDone
                }
                Text(
                    text = "$total/3",
                    color = foodLoggerText,
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
fun FoodChallengesTracker(challengesDone: ChallengesDone) {
    var total by rememberSaveable { mutableIntStateOf(challengesDone.foodChallengesDone) }

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
                color = foodLoggerText,
                fontSize = 24.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 0.dp, 0.dp, 0.dp)
            ) {
                LaunchedEffect(challengesDone.foodChallengesDone) {
                    total = challengesDone.foodChallengesDone
                }
                Text(
                    text = "$total/3",
                    color = foodLoggerText,
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
fun FootprintLoggerFoodScreenPreview() {
    val navController = rememberNavController()
    FootprintLoggerFoodScreen(navController = navController)
}
