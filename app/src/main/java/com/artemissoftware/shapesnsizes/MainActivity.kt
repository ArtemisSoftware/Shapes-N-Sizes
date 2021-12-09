package com.artemissoftware.shapesnsizes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.shapesnsizes.ui.composables.ShimmerCard
import com.artemissoftware.shapesnsizes.ui.composables.animated.LineMovement
import com.artemissoftware.shapesnsizes.ui.composables.graphs.LineChart
import com.artemissoftware.shapesnsizes.ui.composables.graphs.models.DataPoints
import com.artemissoftware.shapesnsizes.ui.composables.graphs.models.LineGraph4
import com.artemissoftware.shapesnsizes.ui.composables.graphs.neochart.NeoLineCard
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
                //LineChart()
                //LineGraph4(listOf(DataPoints.dataPoints1, DataPoints.dataPoints2), Modifier)
//                NeoLineCard(
//                    modifier = Modifier,
//                    lines = listOf(DataPoints.dataPoints2, DataPoints.dataPoints2),
//                    showGraphXAxis = true, showGraphYAxis = true
//                )

                ShimmerCard()
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

