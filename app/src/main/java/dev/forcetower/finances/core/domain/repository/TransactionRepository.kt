package dev.forcetower.finances.core.domain.repository

import kotlinx.coroutines.flow.Flow
import dev.forcetower.toolkit.domain.Result

interface TransactionRepository {
    fun getBalance(): Flow<Result<Double>>
}