package dev.forcetower.finances.view.auth.register

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface CreateAccountActions {
    val name: MutableLiveData<String>
    val email: MutableLiveData<String>
    val password: MutableLiveData<String>
    val repeatPassword: MutableLiveData<String>
    val image: LiveData<Uri?>
    val loading: LiveData<Boolean>
    val basicCompleted: LiveData<Boolean>
    val passwordCompleted: LiveData<Boolean>
    val pictureSelected: LiveData<Boolean>

    fun onBasicContinue()
    fun onPasswordContinue()
    fun onImageContinue(withImage: Boolean)
    fun onCreateAccount()
    fun onPickImage()
    fun onRemovePicture(): Boolean
}