package dev.forcetower.finances.core.domain.repository

import dev.forcetower.finances.core.model.domain.BasicLoginCredential
import dev.forcetower.finances.core.model.domain.CreateAccountData

interface UserRepository {
    suspend fun createGuest()
    suspend fun login(credential: BasicLoginCredential)
    suspend fun createAccount(data: CreateAccountData)
}