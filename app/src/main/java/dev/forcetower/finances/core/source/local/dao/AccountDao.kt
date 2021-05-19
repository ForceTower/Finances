package dev.forcetower.finances.core.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import dev.forcetower.finances.core.model.database.Account
import dev.forcetower.finances.core.model.database.Transaction
import dev.forcetower.toolkit.database.dao.BaseDao
import kotlinx.coroutines.flow.Flow

@Dao
abstract class AccountDao : BaseDao<Account>() {
    @Query("SELECT SUM(balance) FROM Account")
    abstract fun getBalance(): Flow<Double>

    @Query("SELECT * FROM `Account` WHERE id = :id")
    abstract suspend fun requireAccountById(id: Int): Account?

    override suspend fun getValueByIDDirect(value: Account): Account? {
        return requireAccountById(value.id)
    }
}