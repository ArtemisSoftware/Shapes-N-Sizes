package com.artemissoftware.shapesnsizes.ui.composables

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = false)
@Composable
fun InstagramIcon() {
    val instaColors = listOf(Color.Yellow, Color.Red, Color.Magenta)
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        drawRoundRect(
            brush = Brush.linearGradient(colors = instaColors),
            cornerRadius = CornerRadius(60f, 60f),
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )
        drawCircle(
            brush = Brush.linearGradient(colors = instaColors),
            radius = 45f,
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )
        drawCircle(
            brush = Brush.linearGradient(colors = instaColors),
            radius = 13f,
            center = Offset(this.size.width * .80f, this.size.height * 0.20f),
        )
    }
}


@Preview(showBackground = false)
@Composable
fun FacebookIcon() {
    val assetManager = LocalContext.current.assets

    val paint = Paint().apply {
        textAlign = Paint.Align.CENTER
        textSize = 200f
        color = Color.White.toArgb()

    }

    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        drawRoundRect(
            color = Color(0xFF1776d1),
            cornerRadius = CornerRadius(20f, 20f),

        )

        drawContext.canvas.nativeCanvas.drawText("f", center.x + 25, center.y + 90, paint)
    }
}


@Preview(showBackground = false)
@Composable
fun MessengerIcon() {

    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {

        val colors = listOf(Color(0xFF02b8f9), Color(0xFF0277fe))

        val trianglePath = Path().let {
            it.moveTo(this.size.width * .20f, this.size.height * .77f)
            it.lineTo(this.size.width * .20f, this.size.height * 0.95f)
            it.lineTo(this.size.width * .37f, this.size.height * 0.86f)
            it.close()
            it
        }


        val electricPath = Path().let {
            it.moveTo(this.size.width * .20f, this.size.height * 0.60f)
            it.lineTo(this.size.width * .45f, this.size.height * 0.35f)
            it.lineTo(this.size.width * 0.56f, this.size.height * 0.46f)
            it.lineTo(this.size.width * 0.78f, this.size.height * 0.35f)
            it.lineTo(this.size.width * 0.54f, this.size.height * 0.60f)
            it.lineTo(this.size.width * 0.43f, this.size.height * 0.45f)
            it.close()
            it
        }

        drawOval(
            Brush.verticalGradient(colors = colors),
            size = Size(this.size.width, this.size.height * 0.95f)
        )


        drawPath(
            path = trianglePath,
            Brush.verticalGradient(colors = colors),
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )

        drawPath(path = electricPath, color = Color.White)
    }
}


@Preview(showBackground = false)
@Composable
fun GooglePhotosIcon() {

    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {

        drawArc(
            color = Color(0xFFf04231),
            size = Size(size.width * .50f, size.height * .50f),
            startAngle = -90f,
            sweepAngle = 180f,
            useCenter = true,
            topLeft = Offset(size.width * .25f, 0f)

        )

        drawArc(
            color = Color(0xFF4385f7),
            size = Size(size.width * .50f, size.height * .50f),
            startAngle = 0f,
            sweepAngle = 180f,
            useCenter = true,
            topLeft = Offset(size.width * .50f, size.height * .25f)

        )
        drawArc(
            color = Color(0xFF30a952),
            size = Size(size.width * .50f, size.height * .50f),
            startAngle = 0f,
            sweepAngle = -180f,
            useCenter = true,
            topLeft = Offset(0f, size.height * .25f)
        )

        drawArc(
            color = Color(0xFFffbf00),
            size = Size(size.width * .50f, size.height * .50f),
            startAngle = -90f,
            sweepAngle = -180f,
            useCenter = true,
            topLeft = Offset(size.width * .25f, size.height * .50f)

        )

    }
}



@Preview(showBackground = false)
@Composable
fun iOSWeatherAppIcon() {

    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {

        val backgroundColor = listOf(Color(0xFF2078EE), Color(0xFF74E6FE))
        val sunColor = listOf(Color(0xFFFFC200), Color(0xFFFFE100))

        val width = size.width
        val height = size.height

        val path = Path().apply {
            moveTo(width.times(.76f), height.times(.72f))
            cubicTo(
                width.times(.93f), height.times(.72f),
                width.times(.98f), height.times(.41f),
                width.times(.76f), height.times(.40f)
            )
            cubicTo(
                width.times(.75f), height.times(.21f),
                width.times(.35f), height.times(.21f),
                width.times(.38f), height.times(.50f)
            )
            cubicTo(
                width.times(.25f), height.times(.50f),
                width.times(.20f), height.times(.69f),
                width.times(.41f), height.times(.72f)
            )
            close()
        }

//        val guidePath = Path().let {
//            it.moveTo(width.times(.76f), height.times(.72f))
//            it.lineTo(width.times(.93f), height.times(.72f))
//            it.lineTo(width.times(.98f), height.times(.41f))
//            it.lineTo(width.times(.76f), height.times(.40f))
//
//            it.lineTo(width.times(.75f), height.times(.21f))
//            it.lineTo(width.times(.35f), height.times(.21f))
//            it.lineTo(width.times(.38f), height.times(.50f))
//
//            it.lineTo(width.times(.25f), height.times(.50f))
//            it.lineTo(width.times(.20f), height.times(.69f))
//            it.lineTo(width.times(.41f), height.times(.72f))
//
//            it.close()
//            it
//        }



        drawRoundRect(
            brush = Brush.verticalGradient(backgroundColor),
            cornerRadius = CornerRadius(50f, 50f),
        )

        drawCircle(
            brush = Brush.verticalGradient(sunColor),
            radius = width.times(.17f),
            center = Offset(width.times(.35f), height.times(.35f))
        )

        drawPath(path = path, color = Color.White.copy(alpha = .90f))

//        drawPath(
//            path = guidePath,
//            color = Color.Red,
//            style = Stroke(width = 1f, cap = StrokeCap.Round)
//        )
    }
}


@Composable
fun IconsForApps(){
    Column {
        FacebookIcon()
        InstagramIcon()
        iOSWeatherAppIcon()
        GooglePhotosIcon()
        MessengerIcon()
    }
}
