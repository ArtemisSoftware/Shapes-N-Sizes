package com.artemissoftware.shapesnsizes.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.foundation.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
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


@Preview(showBackground = false)
@Composable
fun DrawRoundRectangle() {

    Canvas(
        modifier = Modifier.fillMaxWidth().height(60.dp)
    ) {
        val canvasSize = size
        val canvasWidth = size.width
        val canvasHeight = size.height

        drawRoundRect(
            size = canvasSize / 2F,
            cornerRadius = CornerRadius(60F, 60F),
            color = grey900,
            style = Stroke(width = 16F),
            topLeft = Offset(
                x = canvasWidth / 4F,
                y = canvasHeight / 3F
            )
        )
    }

}


@Preview(showBackground = false)
@Composable
fun DrawLines() {

    Canvas(
        modifier = Modifier.fillMaxWidth().height(180.dp)
    ) {
        // Left top
        drawSingleLine(340f, -20f, 340f, 140f, this)
        // Left top diagonal
        drawSingleLine(340f, 140f, 460f, 260f, this)
        // Left bottom diagonal
        drawSingleLine(460f, 260f, 340f, 380f, this)
        // Left bottom
        drawSingleLine(340f, 380f, 340f, 540f, this)
        // Right bottom
        drawSingleLine(740f, 380f, 740f, 540f, this)
        // Right top diagonal
        drawSingleLine(740f, 140f, 620f, 260f, this)
        // Right bottom diagonal
        drawSingleLine(620f, 260f, 740f, 380f, this)
        // Right top
        drawSingleLine(740f, -20f, 740f, 140f, this)
    }

}


fun drawSingleLine(
    startX: Float,
    startY: Float,
    endX: Float,
    endY: Float,
    drawScope: DrawScope
) {
    drawScope.drawLine(
        start = Offset(startX, startY),
        end = Offset(endX, endY),
        color = grey900,
        strokeWidth = 16F,
        cap = StrokeCap.Round
    )
}


@Preview(showBackground = false)
@Composable
fun Hourglass() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        DrawRoundRectangle()
        DrawLines()
        DrawRoundRectangle()
    }
}


