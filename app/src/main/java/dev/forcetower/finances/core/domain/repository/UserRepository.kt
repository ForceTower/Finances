package dev.forcetower.finances.core.domain.repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.forcetower.finances.R
import dev.forcetower.finances.core.model.database.User
import dev.forcetower.finances.core.source.local.FinanceDB
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val database: FinanceDB
) {
    suspend fun createGuest() {
        val user = User(
            1,
            context.getString(R.string.user_guest_account),
            "convidado@convidado.com",
            null
        )
        database.user.insert(user)
    }
}