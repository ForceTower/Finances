package dev.forcetower.finances.view.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.forcetower.finances.core.domain.usecase.CreateGuestAccountUseCase
import dev.forcetower.finances.view.auth.email.EmailActions
import dev.forcetower.toolkit.lifecycle.Event
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val createGuestAccountUseCase: CreateGuestAccountUseCase
) : ViewModel(), EmailActions {
    private val _connected = MutableLiveData<Event<Unit>>()
    val connected: LiveData<Event<Unit>> = _connected

    override fun loginEmail() {

    }

    override fun loginGuest() {
        viewModelScope.launch {
            createGuestAccountUseCase(Unit)
            _connected.value = Event(Unit)
        }
    }
}