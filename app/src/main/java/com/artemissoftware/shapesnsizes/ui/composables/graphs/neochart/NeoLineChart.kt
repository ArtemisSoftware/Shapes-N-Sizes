package com.artemissoftware.shapesnsizes.ui.composables.graphs.neochart

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.artemissoftware.shapesnsizes.ui.composables.graphs.models.DataPoint
import com.artemissoftware.shapesnsizes.ui.composables.graphs.models.DataPoints
import com.artemissoftware.shapesnsizes.ui.composables.graphs.models.LinePlot
import com.artemissoftware.shapesnsizes.ui.composables.graphs.models.toPx


@Composable
fun NeoLineCard(
    modifier: Modifier,
    lines: List<List<DataPoint>>,
    showGraphXAxis: Boolean = true,
    showGraphYAxis: Boolean = true,
) {

    val totalWidth = remember { mutableStateOf(0) }

    Card(
        shape = RoundedCornerShape(4.dp),
        elevation = 12.dp,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
    ) {

        Column {

            Text(
                text = "Neo Line Chart",
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )


            Column(Modifier.onGloballyPositioned {
                totalWidth.value = it.size.width
            }) {

                NeoLineChart(
                    modifier = modifier,
                    lines = lines,
                    showGraphXAxis = showGraphXAxis,
                    showGraphYAxis = showGraphYAxis
                )

            }
        }
    }


}


@Composable
internal fun NeoLineChart(
    lines: List<List<DataPoint>>,
    showGraphXAxis: Boolean = true,
    showGraphYAxis: Boolean = true,
    modifier: Modifier) {

    val totalWidth = remember { mutableStateOf(0) }


    Column(Modifier.onGloballyPositioned {
        totalWidth.value = it.size.width
    }) {


        val xOffset = remember { mutableStateOf(0f) }
        val cardWidth = remember { mutableStateOf(0) }
        val visibility = remember { mutableStateOf(false) }
        val points = remember { mutableStateOf(listOf<DataPoint>()) }
        val density = LocalDensity.current

        val padding = 16.dp

        MaterialTheme(colors = MaterialTheme.colors.copy(surface = Color.White)) {
            NeoLineGraph(
                plot = LinePlot(
                    listOf(
                        LinePlot.Line(
                            lines[1],
                            LinePlot.Connection(Color.Gray, 2.dp),
                            null,
                            LinePlot.Highlight { center ->
                                val color = Color.Gray
                                drawCircle(color, 9.dp.toPx(), center, alpha = 0.3f)
                                drawCircle(color, 6.dp.toPx(), center)
                                drawCircle(Color.White, 3.dp.toPx(), center)
                            },
                        ),
                        LinePlot.Line(
                            lines[0],
                            LinePlot.Connection(),
                            LinePlot.Intersection(),
                            LinePlot.Highlight { center ->
                                val color = Color.Blue
                                drawCircle(color, 9.dp.toPx(), center, alpha = 0.3f)
                                drawCircle(color, 6.dp.toPx(), center)
                                drawCircle(Color.White, 3.dp.toPx(), center)
                            },
                            LinePlot.AreaUnderLine()
                        ),
                    ),
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = padding),
                onSelectionStart = { visibility.value = true },
                onSelectionEnd = { visibility.value = false },
                showGraphXAxis = showGraphXAxis,
                showGraphYAxis = showGraphYAxis,
            ) { x, pts ->
                val cWidth = cardWidth.value.toFloat()
                var xCenter = x + padding.toPx(density)
                xCenter = when {
                    xCenter + cWidth / 2f > totalWidth.value -> totalWidth.value - cWidth
                    xCenter - cWidth / 2f < 0f -> 0f
                    else -> xCenter - cWidth / 2f
                }
                xOffset.value = xCenter
                points.value = pts
            }
        }

    }
}




@Composable
internal fun NeoLineChart_Revolution(
    plot: LinePlot,
    backgroundColor: Color = MaterialTheme.colors.surface,
    chartHeight: Dp = 200.dp,
    showGraphXAxis: Boolean = true,
    showGraphYAxis: Boolean = true,
    modifier: Modifier) {

    val totalWidth = remember { mutableStateOf(0) }


    Column(Modifier.onGloballyPositioned {
        totalWidth.value = it.size.width
    }) {


        val xOffset = remember { mutableStateOf(0f) }
        val cardWidth = remember { mutableStateOf(0) }
        val visibility = remember { mutableStateOf(false) }
        val points = remember { mutableStateOf(listOf<DataPoint>()) }
        val density = LocalDensity.current

        val padding = 16.dp

        MaterialTheme(colors = MaterialTheme.colors.copy(surface = Color.White)) {
            NeoLineGraph(
                plot = plot,
                modifier = modifier
                    .fillMaxWidth()
                    .height(chartHeight)
                    .padding(horizontal = padding),
                onSelectionStart = { visibility.value = true },
                onSelectionEnd = { visibility.value = false },
                showGraphXAxis = showGraphXAxis,
                showGraphYAxis = showGraphYAxis,
                backgroundColor = backgroundColor,
            ) { x, pts ->
                val cWidth = cardWidth.value.toFloat()
                var xCenter = x + padding.toPx(density)
                xCenter = when {
                    xCenter + cWidth / 2f > totalWidth.value -> totalWidth.value - cWidth
                    xCenter - cWidth / 2f < 0f -> 0f
                    else -> xCenter - cWidth / 2f
                }
                xOffset.value = xCenter
                points.value = pts
            }
        }

    }
}







@Preview(showBackground = true)
@Composable
private fun Preview() {

    Column() {
//        NeoLineCard(
//            modifier = Modifier,
//            lines = listOf(DataPoints.dataPoints2, DataPoints.dataPoints2),
//            showGraphXAxis = true, showGraphYAxis = false
//        )
//        Spacer(Modifier.height(4.dp))

//        NeoLineCard(
//            modifier = Modifier,
//            lines = listOf(DataPoints.dataPoints2, DataPoints.dataPoints2),
//            showGraphXAxis = false, showGraphYAxis = true
//        )
//        Spacer(Modifier.height(4.dp))

//        NeoLineCard(
//            modifier = Modifier,
//            lines = listOf(DataPoints.dataPoints2, DataPoints.dataPoints2),
//            showGraphXAxis = false, showGraphYAxis = false
//        )
//        Spacer(Modifier.height(4.dp))




        val plot = LinePlot(
            listOf(
//                LinePlot.Line(
//                    lines[1],
//                    LinePlot.Connection(Color.Gray, 2.dp),
//                    null,
//                    LinePlot.Highlight { center ->
//                        val color = Color.Gray
//                        drawCircle(color, 9.dp.toPx(), center, alpha = 0.3f)
//                        drawCircle(color, 6.dp.toPx(), center)
//                        drawCircle(Color.White, 3.dp.toPx(), center)
//                    },
//                ),
                LinePlot.Line(
                    DataPoints.dataPoints3,
                    LinePlot.Connection(Color.Green, 2.dp),
                    null,
                    LinePlot.Highlight { center ->
                        val color = Color.Blue
                        drawCircle(color, 9.dp.toPx(), center, alpha = 0.3f)
                        drawCircle(color, 6.dp.toPx(), center)
                        drawCircle(Color.White, 3.dp.toPx(), center)
                    },
                    LinePlot.AreaUnderLine(gradientColors = listOf(Color.Blue, Color.White))
                ),
            ),
        )


        val plot_2 = LinePlot(
            listOf(
//                LinePlot.Line(
//                    lines[1],
//                    LinePlot.Connection(Color.Gray, 2.dp),
//                    null,
//                    LinePlot.Highlight { center ->
//                        val color = Color.Gray
//                        drawCircle(color, 9.dp.toPx(), center, alpha = 0.3f)
//                        drawCircle(color, 6.dp.toPx(), center)
//                        drawCircle(Color.White, 3.dp.toPx(), center)
//                    },
//                ),
                LinePlot.Line(
                    DataPoints.dataPoints7,
                    LinePlot.Connection(Color.Green, 2.dp),
                    LinePlot.Intersection(onlyLastPoint = false, radius = 3.dp, color = Color.Red),
                    null,
                    LinePlot.AreaUnderLine(alpha = 1f, gradientColors = listOf(Color.Blue, Color.Transparent))
                ),
            ),
        )




        NeoLineChart_Revolution(
            modifier = Modifier,
            plot = plot,
            chartHeight = 100.dp,
            showGraphXAxis = false,
            showGraphYAxis = false
        )
        Spacer(Modifier.height(16.dp))


        NeoLineChart_Revolution(
            modifier = Modifier,
            plot = plot_2,
            chartHeight = 200.dp,
            showGraphXAxis = true,
            showGraphYAxis = true,
            backgroundColor = Color.LightGray
        )
        Spacer(Modifier.height(4.dp))


//        NeoLineCard(
//            modifier = Modifier,
//            lines = listOf(DataPoints.dataPoints2, DataPoints.dataPoints2),
//            showGraphXAxis = true, showGraphYAxis = true
//        )
    }

}