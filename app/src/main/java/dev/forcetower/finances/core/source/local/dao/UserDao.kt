package dev.forcetower.finances.core.source.local.dao

import androidx.room.Dao
import dev.forcetower.finances.core.model.database.User
import dev.forcetower.toolkit.database.dao.BaseDao

@Dao
abstract class UserDao : BaseDao<User>()