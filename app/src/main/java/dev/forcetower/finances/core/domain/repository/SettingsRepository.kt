package dev.forcetower.finances.core.domain.repository

import dev.forcetower.toolkit.domain.Result
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun getDefaultTransactionInterval(): Flow<Result<Int>>
}