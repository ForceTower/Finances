package dev.forcetower.finances.view.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.forcetower.toolkit.lifecycle.Event
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
) : ViewModel() {
    private val _connected = MutableLiveData<Event<Unit>>()
    val connected: LiveData<Event<Unit>> = _connected
}