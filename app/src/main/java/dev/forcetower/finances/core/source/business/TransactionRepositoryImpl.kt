package dev.forcetower.finances.core.source.business

import dev.forcetower.finances.core.domain.repository.TransactionRepository
import dev.forcetower.finances.core.source.local.FinanceDB
import dev.forcetower.toolkit.domain.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TransactionRepositoryImpl @Inject constructor(
    private val database: FinanceDB
) : TransactionRepository {
    override fun getBalance(): Flow<Result<Float>> {
        return database.account.getBalance().map { Result.Success(it) }
    }

    override fun getIncomeOfInterval(
        start: LocalDateTime,
        end: LocalDateTime
    ): Flow<Result<Float>> {
        return database.transaction.getIncomeOfInterval(start, end)
            .map { transactions ->
                val income = transactions.map {
                    if (it.dateEnd == null || it.repeatRate == null) it.price
                    else {
                        val daysInInterval = ChronoUnit.DAYS.between(it.dateEnd, start)
                        val count = daysInInterval / it.repeatRate
                        it.price * count
                    }
                }.sum()
                Result.Success(income)
            }
    }

    override fun getPaymentOfInterval(
        start: LocalDateTime,
        end: LocalDateTime
    ): Flow<Result<Float>> {
        return database.transaction.getPaymentOfInterval(start, end)
            .map { transactions ->
                val income = transactions.map {
                    if (it.dateEnd == null || it.repeatRate == null) it.price
                    else {
                        val daysInInterval = ChronoUnit.DAYS.between(it.dateEnd, start)
                        val count = daysInInterval / it.repeatRate
                        it.price * count
                    }
                }.sum()
                Result.Success(income)
            }
    }
}