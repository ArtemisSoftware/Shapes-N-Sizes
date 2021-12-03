package com.artemissoftware.shapesnsizes.ui.composables.graphs

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.shapesnsizes.ui.composables.graphs.models.TransactionRate
import com.artemissoftware.shapesnsizes.ui.composables.graphs.models.TransactionsPerSecond

data class TransactionPerSecondResponse(
    //@field:Json(name = "x")
    val timeStamp: Long,
    //@field:Json(name = "y")
    val transactionsPerSecondValue: Double
)
{
    companion object{

        fun getMock(): TransactionPerSecondResponse{

            return TransactionPerSecondResponse(
                timeStamp = 1442534400,
                transactionsPerSecondValue = 188330.0
            )
        }

        fun getMock2(): TransactionPerSecondResponse{

            return TransactionPerSecondResponse(
                timeStamp = 1442534400,
                transactionsPerSecondValue = 128330.0
            )
        }

        fun getMock3(): TransactionPerSecondResponse{

            return TransactionPerSecondResponse(
                timeStamp = 1442534400,
                transactionsPerSecondValue = 88330.0
            )
        }
    }
}

val transactionsRemote: List<TransactionPerSecondResponse> = listOf(
    TransactionPerSecondResponse.getMock(),
    TransactionPerSecondResponse.getMock2(),
    TransactionPerSecondResponse.getMock3()
)

val transactionRate = TransactionRate(
timeStamp = TransactionPerSecondResponse.getMock().timeStamp,
transactionsPerSecondValue = TransactionPerSecondResponse.getMock().transactionsPerSecondValue
)
val transactionRate2 = TransactionRate(
    timeStamp = TransactionPerSecondResponse.getMock().timeStamp,
    transactionsPerSecondValue = TransactionPerSecondResponse.getMock2().transactionsPerSecondValue
)
val transactionRate3 = TransactionRate(
    timeStamp = TransactionPerSecondResponse.getMock().timeStamp,
    transactionsPerSecondValue = TransactionPerSecondResponse.getMock3().transactionsPerSecondValue
)

val uiTransactions = listOf(transactionRate, transactionRate2, transactionRate3)


val transactionsPerSecond = TransactionsPerSecond(188330.0, uiTransactions)



@Composable
fun LinearTransactionsChart(
    modifier: Modifier = Modifier,
    transactionsPerSecond: TransactionsPerSecond
) {
    if (transactionsPerSecond.transactions.isEmpty()) return

    Canvas(modifier = modifier) {
        // Total number of transactions.
        val totalRecords = transactionsPerSecond.transactions.size

        // Maximum distance between dots (transactions)
        val lineDistance = size.width / (totalRecords + 1)

        // Canvas height
        val cHeight = size.height

        // Add some kind of a "Padding" for the initial point where the line starts.
        var currentLineDistance = 0F + lineDistance

        transactionsPerSecond.transactions.forEachIndexed { index, transactionRate ->
            if (totalRecords >= index + 2) {
                drawLine(
                    start = Offset(
                        x = currentLineDistance,
                        y = calculateYCoordinate(
                            higherTransactionRateValue = transactionsPerSecond.maxTransaction,
                            currentTransactionRate = transactionRate.transactionsPerSecondValue,
                            canvasHeight = cHeight
                        )
                    ),
                    end = Offset(
                        x = currentLineDistance + lineDistance,
                        y = calculateYCoordinate(
                            higherTransactionRateValue = transactionsPerSecond.maxTransaction,
                            currentTransactionRate = transactionsPerSecond.transactions[index + 1].transactionsPerSecondValue,
                            canvasHeight = cHeight
                        )
                    ),
                    color = Color(40, 193, 218),
                    strokeWidth = Stroke.DefaultMiter
                )
            }
            currentLineDistance += lineDistance
        }
    }
}



@Composable
fun TransactionsPerSecondComposable(
    transactionsPerSecond: TransactionsPerSecond,
) {
    Card(
        shape = RoundedCornerShape(4.dp),
        elevation = 12.dp,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = "Transactions Per Second",
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )
            LinearTransactionsChart(
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
                    .padding(12.dp),
                transactionsPerSecond = transactionsPerSecond
            )
        }
    }
}



/**
 * Calculates the Y pixel coordinate for a given transaction rate.
 *
 * @param higherTransactionRateValue the highest rate value in the whole list of transactions.
 * @param currentTransactionRate the current transaction RATE while iterating the list of transactions.
 * @param canvasHeight the canvas HEIGHT for draw the linear chart.
 *
 * @return [Float] Y coordinate for a transaction rate.
 */
private fun calculateYCoordinate(
    higherTransactionRateValue: Double,
    currentTransactionRate: Double,
    canvasHeight: Float
): Float {
    val maxAndCurrentValueDifference = (higherTransactionRateValue - currentTransactionRate)
        .toFloat()
    val relativePercentageOfScreen = (canvasHeight / higherTransactionRateValue)
        .toFloat()
    return maxAndCurrentValueDifference * relativePercentageOfScreen
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    TransactionsPerSecondComposable(transactionsPerSecond = transactionsPerSecond)
}