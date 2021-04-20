package dev.forcetower.finances.core.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey
    val id: Int,
    val name: String,
    val email: String,
    val picture: String?
)