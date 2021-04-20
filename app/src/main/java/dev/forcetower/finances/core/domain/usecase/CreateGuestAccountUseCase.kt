package dev.forcetower.finances.core.domain.usecase

import dagger.Reusable
import dev.forcetower.finances.core.domain.repository.UserRepository
import dev.forcetower.toolkit.domain.UseCase
import javax.inject.Inject

@Reusable
class CreateGuestAccountUseCase @Inject constructor(
    private val repository: UserRepository
) : UseCase<Unit, Unit>() {
    override suspend fun execute(parameters: Unit) {
        return repository.createGuest()
    }
}