package dev.forcetower.finances.core.source.local.dao

import androidx.room.Dao
import dev.forcetower.finances.core.model.database.Account
import dev.forcetower.toolkit.database.dao.BaseDao

@Dao
abstract class AccountDao : BaseDao<Account>() {
}