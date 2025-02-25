package com.example.kalikasapp.ui.theme.navigation.footprint_screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kalikasapp.ui.theme.navigation.landing_screens.FootprintModel
import com.example.kalikasapp.ui.theme.navigation.landing_screens.energyPrint
import com.example.kalikasapp.ui.theme.navigation.landing_screens.foodPrint
import com.example.kalikasapp.ui.theme.navigation.landing_screens.transpoPrint
import com.example.kalikasapp.ui.theme.navigation.landing_screens.wastePrint
import com.example.kalikasapp.ui.theme.navigation.landing_screens.waterPrint
import kotlinx.coroutines.delay

@Composable
fun FootprintPieChart(
    data: List<FootprintModel>,
    size: Dp = 160.dp,
    strokeWidth: Dp = 26.dp
) {
    Canvas(
        modifier = Modifier
            .size(size),

        onDraw = {
            var startAngle = 0f
            var sweepAngle = 0f

            data.forEach {
                sweepAngle = (it.value / 100) * 360

                drawArc(
                    color = it.color,
                    startAngle = startAngle,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    style = Stroke(
                        width = strokeWidth.toPx(),
                        cap = StrokeCap.Round,
                        join = StrokeJoin.Round
                    )
                )

                startAngle += sweepAngle
            }
        }
    )

}
