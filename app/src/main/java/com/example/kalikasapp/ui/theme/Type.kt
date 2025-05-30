package com.example.kalikasapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.kalikasapp.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val solwayFamily = FontFamily(
    Font(R.font.solway_bold, FontWeight.Bold),
    Font(R.font.solway_extrabold, FontWeight.ExtraBold),
    Font(R.font.solway_light, FontWeight.Light),
    Font(R.font.solway_medium, FontWeight.Medium),
    Font(R.font.solway_regular, FontWeight.Normal)
)

val soraFamily = FontFamily(
    Font(R.font.sora_bold, FontWeight.Bold),
    Font(R.font.sora_extrabold, FontWeight.ExtraBold),
    Font(R.font.sora_extralight, FontWeight.ExtraLight),
    Font(R.font.sora_light, FontWeight.Light),
    Font(R.font.sora_medium, FontWeight.Medium),
    Font(R.font.sora_regular, FontWeight.Normal),
    Font(R.font.sora_thin, FontWeight.Thin)
)

val montserratFamily = FontFamily(
    Font(R.font.montserrat_bold, FontWeight.Bold),
    Font(R.font.montserrat_extrabold, FontWeight.ExtraBold),
    Font(R.font.montserrat_extralight, FontWeight.ExtraLight),
    Font(R.font.montserrat_light, FontWeight.Light),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_thin, FontWeight.Thin)
)

val opensansFamily = FontFamily(
    Font(R.font.opensans_bold, FontWeight.Bold),
    Font(R.font.opensans_extrabold, FontWeight.ExtraBold),
    Font(R.font.opensans_light, FontWeight.Light),
    Font(R.font.opensans_medium, FontWeight.Medium),
    Font(R.font.opensans_regular, FontWeight.Normal),
)

val robotoFamily = FontFamily(
    Font(R.font.roboto_bold, FontWeight.Bold),
    Font(R.font.roboto_extrabold, FontWeight.ExtraBold),
    Font(R.font.roboto_extralight, FontWeight.ExtraLight),
    Font(R.font.roboto_light, FontWeight.Light),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_regular, FontWeight.Normal),
)

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */