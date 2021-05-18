package dev.forcetower.finances.view.auth.register

import android.net.Uri
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.forcetower.finances.core.domain.usecase.auth.CreateAccountUseCase
import dev.forcetower.finances.core.model.domain.CreateAccountData
import dev.forcetower.toolkit.lifecycle.Event
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateAccountViewModel @Inject constructor(
    private val createAccount: CreateAccountUseCase
) : ViewModel(), CreateAccountActions {
    override val name = MutableLiveData("")
    override val email = MutableLiveData("")
    override val password = MutableLiveData("")
    override val repeatPassword = MutableLiveData("")
    private val _image = MutableLiveData<Uri?>(null)
    override val image: LiveData<Uri?> = _image

    private val _loading = MutableLiveData(false)
    override val loading = _loading

    private val _onBasicContinue = MutableLiveData<Event<Unit>>()
    val onBasicContinue: LiveData<Event<Unit>> = _onBasicContinue

    private val _onPasswordContinue = MutableLiveData<Event<Unit>>()
    val onPasswordContinue: LiveData<Event<Unit>> = _onPasswordContinue

    private val _onImageContinue = MutableLiveData<Event<Unit>>()
    val onImageContinue: LiveData<Event<Unit>> = _onImageContinue

    private val _onSelectPicture = MutableLiveData<Event<Unit>>()
    val onSelectPicture: LiveData<Event<Unit>> = _onSelectPicture

    private val _isBasicCompleted = combine(name.asFlow(), email.asFlow()) { n, e ->
        val nameValid = n.trim().length > 5
        val emailValid = e.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(e).matches()
        nameValid && emailValid
    }

    private val _isPasswordCompleted = combine(_isBasicCompleted, password.asFlow(), repeatPassword.asFlow()) { one, p1, p2 ->
        val password1Valid = p1.isNotBlank() && p1.length > 5
        val password2Valid = p2 == p1
        one && password1Valid && password2Valid
    }

    override val basicCompleted: LiveData<Boolean> = _isBasicCompleted.asLiveData()
    override val passwordCompleted: LiveData<Boolean> = _isPasswordCompleted.asLiveData()
    override val pictureSelected: LiveData<Boolean> = image.map { it != null }

    override fun onBasicContinue() {
        if (basicCompleted.value == true) {
            _onBasicContinue.value = Event(Unit)
        }
    }

    override fun onPasswordContinue() {
        if (passwordCompleted.value == true) {
            _onPasswordContinue.value = Event(Unit)
        }
    }

    override fun onImageContinue(withImage: Boolean) {
        if (!withImage) setUserRegisterImage(null)
        _onImageContinue.value = Event(Unit)
    }

    override fun onCreateAccount() {
        // wow! this name shadowing is fancy
        val name = name.value ?: return
        val email = email.value ?: return
        val password = password.value ?: return
        val image = image.value

        viewModelScope.launch {
            _loading.value = true
            createAccount(CreateAccountData(name, email, password, image))
            _loading.value = false
        }
    }

    override fun onPickImage() {
        _onSelectPicture.value = Event(Unit)
    }

    override fun onRemovePicture(): Boolean {
        setUserRegisterImage(null)
        return true
    }

    fun setUserRegisterImage(uri: Uri?) {
        _image.value = uri
    }
}