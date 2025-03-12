package com.example.kalikasapp.ui.theme.navigation.footprint_screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.Checkbox
import androidx.tv.material3.CheckboxDefaults
import com.example.kalikasapp.R
import com.example.kalikasapp.ui.theme.montserratFamily
import com.example.kalikasapp.ui.theme.navigation.Screen
import com.example.kalikasapp.ui.theme.navigation.landing_screens.userChallengesProgress
import com.example.kalikasapp.ui.theme.navigation.landing_screens.userDailiesProgress
import com.example.kalikasapp.ui.theme.robotoFamily

val waterLoggerText = Color(0xFF05101B)
val waterLoggerTextBg = Color(0xFF297ACF)
val waterCategoryCard = Color(0XFF1F5D9E)
val waterCategoryIcon = Color(0XFF1F5D9E)
val waterExpCard = Color(0XFF1F5D9E)
val waterChecked = Color(0xFF297ACF)
val waterUnchecked = Color(0xFF297ACF)
val waterChallengeCard = Color(0XFF1F5D9E)
val waterProgressBarExp = Color(0xFFFFD400)

@Composable
fun FootprintLoggerWaterScreen(navController: NavController) {
    // initialize water challenge badges
    val badgeA = painterResource(id = R.drawable.badgewater1)
    val badgeB = painterResource(id = R.drawable.badgewater2)
    val badgeC = painterResource(id = R.drawable.badgewater3)
    val button = painterResource(id = R.drawable.logbuttonwater)

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CategoryCard(
            badge = null, streak = null,
            categoryButton = button, navController = navController,
            title = "Water Consumption",
            titlePainter = painterResource(id = R.drawable.carbonwater),
            cardColor = waterCategoryCard,
            iconColor = waterCategoryIcon,
            categoryTextColor = waterLoggerText,
            categoryTextBgColor = waterLoggerTextBg
        )

        DailiesInterface(
            waterLoggerDailies, waterLoggerExpMap,
            waterCategoryCard, waterLoggerText,
            waterExpCard, { WaterDailiesTracker(userDailiesDone) },
            waterChecked, waterUnchecked,
            userDailiesProgress.waterDailies, (::userWaterDailiesCounter),
            (::userWaterChallengesCounter), { waterChallengesCounter() }
        )

        waterChallengesCounter()
        ChallengesInterface(
            waterLoggerChallenges, waterCategoryCard,
            waterLoggerText, { WaterChallengesTracker(userChallengesDone) },
            badgeA, badgeB, badgeC,
            userChallengesProgress.waterChallenges,
            waterProgressBarExp, waterChallengeCard
        )
    }
}

@Composable
fun WaterDailiesTracker(dailiesDone: DailiesDone) {
    var total by rememberSaveable { mutableIntStateOf(dailiesDone.waterDailiesDone) }

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
                color = waterLoggerText,
                fontSize = 24.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 0.dp, 0.dp, 0.dp)
            ) {
                LaunchedEffect(dailiesDone.waterDailiesDone) {
                    total = dailiesDone.waterDailiesDone
                }
                Text(
                    text = "$total/3",
                    color = waterLoggerText,
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
fun WaterChallengesTracker(challengesDone: ChallengesDone) {
    var total by rememberSaveable { mutableIntStateOf(challengesDone.waterChallengesDone) }

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
                color = waterLoggerText,
                fontSize = 24.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Row(
                modifier = Modifier
                    .absolutePadding(10.dp, 0.dp, 0.dp, 0.dp)
            ) {
                LaunchedEffect(challengesDone.waterChallengesDone) {
                    total = challengesDone.waterChallengesDone
                }
                Text(
                    text = "$total/3",
                    color = waterLoggerText,
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
fun CategoryCard(
    badge: Int?, streak: Int?, categoryButton: Painter,
    navController: NavController, title: String,
    titlePainter: Painter, cardColor: Color, iconColor: Color,
    categoryTextColor: Color, categoryTextBgColor:Color
) {
    val userBadges = badge ?: 0
    val userStreak = streak ?: 0

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .absolutePadding(20.dp, 20.dp, 20.dp, 20.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .size(30.dp)
                .align(Alignment.TopStart)
                .clickable {
                    navController.navigate(Screen.PageFootprintScreen.route)
                },
            painter = categoryButton,
            contentDescription = null
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .absolutePadding(0.dp, 60.dp, 0.dp, 0.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxSize(),
                colors = CardDefaults.cardColors(
                    containerColor = cardColor.copy(alpha = 0.20f)
                )
            ) {
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .absolutePadding(8.dp, 8.dp, 8.dp, 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BadgeCountDisplay(userBadges, categoryTextColor)
                StreakCountDisplay(userStreak, categoryTextColor)
            }
        }

        CategoryDisplay(
            title, titlePainter,
            iconColor, categoryTextColor, categoryTextBgColor
        )
    }
}

@Composable
fun CategoryDisplay(
    category: String, painter: Painter,
    iconColor: Color, categoryTextColor: Color,
    categoryTextBgColor:Color
) {
    Box(
        modifier = Modifier
            .width(100.dp)
            .height(150.dp)
            .absolutePadding(0.dp, 0.dp, 0.dp, 60.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier.fillMaxSize(),
            colors = CardDefaults.cardColors(
                containerColor = iconColor.copy(alpha = 0.20f)
            )
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }

    Box(
        modifier = Modifier
            .absolutePadding(0.dp, 126.dp, 0.dp, 0.dp)
            .width(280.dp)
            .height(32.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(categoryTextBgColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = category,
            color = categoryTextColor,
            fontSize = 20.sp,
            fontFamily = montserratFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
        )
    }
}

@Composable
fun BadgeCountDisplay(badge: Int, categoryTextColor: Color) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier) {
            Image(
                painter = painterResource(R.drawable.composable_badge),
                contentDescription = null,
                modifier = Modifier
                    .absolutePadding(0.dp, 0.dp, 4.dp, 0.dp)
                    .width(24.dp)
                    .height(24.dp)

            )
            Text(
                text = "Badges ",
                color = categoryTextColor,
                fontSize = 18.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
        }
        Text(
            text = badge.toString(),
            color = categoryTextColor,
            fontSize = 20.sp,
            fontFamily = robotoFamily,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
        )
    }
}

@Composable
fun StreakCountDisplay(streak: Int, categoryTextColor: Color) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier) {
            Image(
                painter = painterResource(R.drawable.streak),
                contentDescription = null,
                modifier = Modifier
                    .absolutePadding(0.dp, 0.dp, 4.dp, 0.dp)
                    .width(24.dp)
                    .height(24.dp)

            )
            Text(
                text = "Streak ",
                color = categoryTextColor,
                fontSize = 18.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
        }
        Text(
            text = streak.toString(),
            color = categoryTextColor,
            fontSize = 20.sp,
            fontFamily = robotoFamily,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
        )
    }
}

@Composable
fun DailiesInterface(
    dailies: List<String>, dailiesExp: Map<String, Float>, cardColor: Color,
    categoryTextColor: Color, categoryExpColor: Color, categoryDailiesTracker: @Composable () -> Unit,
    checkedColor: Color, uncheckedColor: Color, categoryDailies: DailiesTriple,
    userDailiesController: (dailyTuple: DailyTuple, string: String) -> Unit,
    userChallengesController: (dailyTuple: DailyTuple) -> Unit,
    categoryChallengesCounter: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .absolutePadding(20.dp, 16.dp, 20.dp, 10.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
                .absolutePadding(0.dp, 24.dp, 0.dp, 0.dp),
            contentAlignment = Alignment.Center,
        ) {
            Card(
                modifier = Modifier
                    .fillMaxSize(),
                colors = CardDefaults.cardColors(
                    containerColor = cardColor.copy(alpha = 0.20f)
                )
            ) {
            }
        }

        DailiesChecklist(
            dailies[0], dailiesExp.getOrElse(key = dailies[0]) { 20f },
            dailies[1], dailiesExp.getOrElse(key = dailies[1]) { 20f },
            dailies[2], dailiesExp.getOrElse(key = dailies[2]) { 20f },
            categoryTextColor, categoryExpColor,
            checkedColor, uncheckedColor, categoryDailies,
            userDailiesController, userChallengesController, categoryChallengesCounter
        )
        categoryDailiesTracker()
    }
}

@Composable
fun DailiesChecklist(
    dailyTargetA: String, dailyExpA: Float,
    dailyTargetB: String, dailyExpB: Float,
    dailyTargetC: String, dailyExpC: Float,
    categoryTextColor: Color, cardColor: Color,
    checkedColor: Color, uncheckedColor: Color,
    categoryDailies: DailiesTriple,
    userDailiesController: (dailyTuple: DailyTuple, string: String) -> Unit,
    userChallengesController: (dailyTuple: DailyTuple) -> Unit,
    categoryChallengesCounter: () -> Unit
) {
    Column(
        modifier = Modifier
            .absolutePadding(20.dp, 60.dp, 20.dp, 20.dp)
    ) {
        LoggerChecklist(
            dailyTargetA, dailyExpA,
            categoryTextColor, cardColor,
            checkedColor, uncheckedColor,
            categoryDailies.d1, userDailiesController,
            userChallengesController, categoryChallengesCounter
        )
       LoggerChecklist(
            dailyTargetB, dailyExpB,
            categoryTextColor, cardColor,
            checkedColor, uncheckedColor,
           categoryDailies.d2, userDailiesController,
           userChallengesController, categoryChallengesCounter
        )
        LoggerChecklist(
            dailyTargetC, dailyExpC,
            categoryTextColor, cardColor,
            checkedColor, uncheckedColor,
            categoryDailies.d3, userDailiesController,
            userChallengesController, categoryChallengesCounter
        )
    }
}

@Composable
fun LoggerChecklist(
    dailyTarget: String, dailyTargetExp: Float,
    categoryTextColor: Color, cardColor: Color,
    checkedColor: Color, uncheckedColor: Color,
    categoryDaily: DailyTuple,
    userDailiesController: (dailyTuple: DailyTuple, string: String) -> Unit,
    userChallengesController: (daliesTuple: DailyTuple) -> Unit,
    categoryChallengesCounter: () -> Unit
) {
    // checked default is false
    var checked by rememberSaveable { mutableStateOf(categoryDaily.t2) }

    Row(
        modifier = Modifier
            .absolutePadding(0.dp, 10.dp, 0.dp, 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        LaunchedEffect(categoryDaily.t2) {
            checked = categoryDaily.t2
        }
        Checkbox(
            checked = checked,
            onCheckedChange = {
                checked = it
                categoryDaily.t2 = checked
                userDailiesController(categoryDaily, categoryDaily.t1)
                userChallengesController(categoryDaily)
                              },
            colors = CheckboxDefaults.colors(
                checkedColor = checkedColor,
                uncheckedColor = uncheckedColor
            )
        )

        if (checked) {
            Row(
                modifier = Modifier
                    .width(220.dp)
                    .absolutePadding(8.dp, 0.dp, 0.dp, 0.dp)
            ) {
                Text(
                    text = dailyTarget,
                    style = TextStyle(textDecoration = TextDecoration.LineThrough),
                    color = categoryTextColor,
                    fontSize = 14.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                )
            }
        } else {
            Row(
                modifier = Modifier
                    .width(220.dp)
                    .absolutePadding(8.dp, 0.dp, 0.dp, 0.dp)
            ) {
                Text(
                    text = dailyTarget,
                    color = categoryTextColor,
                    fontSize = 14.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                )
            }
        }

        Box(
            modifier = Modifier
                .width(100.dp)
                .height(20.dp)
                .absolutePadding(10.dp, 0.dp, 0.dp, 0.dp),
            contentAlignment = Alignment.Center
        ) {
            if (checked) {
                Card(
                    modifier = Modifier
                        .fillMaxSize(),
                    colors = CardDefaults.cardColors(
                        containerColor = cardColor
                    )
                ) {
                }
                Text(
                    text = "+" + dailyTargetExp.toInt().toString() + " EXP",
                    color = categoryTextColor,
                    fontSize = 12.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
            } else {
                Card(
                    modifier = Modifier
                        .fillMaxSize(),
                    colors = CardDefaults.cardColors(
                        containerColor = cardColor.copy(alpha = 0.20f)
                    )
                ) {
                }
                Text(
                    text = dailyTargetExp.toInt().toString() + " EXP",
                    color = categoryTextColor,
                    fontSize = 12.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
fun ChallengesInterface(
    challenges: List<String>, cardColor: Color,
    categoryTextColor: Color, categoryChallengesTracker: @Composable () -> Unit,
    badgeA: Painter, badgeB: Painter, badgeC: Painter,
    categoryChallenges: ChallengesTriple, progressBarColor: Color, challengeCard: Color
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .absolutePadding(20.dp, 0.dp, 20.dp, 20.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(290.dp)
                .absolutePadding(0.dp, 24.dp, 0.dp, 0.dp),
            contentAlignment = Alignment.Center,
        ) {
            Card(
                modifier = Modifier
                    .fillMaxSize(),
                colors = CardDefaults.cardColors(
                    containerColor = cardColor.copy(alpha = 0.20f)
                )
            ) {
            }
        }

        categoryChallengesTracker()
        BadgesInterface(
            challenges, badgeA, badgeB, badgeC,
            categoryTextColor, categoryChallenges,
            progressBarColor, challengeCard
        )
    }
}

@Composable
fun BadgesInterface(
    challenges: List<String>, badgeA: Painter,
    badgeB: Painter, badgeC: Painter,
    categoryTextColor: Color, categoryChallenges: ChallengesTriple,
    progressBarColor: Color, challengeCard: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .absolutePadding(5.dp, 60.dp, 5.dp, 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        LoggerBadge(
            badgeA, challenges[0],
            categoryChallenges.c1,
            categoryTextColor, progressBarColor, challengeCard
        )
        LoggerBadge(
            badgeB, challenges[1],
            categoryChallenges.c2,
            categoryTextColor, progressBarColor, challengeCard
        )
        LoggerBadge(
            badgeC, challenges[2],
            categoryChallenges.c3,
            categoryTextColor, progressBarColor, challengeCard
        )
    }
}

@Composable
fun LoggerBadge(
    badge: Painter, challenge: String,
    categoryChallenge: ProgressTuple, categoryTextColor: Color,
    progressBarColor: Color, challengeCard: Color
) {
    var done by rememberSaveable { mutableStateOf(categoryChallenge.done == categoryChallenge.alpha) }

    Column(
        modifier = Modifier
            .height(210.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LaunchedEffect(categoryChallenge) {
            done = categoryChallenge.done == categoryChallenge.alpha
        }
        if (done) {
            Image(
                painter = badge,
                modifier = Modifier
                    .width(110.dp)
                    .height(100.dp),
                contentDescription = null
            )
        } else {
            Image(
                painter = badge,
                modifier = Modifier
                    .width(110.dp)
                    .height(100.dp),
                colorFilter = ColorFilter.colorMatrix(
                    ColorMatrix().apply { setToSaturation(0f) }
                ),
                contentDescription = null
            )
        }

        Box(
            modifier = Modifier,
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .height(50.dp)
                    .width(110.dp),
                colors = CardDefaults.cardColors(
                    containerColor = challengeCard.copy(alpha = 0.20f)
                )
            ) {
            }
            Text(
                text = challenge,
                textAlign = TextAlign.Center,
                color = categoryTextColor,
                fontSize = 12.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
            )
        }

        BadgeProgressBar(categoryChallenge, progressBarColor, categoryTextColor)
    }
}

@Composable
fun BadgeProgressBar(userExp: ProgressTuple, progressBarColor: Color, categoryTextColor: Color) {
    var exp by rememberSaveable {
        mutableFloatStateOf(
            (userExp.done).toFloat()/(userExp.alpha).toFloat()
        )
    }
    var progress by rememberSaveable { mutableFloatStateOf(exp) }
    var done by rememberSaveable { mutableIntStateOf((userExp.done)) }
    var alpha by rememberSaveable { mutableIntStateOf(userExp.alpha) }

    val size by animateFloatAsState(
        targetValue = progress,
        tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
    )

    // Dynamic Progress Bar
    Column(
        modifier = Modifier
            .width(105.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LaunchedEffect(userExp) {
            exp = (userExp.done).toFloat()/(userExp.alpha).toFloat()
            progress = exp
            done = userExp.done
            alpha = userExp.alpha
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(18.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(9.dp))
                    .background(Color.White)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(size)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(9.dp))
                    .background(progressBarColor)
                    .animateContentSize()
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "$done/$alpha",
                textAlign = TextAlign.Center,
                color = categoryTextColor,
                fontSize = 16.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
        }
    }

    // Static Progres Bar
    /*
    LinearProgressIndicator(
        modifier = Modifier
            .width(105.dp)
            .height(18.dp),
        progress = { exp },
        color = progressBarColor
    )
    */
}


@Preview(showBackground = true)
@Composable
fun FootprintLoggerWaterScreenPreview() {
    val navController = rememberNavController()
    FootprintLoggerWaterScreen(navController = navController)
}
