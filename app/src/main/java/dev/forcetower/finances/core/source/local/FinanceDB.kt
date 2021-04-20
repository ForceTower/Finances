package dev.forcetower.finances.core.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.forcetower.finances.core.model.database.Account
import dev.forcetower.finances.core.model.database.AuthToken
import dev.forcetower.finances.core.model.database.Category
import dev.forcetower.finances.core.model.database.Subcategory
import dev.forcetower.finances.core.model.database.Transaction
import dev.forcetower.finances.core.model.database.User
import dev.forcetower.finances.core.source.local.dao.AccountDao
import dev.forcetower.finances.core.source.local.dao.AuthTokenDao
import dev.forcetower.finances.core.source.local.dao.UserDao

@Database(entities = [
    AuthToken::class,
    User::class,
    Account::class,
    Transaction::class,
    Category::class,
    Subcategory::class
], version = 1)
@TypeConverters(value = [DateConverters::class])
abstract class FinanceDB : RoomDatabase() {
    abstract val auth: AuthTokenDao
    abstract val user: UserDao
    abstract val account: AccountDao
}