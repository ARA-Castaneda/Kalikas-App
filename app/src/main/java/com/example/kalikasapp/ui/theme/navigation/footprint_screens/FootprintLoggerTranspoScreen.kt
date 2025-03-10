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

val transpoLoggerText = Color(0xFF0A0710)
val transpoLoggerTextBg = Color(0xFF6748A7)
val transpoCategoryCard = Color(0XFF866ABF)
val transpoCategoryIcon = Color(0XFF866ABF)
val transpoExpCard = Color(0XFF866ABF)
val transpoChecked = Color(0xFF6748A7)
val transpoUnchecked = Color(0xFF6748A7)
val transpoChallengeCard = Color(0XFF866ABF)
val transpoProgressBarExp = Color(0xFFFFD400)

@Composable
fun FootprintLoggerTranspoScreen(navController: NavController) {
    // initialize transpo challenge badges
    val badgeA = painterResource(id = R.drawable.badgetranspo1)
    val badgeB = painterResource(id = R.drawable.badgetranspo2)
    val badgeC = painterResource(id = R.drawable.badgetranspo3)
    val button = painterResource(id = R.drawable.logbuttontranspo)

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CategoryCard(
            badge = null, streak = null,
            categoryButton = button, navController = navController,
            title = "Transpo Consumption",
            titlePainter = painterResource(id = R.drawable.carbontranspo),
            cardColor = transpoCategoryCard,
            iconColor = transpoCategoryIcon,
            categoryTextColor = transpoLoggerText,
            categoryTextBgColor = transpoLoggerTextBg
        )

        DailiesInterface(
            transpoLoggerDailies, transpoLoggerExpMap,
            transpoCategoryCard, transpoLoggerText,
            transpoExpCard, { TranspoDailiesTracker() },
            transpoChecked, transpoUnchecked,
            userDailiesProgress.transpoDailies,
            (::userTranspoDailiesCounter)
        )

        ChallengesInterface(
            transpoLoggerChallenges, transpoCategoryCard,
            transpoLoggerText, { TranspoChallengesTracker() },
            badgeA, badgeB, badgeC,
            userChallengesProgress.transpoChallenges, transpoProgressBarExp,
            { transpoChallengesCounter() }, transpoChallengeCard
        )
    }
}

@Composable
fun TranspoDailiesTracker() {
    var total by remember { mutableIntStateOf(transpoDailiesDone) }

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
                color = transpoLoggerText,
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
                    color = transpoLoggerText,
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
fun TranspoChallengesTracker() {
    var total by remember { mutableIntStateOf(transpoChallengesDone) }

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
                color = transpoLoggerText,
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
                    color = transpoLoggerText,
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
fun FootprintLoggerTranspoScreenPreview() {
    val navController = rememberNavController()
    FootprintLoggerTranspoScreen(navController = navController)
}
