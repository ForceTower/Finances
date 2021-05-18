package dev.forcetower.finances.core.model.domain

import android.net.Uri

data class CreateAccountData(
    val name: String,
    val email: String,
    val password: String,
    val image: Uri?
)