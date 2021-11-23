package com.artemissoftware.shapesnsizes.ui.composables.animated

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = false)
@Composable
fun CircleAnimated() {

    val radius = 200f
    val animateFloat = remember { Animatable(0f) }
    LaunchedEffect(animateFloat) {
        animateFloat.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 3000, easing = LinearEasing))
    }

    Canvas(modifier = Modifier.size(200.dp)){
        drawArc(
            color = Color.Black,
            startAngle = 0f,
            sweepAngle = 360f * animateFloat.value,
            useCenter = false,
            topLeft = Offset(size.width / 4, size.height / 4),
            size = Size(radius * 2 ,
                radius * 2),
            style = Stroke(2.0f)
        )
    }

}