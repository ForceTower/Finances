package dev.forcetower.finances.core.source.business

import dev.forcetower.finances.core.domain.repository.TransactionRepository
import dev.forcetower.finances.core.source.local.FinanceDB
import dev.forcetower.toolkit.domain.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TransactionRepositoryImpl @Inject constructor(
    private val database: FinanceDB
) : TransactionRepository {
    override fun getBalance(): Flow<Result<Double>> {
        return database.account.getBalance().map { Result.Success(it) }
    }
}