package com.artemissoftware.shapesnsizes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.shapesnsizes.ui.composables.animated.LineMovement
import com.artemissoftware.shapesnsizes.ui.composables.graphs.LineChart
import com.artemissoftware.shapesnsizes.ui.theme.ShapesNSizesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShapesNSizesTheme {
                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
//                    Hourglass()
//
//                    //IconsForApps()
//
//                }

                //HourglassAnimation()

                //LineMovement()
                LineChart()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ShapesNSizesTheme {

        Column() {


        }


    }
}

