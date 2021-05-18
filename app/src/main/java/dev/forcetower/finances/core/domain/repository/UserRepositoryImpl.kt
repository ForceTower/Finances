package dev.forcetower.finances.core.domain.repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.forcetower.finances.R
import dev.forcetower.finances.core.model.database.User
import dev.forcetower.finances.core.model.domain.BasicLoginCredential
import dev.forcetower.finances.core.model.domain.CreateAccountData
import dev.forcetower.finances.core.source.local.FinanceDB
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val database: FinanceDB
) : UserRepository {
    override suspend fun createGuest() {
        val user = User(
            1,
            context.getString(R.string.user_guest_account),
            "convidado@convidado.com",
            null
        )
        database.user.insert(user)
    }

    override suspend fun login(credential: BasicLoginCredential) {

    }

    override suspend fun createAccount(data: CreateAccountData) {

    }
}