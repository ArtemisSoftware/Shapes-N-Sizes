package com.artemissoftware.shapesnsizes.ui.composables.animated

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = false)
@Composable
private fun LinePath(animationValue: Float = 1f) {

    Canvas(modifier = Modifier.size(200.dp, 200.dp)) {
        drawLine(
            color = Color.Black,
            start = Offset(0f, 0f),
            end = Offset(animationValue * size.width / 2f, animationValue * size.height / 2f),
            strokeWidth = 2f
        )

        drawLine(
            color = Color.Red,
            start = Offset(size.width / 2f, size.height / 2f),
            end = Offset((size.width / 2f) + animationValue * size.width , size.height/ 2f),
            strokeWidth = 2f
        )


    }

}


@Composable
private fun LineAnimation() {
    var animatable = remember { Animatable(0f) }

    LaunchedEffect(animatable) {
        animatable.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1000, easing = LinearEasing)
        )
    }

    LinePath(animatable.value)
}

@Composable
fun LineMovement(){

    Surface(color = MaterialTheme.colors.background) {

        LineAnimation()

    }

}