package com.artemissoftware.shapesnsizes.ui.composables.graphs.models

/**
 * Represents a group of Transactions
 * @param maxTransaction the max transaction value in the list of transactions previously calculated in some repository.
 * @param transactions list of transactions per second.
 */
data class TransactionsPerSecond(
    val maxTransaction: Double,
    val transactions: List<TransactionRate>
)

/**
 * Represents a transaction rate.
 * @param timeStamp the time stamp of the transaction.
 * @param transactionsPerSecondValue the quantity of transactions made per second.
 */
data class TransactionRate(
    val timeStamp: Long,
    val transactionsPerSecondValue: Double
)