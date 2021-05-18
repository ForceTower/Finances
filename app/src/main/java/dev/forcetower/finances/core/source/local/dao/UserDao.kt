package dev.forcetower.finances.core.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import dev.forcetower.finances.core.model.database.User
import dev.forcetower.toolkit.database.dao.BaseDao
import kotlinx.coroutines.flow.Flow

@Dao
abstract class UserDao : BaseDao<User>() {
    @Query("SELECT * FROM User LIMIT 1")
    abstract fun selectCurrent(): Flow<User>

    @Query("SELECT * FROM User LIMIT 1")
    abstract suspend fun requireCurrent(): User?
}