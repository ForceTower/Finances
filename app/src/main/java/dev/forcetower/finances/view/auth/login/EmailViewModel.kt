package dev.forcetower.finances.view.auth.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.forcetower.finances.R
import dev.forcetower.finances.core.domain.usecase.auth.BasicLoginUseCase
import dev.forcetower.finances.core.domain.usecase.auth.CreateGuestAccountUseCase
import dev.forcetower.finances.core.model.domain.BasicLoginCredential
import dev.forcetower.toolkit.lifecycle.Event
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmailViewModel @Inject constructor(
    private val createGuestAccount: CreateGuestAccountUseCase,
    private val basicLogin: BasicLoginUseCase
) : ViewModel(), EmailActions {
    override val email = MutableLiveData("")
    override val password = MutableLiveData("")
    private val _loading = MutableLiveData(false)
    override val loading: LiveData<Boolean> = _loading
    private val _emailError = MutableLiveData<Int?>(null)
    override val emailError: LiveData<Int?> = _emailError
    private val _passwordError = MutableLiveData<Int?>(null)
    override val passwordError: LiveData<Int?> = _passwordError
    private val _onCreateAccount = MutableLiveData<Event<Unit>>()
    val onCreateAccount: LiveData<Event<Unit>> = _onCreateAccount

    override fun onGuestLogin() {
        viewModelScope.launch {
            _loading.value = true
            createGuestAccount(Unit)
            _loading.value = false
        }
    }

    override fun onCreateAccount() {
        _onCreateAccount.value = Event(Unit)
    }

    override fun onEmailLogin() {
        if (_loading.value == true) return

        val email = email.value ?: return
        val password = password.value ?: return

        _emailError.value = null
        _passwordError.value = null

        var error = false
        if (!email.matches(Patterns.EMAIL_ADDRESS.toRegex())) {
            _emailError.value = R.string.auth_err_not_an_email
            error = true
        }

        if (password.length < 5) {
            _passwordError.value = R.string.auth_err_small_password
            error = true
        }

        if (error) return
        viewModelScope.launch {
            _loading.value = true
            basicLogin(BasicLoginCredential(email, password))
            _loading.value = false
        }
    }

    override fun onFacebookLogin() {

    }

    override fun onGoogleLogin() {

    }

}