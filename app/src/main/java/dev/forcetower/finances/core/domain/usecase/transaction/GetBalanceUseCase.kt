package dev.forcetower.finances.core.domain.usecase.transaction

import dagger.Reusable
import dev.forcetower.finances.core.domain.repository.TransactionRepository
import dev.forcetower.toolkit.domain.FlowUseCase
import dev.forcetower.toolkit.domain.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@Reusable
class GetBalanceUseCase @Inject constructor(
    private val repository: TransactionRepository
) : FlowUseCase<Unit, Double>() {
    override fun execute(parameters: Unit): Flow<Result<Double>> {
        return repository.getBalance()
    }
}