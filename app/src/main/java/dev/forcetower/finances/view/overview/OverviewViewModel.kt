package dev.forcetower.finances.view.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.forcetower.finances.core.domain.usecase.transaction.GetBalanceUseCase
import dev.forcetower.finances.core.domain.usecase.user.ConnectedUserUseCase
import dev.forcetower.finances.core.model.database.User
import dev.forcetower.toolkit.domain.data
import kotlinx.coroutines.flow.mapNotNull
import javax.inject.Inject

@HiltViewModel
class OverviewViewModel @Inject constructor(
    connectedUser: ConnectedUserUseCase,
    getBalance: GetBalanceUseCase
) : ViewModel(), OverviewActions {
    override val user: LiveData<User> = connectedUser(Unit).mapNotNull { it.data }.asLiveData()
}