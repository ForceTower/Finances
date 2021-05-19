package dev.forcetower.finances.core.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import dev.forcetower.finances.core.model.database.Transaction
import dev.forcetower.toolkit.database.dao.BaseDao
import kotlinx.coroutines.flow.Flow

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
}