package dev.forcetower.finances.core.source.business

import dev.forcetower.finances.core.domain.repository.SettingsRepository
import dev.forcetower.toolkit.domain.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingsRepositoryImpl @Inject constructor() : SettingsRepository {
    override fun getDefaultTransactionInterval(): Flow<Result<Int>> {
        return flow {
            emit(Result.Success(30))
        }
    }
}