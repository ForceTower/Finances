package dev.forcetower.finances.core.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import dev.forcetower.finances.core.model.database.Transaction
import dev.forcetower.toolkit.database.dao.BaseDao
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

@Dao
abstract class TransactionDao : BaseDao<Transaction>() {
    @Query("SELECT * FROM `Transaction`")
    abstract fun getAll(): Flow<List<Transaction>>

    @Query("SELECT SUM(price) FROM `Transaction`")
    abstract fun getMovementValue(): Flow<Double>

    @Query("SELECT * FROM `Transaction` WHERE id = :id")
    abstract suspend fun requireTransactionById(id: Int): Transaction?

    override suspend fun getValueByIDDirect(value: Transaction): Transaction? {
        return requireTransactionById(value.id)
    }

    @Query("SELECT * FROM `Transaction` WHERE type > 0 AND date >= :start OR (dateEnd IS NOT NULL AND dateEnd <= :end)")
    abstract fun getIncomeOfInterval(start: LocalDateTime, end: LocalDateTime): Flow<List<Transaction>>

    @Query("SELECT * FROM `Transaction` WHERE type < 0 AND date >= :start OR (dateEnd IS NOT NULL AND dateEnd <= :end)")
    abstract fun getPaymentOfInterval(start: LocalDateTime, end: LocalDateTime): Flow<List<Transaction>>
}