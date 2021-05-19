package dev.forcetower.finances.core.domain.repository

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun getDefaultTransactionInterval(): Flow<Result<Int>>
}