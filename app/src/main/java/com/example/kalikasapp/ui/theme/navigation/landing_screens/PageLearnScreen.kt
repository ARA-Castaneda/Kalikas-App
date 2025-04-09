package com.example.kalikasapp.ui.theme.navigation.landing_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kalikasapp.ui.theme.Lesson_duration
import com.example.kalikasapp.ui.theme.Lesson_favorite
import com.example.kalikasapp.ui.theme.Lesson_modules
import com.example.kalikasapp.ui.theme.Lesson_saves
import com.example.kalikasapp.ui.theme.robotoFamily
import com.example.kalikasapp.ui.theme.soraFamily

enum class LearnPageState {
    LessonsList,
    SavedList
}

data class LearnNavigationItem(
    val lazyList: LearnPageState,
    var selectedIcon: ImageVector,
    var hasNews: Boolean,
    var badgeCount: Int? = null
)

val learnText = Color(0xFF113822)
val unsaveIcon = Color(0xFF3ABF74)
val saveIcon = Color(0xFF113822)

@Composable
fun PageLearnScreen(navController: NavController) {
    // load lesson modules data
    loadLessons()

    val green = Color(0xFF1E653E)
    val lightGreen = Color(0xFF39C076)
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

    val items = listOf(
        LearnNavigationItem(
            lazyList = LearnPageState.LessonsList,
            selectedIcon = Lesson_modules,
            hasNews = false
        ),
        LearnNavigationItem(
            lazyList = LearnPageState.SavedList,
            selectedIcon = Lesson_saves,
            hasNews = false
        )
    )

    var currentLearnPageState by rememberSaveable { mutableStateOf(LearnPageState.LessonsList) }

    Scaffold(
        topBar = {
            NavigationBar(
                modifier = Modifier
                    .background(Color.Transparent),
                containerColor = Color.Transparent
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                            currentLearnPageState = item.lazyList
                        },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (item.badgeCount != null) {
                                        Badge {
                                            Text(text = item.badgeCount.toString())
                                        }
                                    } else if (item.hasNews) {
                                        Badge()
                                    }
                                }
                            ) {
                                if (index == selectedItemIndex) {
                                    Icon(
                                        imageVector = item.selectedIcon,
                                        tint = green,
                                        contentDescription = null,
                                        modifier = Modifier.size(60.dp)
                                    )
                                } else {
                                    Icon(
                                        imageVector = item.selectedIcon,
                                        tint = lightGreen,
                                        contentDescription = null,
                                        modifier = Modifier.size(60.dp)
                                    )
                                }
                            }
                        }
                    )
                }
            }
        },
        bottomBar = {
            BottomNavBar(navController)
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (currentLearnPageState == LearnPageState.LessonsList) {
                    LearnLessonsScreen()
                } else {
                    LearnSavedScreen()
                }
            }
        }
    )
}

// Composable for displaying lazy list of available lessons
@Composable
fun LearnLessonsScreen() {
    // Header column display
    Box(
        modifier = Modifier
            .width(350.dp)
            .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
    ) {
        Text(
            text = "Free Lessons",
            color = learnText,
            fontSize = 24.sp,
            fontFamily = soraFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
        )
    }

    // Lazy column for lessons list
    LessonModule(
        author = lessonA.author, title = lessonA.title,
        duration = lessonA.duration, description = lessonA.description,
        tags = lessonA.tags,
        authorImage = painterResource(lessonA.authorImage),
        tagA = lessonA.tagA,
        tagB = lessonA.tagB,
        infoColor = lessonA.infoColor,
        cardColor = lessonA.cardColor,
        lessonA, lessonA.favorite
    )
    LessonModule(
        author = lessonB.author, title = lessonB.title,
        duration = lessonB.duration, description = lessonB.description,
        tags = lessonB.tags,
        authorImage = painterResource(lessonB.authorImage),
        tagA = lessonB.tagA,
        tagB = lessonB.tagB,
        infoColor = lessonB.infoColor,
        cardColor = lessonB.cardColor,
        lessonB, lessonB.favorite
    )
    LessonModule(
        author = lessonC.author, title = lessonC.title,
        duration = lessonC.duration, description = lessonC.description,
        tags = lessonC.tags,
        authorImage = painterResource(lessonC.authorImage),
        tagA = lessonC.tagA,
        tagB = lessonC.tagB,
        infoColor = lessonC.infoColor,
        cardColor = lessonC.cardColor,
        lessonC, lessonC.favorite
    )
    LessonModule(
        author = lessonD.author, title = lessonD.title,
        duration = lessonD.duration, description = lessonD.description,
        tags = lessonD.tags,
        authorImage = painterResource(lessonD.authorImage),
        tagA = lessonD.tagA,
        tagB = lessonD.tagB,
        infoColor = lessonD.infoColor,
        cardColor = lessonD.cardColor,
        lessonD, lessonD.favorite
    )
    LessonModule(
        author = lessonE.author, title = lessonE.title,
        duration = lessonE.duration, description = lessonE.description,
        tags = lessonE.tags,
        authorImage = painterResource(lessonE.authorImage),
        tagA = lessonE.tagA,
        tagB = lessonE.tagB,
        infoColor = lessonE.infoColor,
        cardColor = lessonE.cardColor,
        lessonE, lessonE.favorite
    )
    LessonModule(
        author = lessonF.author, title = lessonF.title,
        duration = lessonF.duration, description = lessonF.description,
        tags = lessonF.tags,
        authorImage = painterResource(lessonF.authorImage),
        tagA = lessonF.tagA,
        tagB = lessonF.tagB,
        infoColor = lessonF.infoColor,
        cardColor = lessonF.cardColor,
        lessonF, lessonF.favorite
    )
}

// Composable for displaying lazy list of available lessons
@Composable
fun LearnSavedScreen() {
    // Header column display
    Box(
        modifier = Modifier
            .width(350.dp)
            .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
    ) {
        Text(
            text = "Your Favorites",
            color = learnText,
            fontSize = 24.sp,
            fontFamily = soraFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
        )
    }

    // Lazy column for lessons list
    if (lessonA.favorite) {
        LessonModule(
            author = lessonA.author, title = lessonA.title,
            duration = lessonA.duration, description = lessonA.description,
            tags = lessonA.tags,
            authorImage = painterResource(lessonA.authorImage),
            tagA = lessonA.tagA,
            tagB = lessonA.tagB,
            infoColor = lessonA.infoColor,
            cardColor = lessonA.cardColor,
            lessonA, lessonA.favorite
        )
    }
    if (lessonB.favorite) {
        LessonModule(
            author = lessonB.author, title = lessonB.title,
            duration = lessonB.duration, description = lessonB.description,
            tags = lessonB.tags,
            authorImage = painterResource(lessonB.authorImage),
            tagA = lessonB.tagA,
            tagB = lessonB.tagB,
            infoColor = lessonB.infoColor,
            cardColor = lessonB.cardColor,
            lessonB, lessonB.favorite
        )
    }
    if (lessonC.favorite) {
        LessonModule(
            author = lessonC.author, title = lessonC.title,
            duration = lessonC.duration, description = lessonC.description,
            tags = lessonC.tags,
            authorImage = painterResource(lessonC.authorImage),
            tagA = lessonC.tagA,
            tagB = lessonC.tagB,
            infoColor = lessonC.infoColor,
            cardColor = lessonC.cardColor,
            lessonC, lessonC.favorite
        )
    }
    if (lessonD.favorite) {
        LessonModule(
            author = lessonD.author, title = lessonD.title,
            duration = lessonD.duration, description = lessonD.description,
            tags = lessonD.tags,
            authorImage = painterResource(lessonD.authorImage),
            tagA = lessonD.tagA,
            tagB = lessonD.tagB,
            infoColor = lessonD.infoColor,
            cardColor = lessonD.cardColor,
            lessonD, lessonD.favorite
        )
    }
    if (lessonE.favorite) {
        LessonModule(
            author = lessonE.author, title = lessonE.title,
            duration = lessonE.duration, description = lessonE.description,
            tags = lessonE.tags,
            authorImage = painterResource(lessonE.authorImage),
            tagA = lessonE.tagA,
            tagB = lessonE.tagB,
            infoColor = lessonE.infoColor,
            cardColor = lessonE.cardColor,
            lessonE, lessonE.favorite
        )
    }
    if (lessonF.favorite) {
        LessonModule(
            author = lessonF.author, title = lessonF.title,
            duration = lessonF.duration, description = lessonF.description,
            tags = lessonF.tags,
            authorImage = painterResource(lessonF.authorImage),
            tagA = lessonF.tagA,
            tagB = lessonF.tagB,
            infoColor = lessonF.infoColor,
            cardColor = lessonF.cardColor,
            lessonF, lessonF.favorite
        )
    }
}

@Composable
fun LessonModule(
    author: String, title: String,
    duration: String, description: String,
    tags: List<String>, authorImage: Painter,
    tagA: Color, tagB: Color,
    infoColor: Color, cardColor: Color,
    lessonX: LessonModule, status: Boolean
) {
    var isSaved by rememberSaveable { mutableStateOf(status) }

    Column(
        modifier = Modifier
            .absolutePadding(10.dp, 0.dp, 10.dp, 20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Lesson info card
        Card(
            modifier = Modifier
                .width(350.dp)
                .absolutePadding(0.dp, 0.dp, 0.dp, 0.dp),
            colors = CardDefaults.cardColors(
                containerColor = infoColor
            )
        ) {
            // lesson main details
            Row(
                modifier = Modifier
                    .width(350.dp)
                    .absolutePadding(10.dp, 10.dp, 0.dp, 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = authorImage,
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )

                Column(
                    modifier = Modifier
                        .absolutePadding(20.dp, 0.dp, 0.dp, 0.dp),
                ) {
                    // lesson author or publisher
                    Row(
                        modifier = Modifier.width(250.dp)
                    ) {
                        Text(
                            text = author,
                            color = exploreText,
                            fontSize = 14.sp,
                            fontFamily = robotoFamily,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                        )
                    }

                    // lesson title
                    Row(
                        modifier = Modifier
                            .width(250.dp)
                            .absolutePadding(0.dp, 5.dp, 0.dp, 0.dp)
                    ) {
                        Text(
                            text = title,
                            color = exploreText,
                            fontSize = 16.sp,
                            fontFamily = soraFamily,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                        )
                    }

                    // lesson duration
                    Row(
                        modifier = Modifier
                            .width(120.dp)
                            .absolutePadding(0.dp, 5.dp, 0.dp, 0.dp)
                    ) {
                        Icon(
                            imageVector = Lesson_duration,
                            contentDescription = null,
                            tint = durationIcon,
                            modifier = Modifier.size(16.dp)
                        )

                        Row(
                            modifier = Modifier
                                .absolutePadding(5.dp, 0.dp, 0.dp, 0.dp)
                        ) {
                            Text(
                                text = duration,
                                color = exploreText,
                                fontSize = 12.sp,
                                fontFamily = robotoFamily,
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                            )
                        }
                    }
                }
            }

            // lesson tagging and saving
            Row(
                modifier = Modifier
                    .width(350.dp)
                    .absolutePadding(10.dp, 0.dp, 10.dp, 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // lesson subject tags
                Row(
                    modifier = Modifier
                        .absolutePadding(10.dp, 0.dp, 0.dp, 0.dp)
                        .height(50.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier
                            .height(30.dp)
                            .background(
                                color = tagA,
                                shape = RoundedCornerShape(20.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = tags[0],
                            color = Color.White,
                            fontSize = 14.sp,
                            fontFamily = robotoFamily,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .absolutePadding(10.dp, 0.dp, 10.dp, 0.dp)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .height(30.dp)
                            .absolutePadding(10.dp, 0.dp, 0.dp, 0.dp)
                            .background(
                                color = tagB,
                                shape = RoundedCornerShape(20.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = tags[1],
                            color = Color.White,
                            fontSize = 14.sp,
                            fontFamily = robotoFamily,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .absolutePadding(10.dp, 0.dp, 10.dp, 0.dp)
                        )
                    }
                }

                // lesson save button
                IconButton(
                    onClick = { isSaved = !isSaved },
                    modifier = Modifier,
                    colors = IconButtonColors(
                        containerColor = Color.LightGray,
                        contentColor = unsaveIcon,
                        disabledContainerColor = Color.LightGray,
                        disabledContentColor = unsaveIcon
                    )
                ) {
                    if (isSaved) {
                        saveLesson(lessonX)
                        Icon(
                            imageVector = Lesson_favorite,
                            contentDescription = null,
                            tint = saveIcon,
                            modifier = Modifier.size(40.dp)
                        )
                    } else {
                        unsaveLesson(lessonX)
                        Icon(
                            imageVector = Lesson_favorite,
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }
            }
        }

        // Lesson summary card
        Card(
            modifier = Modifier
                .width(350.dp)
                .absolutePadding(0.dp, 5.dp, 0.dp, 0.dp),
            colors = CardDefaults.cardColors(
                containerColor = cardColor
            )
        ) {
            Row(
                modifier = Modifier
                    .width(350.dp)
                    .absolutePadding(15.dp, 15.dp, 15.dp, 15.dp)
            ) {
                Text(
                    text = description,
                    color = exploreText,
                    fontSize = 14.sp,
                    fontFamily = soraFamily,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PageLearnPreview() {
    val navController = rememberNavController()
    PageLearnScreen(navController = navController)
}
