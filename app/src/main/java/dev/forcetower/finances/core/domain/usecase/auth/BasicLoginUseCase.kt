package dev.forcetower.finances.core.domain.usecase.auth

import dagger.Reusable
import dev.forcetower.finances.core.domain.repository.UserRepository
import dev.forcetower.finances.core.model.domain.BasicLoginCredential
import dev.forcetower.toolkit.domain.UseCase
import javax.inject.Inject

@Reusable
class BasicLoginUseCase @Inject constructor(
    private val repository: UserRepository
) : UseCase<BasicLoginCredential, Unit>() {
    override suspend fun execute(parameters: BasicLoginCredential) {
        repository.login(parameters)
    }
}