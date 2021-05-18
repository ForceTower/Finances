package dev.forcetower.finances.core.domain.usecase.auth

import dagger.Reusable
import dev.forcetower.finances.core.domain.repository.UserRepository
import dev.forcetower.finances.core.model.domain.CreateAccountData
import dev.forcetower.toolkit.domain.UseCase
import javax.inject.Inject

@Reusable
class CreateAccountUseCase @Inject constructor(
    private val repository: UserRepository
): UseCase<CreateAccountData, Unit>() {
    override suspend fun execute(parameters: CreateAccountData) {
        repository.createAccount(parameters)
    }
}