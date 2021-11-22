package com.artemissoftware.shapesnsizes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.shapesnsizes.ui.composables.OverlayCircle
import com.artemissoftware.shapesnsizes.ui.composables.FancyCard
import com.artemissoftware.shapesnsizes.ui.theme.ShapesNSizesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShapesNSizesTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
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


@Composable
fun Circle_V2(modifier: Modifier,
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



@Preview
@Composable
fun CardDemo() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .clickable { },
        elevation = 10.dp
    ) {
        Box {

            Overlay(
                color = Color.Blue,
                size = 400f,
                modifier = Modifier
                //.padding(20.dp)
                //.offset(x = (-40).dp, y = (-50.dp))
            )
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





@Composable
@Preview
fun Circle(modifier: Modifier = Modifier.size(100.dp)) {
    Canvas(modifier = modifier, onDraw = {


        val width = size.width
        val height = size.height


        drawCircle(
            color = Color.Red,
            radius = width / 2f,
            //center = Offset(width.times(.0f), height.times(.0f))
        )

//        drawCircle(
//            color = Color.Blue,
//            radius = width / 2f,
//            center = Offset(width.times(.75f), height.times(.75f))
//        )
    })
}



@Preview
@Composable
fun CardDemo_V2() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .clickable { },
        elevation = 10.dp
    ) {
        Box {

            Circle_V2(
                color = Color.Blue,
                size = 400f,
                modifier = Modifier
                //.padding(20.dp)
                //.offset(x = (-40).dp, y = (-50.dp))
            )

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






@Composable
private fun Overlay(
    color: List<Color>
) {
    Overlay(
        color = color[0],
        size = 800f,
        modifier = Modifier
            .padding(20.dp)
            .size(70.dp)
            .offset(x = (-100).dp, y = (-100).dp)
    )

    Overlay(
        color = color[1],
        size = 600f,
        modifier = Modifier
            .padding(20.dp)
            .size(70.dp)
            .offset(x = (-80).dp, y = (-80).dp)
    )

    Overlay(
        color = color[2],
        size = 400f,
        modifier = Modifier
            .padding(20.dp)
            .size(70.dp)
            .offset(x = (-60).dp, y = (-50).dp)
    )
}





@Preview
@Composable
fun OVerlay_TEST() {
    Box(Modifier.height(400.dp).width(400.dp)) {
        Overlay(
            color = Color.Blue,
            size = 400f,
            modifier = Modifier
                //.padding(20.dp)
                //.offset(x = (-40).dp, y = (-50.dp))
        )
    }

}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ShapesNSizesTheme {

        Column() {

            CardDemo()
            CardDemo_V2()



        }


        //Overlay(listOf(Color.Blue, Color.Yellow, Color.Magenta))

//        Overlay(
//            color = Color.Blue,
//            size = 100f,
//            modifier = Modifier.padding(20.dp)
//        )

        //Circle(modifier = Modifier.size(100.dp).offset(50.dp, 50.dp))

//        Overlay(
//            color = Color.Red,
//            size = 400f,
//            modifier = Modifier.padding(20.dp).size(70.dp).offset(x = (-60).dp, y = (-50).dp)
//        )



    }
}