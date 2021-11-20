package com.artemissoftware.shapesnsizes.ui.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.shapesnsizes.ui.models.shapes.TriangleShape
import com.artemissoftware.shapesnsizes.ui.models.shapes.drawTrianglePath

@Composable
@Preview
fun Circle(modifier: Modifier = Modifier.size(50.dp)) {
    Canvas(modifier = modifier, onDraw = {
        val size = 50.dp.toPx()
        drawCircle(
            color = Color.Red,
            radius = size / 2f,
        )
    })
}


@Composable
@Preview
fun TriangleAndCircle(modifier: Modifier = Modifier.size(50.dp)) {
    Canvas(modifier = modifier, onDraw = {
        val size = 50.dp.toPx()
        drawCircle(
            color = Color.Red,
            radius = size / 2f,
        )
        drawPath(
            color = Color.Green,
            path = drawTrianglePath(Size(size, size))
        )
    })
}

@Composable
@Preview
fun TriangleTopCircle(modifier: Modifier = Modifier.size(width = 50.dp, 100.dp)) {
    Canvas(modifier = modifier, onDraw = {
        val size = 50.dp.toPx()

        val height = 100.dp.toPx()
        val width = 50.dp.toPx()
        val circleRadius = width / 2f

        val trianglePath = Path().apply {
            // Moves to top center position
            moveTo(width / 2f, 0f)
            // Add line to right corner above circle
            lineTo(x = width, y = height - circleRadius * 2)
            //Add line to left corner above circle
            lineTo(x = 0f, y = height - circleRadius * 2)
        }

        drawCircle(
            color = Color.Red,
            radius = circleRadius,
            center = Offset(
                x = width / 2,
                y = height - circleRadius
            )
        )
        drawPath(
            color = Color.Green,
            path = trianglePath
        )
    })
}


@Preview(showBackground = false)
@Composable
private fun DefaultPreview() {

    Column() {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Red, shape = RoundedCornerShape(25.dp))
        ) {

        }

        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(shape = TriangleShape())
                .background(Color.Red)
        )


    }

}