package dev.forcetower.finances.core.domain.usecase.user

import dev.forcetower.finances.core.domain.repository.UserRepository
import dev.forcetower.finances.core.model.database.User
import dev.forcetower.toolkit.domain.FlowUseCase
import dev.forcetower.toolkit.domain.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ConnectedUserUseCase @Inject constructor(
    private val repository: UserRepository
) : FlowUseCase<Unit, User?>(){
    override fun execute(parameters: Unit): Flow<Result<User?>> {
        return repository.getSelectedUser()
    }
}