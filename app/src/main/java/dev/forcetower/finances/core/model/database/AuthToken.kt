package dev.forcetower.finances.core.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AuthToken(
    @PrimaryKey
    val token: String
)