package dev.forcetower.finances.core.domain.repository

import dev.forcetower.finances.core.model.database.User
import dev.forcetower.finances.core.model.domain.BasicLoginCredential
import dev.forcetower.finances.core.model.domain.CreateAccountData
import dev.forcetower.toolkit.domain.Result
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun createGuest()
    suspend fun login(credential: BasicLoginCredential)
    suspend fun createAccount(data: CreateAccountData)
    fun getSelectedUser(): Flow<Result<User>>
}