package com.artemissoftware.shapesnsizes.ui.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.shapesnsizes.ui.theme.ShapesNSizesTheme
import android.util.TypedValue
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke


@Preview(showBackground = false)
@Composable
fun Circle_V2(modifier : Modifier =  Modifier
    //.size(100.dp)
    ){
      val instaColors = listOf(Color.Yellow, Color.Red, Color.Magenta)
              Canvas(
              modifier = modifier
              ) {

          drawCircle(
              brush = Brush.linearGradient(colors = instaColors),
              radius = 13f,
              center = Offset(this.size.width * .80f, this.size.height * 0.20f),
          )
      }
}

@Composable
fun Circle_V3(modifier: Modifier,
              size: Float,
              color: Color) {
    Canvas(modifier = modifier, onDraw = {

        drawCircle(
            color = color,
            radius = size / 2f,
            //center = Offset(width.times(.0f), height.times(.0f))
        )

//        drawCircle(
//            color = Color.Blue,
//            radius = width / 2f,
//            center = Offset(width.times(.75f), height.times(.75f))
//        )
    })
}



@Composable
private fun Overlay(
    modifier: Modifier,
    size: Float,
    color: Color
) {

    Canvas(
        modifier = modifier,
        onDraw = {
            drawArc(
                color = color,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = true,
                size = Size(size, size)
            )
        }
    )
}
@Preview(showBackground = false)
@Composable
private fun Overlay_v2(
    size: Float = 100f,
) {

    Canvas(
        modifier = Modifier
            ,
        onDraw = {
            drawArc(
                color = Color.Red,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = true,
                size = Size(size, size),
                topLeft = Offset(size * .50f * -1, size * .50f * -1)
            )
        }
    )
}

@Composable
fun FancyCard(
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
                overlay()
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

            FancyCard(overlay = {
                Overlay(
                    color = Color.Blue,
                    size = 100f,
                    modifier = Modifier
                    //.padding(20.dp)
                    //.offset(x = (-20).dp, y = (-10).dp)
                )
            })
            FancyCard(overlay = {
                Circle_V3(
                    color = Color.Blue,
                    size = 400f,
                    modifier = Modifier
                    //.padding(20.dp)
                    //.offset(x = (-40).dp, y = (-50.dp))

                )
            })


            FancyCard(overlay = {
                Overlay_v2()
            })
//            FancyCard(overlay = {
//
//                Circle_V2(modifier =  Modifier.fillMaxSize())
//
//            })
//            Circle_V3(
//                color = Color.Red,
//                size = 100f,
//                modifier = Modifier
//                //.padding(20.dp)
//                //.offset(x = (-40).dp, y = (-50.dp))
//
//            )
        }

    }
}