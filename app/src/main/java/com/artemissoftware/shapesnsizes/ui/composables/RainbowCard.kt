package com.artemissoftware.shapesnsizes.ui.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.shapesnsizes.ui.theme.ShapesNSizesTheme
import androidx.compose.ui.geometry.Offset


private fun adjustOffset(size: Float): Offset {
    return Offset(size * .50f * -1, size * .50f * -1)
}

private val rainbowColors = listOf(
    Color(0xFFFF0000), Color(0xFFFF7F00), Color(0xFFFFFF00),
    Color(0xFF00FF00), Color(0xFF0000FF), Color(0xFF2E2B5F),
    Color(0xFF8B00FF)
)



@Composable
private fun OverlayArc(
    color: Color = Color.Red,
    size: Float = 100f,
    offset: (Float) -> Offset
) {

    Canvas(
        modifier = Modifier,
        onDraw = {
            drawArc(
                color = color,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = true,
                size = Size(size, size),
                topLeft = offset(size)
            )
        }
    )
}



@Composable
private fun OverlayCircle(size: Float) {
    Canvas(modifier = Modifier, onDraw = {

        for (index in rainbowColors.size downTo 1) {

            val diameter = index * size

            drawCircle(
                color = rainbowColors[index -1],
                radius = diameter / 2f,
                center = Offset(diameter.times(0f), diameter.times(0f))
            )
        }

    })
}






@Composable
private fun RainbowOverlay(size: Float){

    for (index in rainbowColors.size downTo 1) {
        OverlayArc(
            size = size * index,
            offset = ::adjustOffset,
            color = rainbowColors[index - 1]
        )
    }
}



@Composable
fun FancyCard(
    overlayAlignment: Alignment = Alignment.TopStart,
    overlay: @Composable() (() -> Unit?)? = null
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .clickable { },
        elevation = 10.dp
    ) {
        Box {


            if (overlay != null) {
                Box(Modifier.align(overlayAlignment)) {
                    overlay()
                }

            }

            Column(
                modifier = Modifier.padding(15.dp)
            ) {



                Text(
                    buildAnnotatedString {
                        append("welcome to ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.W900, color = Color(0xFF4552B8))
                        ) {
                            append("Jetpack Compose Playground")
                        }
                    }
                )
                Text(
                    buildAnnotatedString {
                        append("Now you are in the ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.W900)) {
                            append("Card")
                        }
                        append(" section")
                    }
                )
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    ShapesNSizesTheme {

        Column() {

            FancyCard(
                overlayAlignment = Alignment.TopEnd,
                overlay = {
                    OverlayCircle(size = 100f)
                })


            FancyCard(overlay = {
                OverlayArc(size = 100f, offset = ::adjustOffset)
            })

            FancyCard(overlay = {
                RainbowOverlay(100f)
            })

        }

    }
}