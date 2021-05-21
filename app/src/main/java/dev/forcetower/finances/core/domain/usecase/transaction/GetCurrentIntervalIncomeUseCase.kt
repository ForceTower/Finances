package dev.forcetower.finances.core.domain.usecase.transaction

import dagger.Reusable
import dev.forcetower.finances.core.domain.repository.SettingsRepository
import dev.forcetower.finances.core.domain.repository.TransactionRepository
import dev.forcetower.toolkit.domain.FlowUseCase
import dev.forcetower.toolkit.domain.Result
import dev.forcetower.toolkit.domain.data
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.flatMap
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.transform
import java.time.LocalDate
import java.time.LocalDateTime
import javax.inject.Inject

@Reusable
class GetCurrentIntervalIncomeUseCase @Inject constructor(
    private val repository: TransactionRepository,
    private val settings: SettingsRepository
) : FlowUseCase<Unit, Float>() {
    @FlowPreview
    override fun execute(parameters: Unit): Flow<Result<Float>> {
        return settings.getDefaultTransactionInterval()
            .mapNotNull {
                it.data
            }.flatMapConcat {
                val today = LocalDate.now().atStartOfDay()
                val past = today.minusDays(it.toLong())
                repository.getIncomeOfInterval(today, past)
            }
    }
}