package dev.forcetower.finances.core.domain.usecase.transaction

import dagger.Reusable
import dev.forcetower.finances.core.domain.repository.SettingsRepository
import dev.forcetower.finances.core.domain.repository.TransactionRepository
import dev.forcetower.toolkit.domain.FlowUseCase
import dev.forcetower.toolkit.domain.Result
import dev.forcetower.toolkit.domain.data
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.mapNotNull
import java.time.LocalDateTime
import javax.inject.Inject

@Reusable
class GetCurrentIntervalPaymentUseCase @Inject constructor(
    private val repository: TransactionRepository,
    private val settings: SettingsRepository
) : FlowUseCase<Unit, Float>() {
    @FlowPreview
    override fun execute(parameters: Unit): Flow<Result<Float>> {
        return settings.getDefaultTransactionInterval()
            .mapNotNull {
                it.data
            }.flatMapConcat {
                val now = LocalDateTime.now()
                val past = now.minusDays(it.toLong())
                repository.getPaymentOfInterval(now, past)
            }
    }
}