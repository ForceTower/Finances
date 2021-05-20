package dev.forcetower.finances.core.domain.repository

import kotlinx.coroutines.flow.Flow
import dev.forcetower.toolkit.domain.Result
import java.time.LocalDateTime

interface TransactionRepository {
    fun getBalance(): Flow<Result<Float>>
    fun getIncomeOfInterval(start: LocalDateTime, end: LocalDateTime): Flow<Result<Float>>
    fun getPaymentOfInterval(start: LocalDateTime, end: LocalDateTime): Flow<Result<Float>>
}