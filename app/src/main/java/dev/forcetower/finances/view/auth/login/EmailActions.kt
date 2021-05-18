package dev.forcetower.finances.view.auth.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface EmailActions {
    val loading: LiveData<Boolean>
    val email: MutableLiveData<String>
    val password: MutableLiveData<String>
    val emailError: LiveData<Int?>
    val passwordError: LiveData<Int?>
    fun onGuestLogin()
    fun onCreateAccount()
    fun onEmailLogin()
    fun onFacebookLogin()
    fun onGoogleLogin()
}