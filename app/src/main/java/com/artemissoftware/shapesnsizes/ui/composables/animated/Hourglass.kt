package com.artemissoftware.shapesnsizes.ui.composables

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.foundation.Canvas
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


val white = Color(0xFFffffff)
val grey100 = Color(0xFFf5f5f5)
val grey300 = Color(0xFFe0e0e0)
val grey500 = Color(0xFF9e9e9e)
val grey700 = Color(0xFF616161)
val grey900 = Color(0xFF212121)
val grey = Color(0xFF181818)
val black = Color(0xFF000000)


//@Preview(showBackground = false)
@Composable
private fun DrawRoundRectangle(scale: Float, lineColor: Color = grey900) {

    Canvas(
        modifier = Modifier.fillMaxWidth().height(60.dp).graphicsLayer {
            scaleX = scale
            scaleY = scale
        }
    ) {
        val canvasSize = size
        val canvasWidth = size.width
        val canvasHeight = size.height

        drawRoundRect(
            size = canvasSize / 2F,
            cornerRadius = CornerRadius(60F, 60F),
            color = lineColor,
            style = Stroke(width = 16F),
            topLeft = Offset(
                x = canvasWidth / 4F,
                y = canvasHeight / 3F
            )
        )
    }

}


//@Preview(showBackground = false)
@Composable
fun DrawLines(scale: Float, lineColor: Color = grey900) {

    Canvas(
        modifier = Modifier.fillMaxWidth().height(180.dp)
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
    ) {

        // Left top
        drawSingleLine(340f, -20f, 340f, 140f, lineColor, drawScope = this)
        // Left top diagonal
        drawSingleLine(340f, 140f, 460f, 260f, lineColor, drawScope = this)
        // Left bottom diagonal
        drawSingleLine(460f, 260f, 340f, 380f, lineColor, drawScope = this)
        // Left bottom
        drawSingleLine(340f, 380f, 340f, 600f, lineColor, drawScope = this)



        // Right bottom
        drawSingleLine(740f, 380f, 740f, 600f, lineColor, drawScope = this)
        // Right top diagonal
        drawSingleLine(740f, 140f, 620f, 260f, lineColor, drawScope = this)
        // Right bottom diagonal
        drawSingleLine(620f, 260f, 740f, 380f, lineColor, drawScope = this)
        // Right top
        drawSingleLine(740f, -20f, 740f, 140f, lineColor, drawScope = this)
    }

}


fun drawSingleLine(
    startX: Float,
    startY: Float,
    endX: Float,
    endY: Float,
    lineColor: Color = grey900,
    drawScope: DrawScope
) {
    drawScope.drawLine(
        start = Offset(startX, startY),
        end = Offset(endX, endY),
        color = lineColor,
        strokeWidth = 16F,
        cap = StrokeCap.Round
    )
}


@Composable
fun colorShapeTransition(
    initialValue: Color,
    targetValue: Color,
    durationMillis: Int
): Color {
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = initialValue,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    return color
}

@Composable
fun scaleShapeTransition(
    initialValue: Float,
    targetValue: Float,
    durationMillis: Int
): Float {
    val infiniteTransition = rememberInfiniteTransition()
    val scale: Float by infiniteTransition.animateFloat(
        initialValue = initialValue,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis),
            repeatMode = RepeatMode.Restart
        )
    )

    return scale
}

@Preview(showBackground = false)
@Composable
fun Hourglass() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val lineColor = colorShapeTransition(grey900, grey100, 2000)
        val scale = scaleShapeTransition(0.1f, 1f, 2000)

        DrawRoundRectangle(scale, lineColor)
        DrawLines(scale, lineColor)
        DrawRoundRectangle(scale, lineColor)
    }
}

@Composable
fun HourglassAnimation() {

    Surface(
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                Text(
                    text = "Hourglass Animation",
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(16.dp)
                )
            }
        ) {
            Hourglass()
        }
    }
}
