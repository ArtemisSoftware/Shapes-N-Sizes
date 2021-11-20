package com.artemissoftware.shapesnsizes.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Greeting() {
    Text(
        text = "Lets test shapes and sizes",
        style = MaterialTheme.typography.h3.copy(color = Color.Blue),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
            .border(width = 4.dp, color = Color.Blue, CutCornerShape(32.dp))
            .graphicsLayer {
                shadowElevation = 8.dp.toPx()
                shape = CutCornerShape(32.dp)
                clip = true
            }
            .background(color = Color.Green)
            .padding(32.dp)

    )
}


@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    Greeting()
}