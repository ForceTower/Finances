package dev.forcetower.finances.core.domain.usecase.transaction

import dagger.Reusable
import dev.forcetower.finances.core.domain.repository.TransactionRepository
import dev.forcetower.toolkit.domain.UseCase
import javax.inject.Inject

@Reusable
class CreateTransactionUseCase @Inject constructor(
    private val repository: TransactionRepository
) : UseCase<Unit, Unit>() {
    override suspend fun execute(parameters: Unit) {

    }
}