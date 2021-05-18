package dev.forcetower.finances.view.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.forcetower.finances.core.domain.usecase.user.ConnectedUserUseCase
import dev.forcetower.toolkit.domain.successOr
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    userConnected: ConnectedUserUseCase
) : ViewModel() {
    val connected: LiveData<Boolean> = userConnected(Unit).map {
        it.successOr(null) != null
    }.distinctUntilChanged().asLiveData()
}