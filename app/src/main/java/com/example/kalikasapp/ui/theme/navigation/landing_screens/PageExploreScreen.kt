package com.example.kalikasapp.ui.theme.navigation.landing_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kalikasapp.R
import com.example.kalikasapp.ui.theme.Explore_anecdote
import com.example.kalikasapp.ui.theme.robotoFamily
import com.example.kalikasapp.ui.theme.soraFamily

val exploreText = Color(0xFF113822)
val exploreSubText = Color(0xFF1E653E)
val waterTipCard = Color(0XFF1F5D9E)
val energyTipCard = Color(0XFFFFD577)
val transpoTipCard = Color(0XFF866ABF)
val foodTipCard = Color(0XFFF07579)
val wasteTipCard = Color(0XFFA55649)
val durationCard = Color(0xFF1E653E)
val durationIcon = Color(0xFF113822)
val anecdoteCard = Color(0xFF1E653E)

@Composable
fun PageExploreScreen(navController: NavController) {
    Scaffold(
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
                // Daily sustainability tips
                Box(
                    modifier = Modifier
                ) {
                    SustainabilityTip(
                        headerText = exploreText, tipText = exploreSubText,
                        cardColor = waterTipCard,
                        categoryTip = "Water Sustainability",
                        tip = systemWaterTip,
                        painterResource(R.drawable.holderasset),
                        painterResource(R.drawable.holderasset)
                    )

                    // Implement multiple daily tips in improved UI
                    /*
                    SmallFloatingActionButton(
                        onClick = { /***/ },
                        containerColor = buttonContainer.copy(alpha = 0.5f),
                        contentColor = buttonContent.copy(alpha = 0.5f),
                        modifier = Modifier
                            .absolutePadding(0.dp, 0.dp, 15.dp, 25.dp)
                            .align(Alignment.BottomEnd)
                            .size(40.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    */
                }

                // Sustainable-living tutorials
                Row(
                    modifier = Modifier
                        .width(350.dp)
                        .absolutePadding(10.dp, 0.dp, 10.dp, 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    SustainabilityTutorial(
                        duration = systemFoodTutorial[0],
                        tutorial = systemFoodTutorial[1],
                        tutorialImage = painterResource(R.drawable.holdertutorial)
                    )
                    SustainabilityTutorial(
                        duration = systemWasteTutorial[0],
                        tutorial = systemWasteTutorial[1],
                        tutorialImage = painterResource(R.drawable.holdertutorial)
                    )
                }

                // Sustainability anecdotes
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SustainabilityAnecdote(
                        duration = systemAnecdoteA[0], title = systemAnecdoteA[1],
                        sourceImage = painterResource(R.drawable.holderprofile),
                        anecdoteImage = painterResource(R.drawable.holdertutorial),
                        anecdote = systemAnecdoteA[2]
                    )
                    SustainabilityAnecdote(
                        duration = systemAnecdoteB[0], title = systemAnecdoteB[1],
                        sourceImage = painterResource(R.drawable.holderprofile),
                        anecdoteImage = painterResource(R.drawable.holdertutorial),
                        anecdote = systemAnecdoteB[2]
                    )
                    SustainabilityAnecdote(
                        duration = systemAnecdoteC[0], title = systemAnecdoteC[1],
                        sourceImage = painterResource(R.drawable.holderprofile),
                        anecdoteImage = painterResource(R.drawable.holdertutorial),
                        anecdote = systemAnecdoteC[2]
                    )
                    SustainabilityAnecdote(
                        duration = systemAnecdoteD[0], title = systemAnecdoteD[1],
                        sourceImage = painterResource(R.drawable.holderprofile),
                        anecdoteImage = painterResource(R.drawable.holdertutorial),
                        anecdote = systemAnecdoteD[2]
                    )
                    SustainabilityAnecdote(
                        duration = systemAnecdoteE[0], title = systemAnecdoteE[1],
                        sourceImage = painterResource(R.drawable.holderprofile),
                        anecdoteImage = painterResource(R.drawable.holdertutorial),
                        anecdote = systemAnecdoteE[2]
                    )
                }
            }
        }
    )
}

@Composable
fun SustainabilityTip(
    headerText: Color, tipText: Color, cardColor: Color,
    categoryTip: String, tip: String,
    categoryImage: Painter, tipImage: Painter
) {
    Column(
        modifier = Modifier
            .absolutePadding(10.dp, 20.dp, 10.dp, 20.dp)
    ) {
        Text(
            text = "Today's Tip", // "Today's Tips"
            color = headerText,
            fontSize = 24.sp,
            fontFamily = soraFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
        )

        Card(
            modifier = Modifier
                .width(350.dp)
                .height(150.dp),
            colors = CardDefaults.cardColors(
                containerColor = cardColor.copy(alpha = 0.2f),
                disabledContainerColor = cardColor.copy(alpha = 0.2f)
            )
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .width(220.dp)
                        .height(140.dp)
                        .absolutePadding(10.dp, 10.dp, 0.dp, 10.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {
                    Image(
                        painter = categoryImage,
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    Text(
                        text = categoryTip,
                        color = tipText,
                        fontSize = 16.sp,
                        fontFamily = robotoFamily,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                    )
                    Text(
                        text = tip,
                        color = tipText,
                        fontSize = 12.sp,
                        fontFamily = robotoFamily,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                    )
                }

                Image(
                    painter = tipImage,
                    contentDescription = null,
                    modifier = Modifier
                        .absolutePadding(0.dp, 10.dp, 10.dp, 10.dp)
                        .size(120.dp)
                )
            }
        }
    }
}

@Composable
fun SustainabilityTutorial(
    duration: String, tutorial: String, tutorialImage: Painter
) {
    Box(
        modifier = Modifier
            .width(160.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = tutorialImage,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .absolutePadding(10.dp, 10.dp, 10.dp, 10.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Box(
                modifier = Modifier
                    .width(64.dp)
                    .height(24.dp)
                    .background(
                        color = durationCard.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Filled.PlayArrow,
                        contentDescription = null,
                        tint = durationIcon,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = duration,
                        color = Color.White,
                        fontSize = 10.sp,
                        fontFamily = robotoFamily,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                    )
                }
            }

            Text(
                text = tutorial,
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun SustainabilityAnecdote(
    duration: String, title: String,
    sourceImage: Painter, anecdoteImage: Painter, anecdote: String
) {
    Column(
        modifier = Modifier
            .absolutePadding(10.dp, 20.dp, 10.dp, 0.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .width(300.dp)
                .absolutePadding(10.dp, 0.dp, 0.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = sourceImage,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )

            Column(
                modifier = Modifier
                    .absolutePadding(20.dp, 0.dp, 0.dp, 0.dp),
            ) {
                Row(
                    modifier = Modifier.width(250.dp)
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

                Row(
                    modifier = Modifier
                        .width(120.dp)
                        .absolutePadding(0.dp, 5.dp, 0.dp, 0.dp)
                ) {
                    Icon(
                        imageVector = Explore_anecdote,
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

        Card(
            modifier = Modifier
                .width(350.dp)
                .height(180.dp)
                .absolutePadding(0.dp, 10.dp, 0.dp, 0.dp)
        ) {
            Image(
                painter = anecdoteImage,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Card(
            modifier = Modifier
                .width(350.dp)
                .absolutePadding(0.dp, 10.dp, 0.dp, 0.dp),
            colors = CardDefaults.cardColors(
                containerColor = anecdoteCard.copy(alpha = 0.2f)
            )
        ) {
            Row(
                modifier = Modifier
                    .width(350.dp)
                    .absolutePadding(15.dp, 15.dp, 15.dp, 15.dp)
            ) {
                Text(
                    text = anecdote,
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
fun PageExplorePreview() {
    val navController = rememberNavController()
    PageExploreScreen(navController = navController)
}
