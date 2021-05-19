package dev.forcetower.finances.core.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Account(
    @PrimaryKey
    val id: Int,
    val name: String,
    val type: Int,
    val balance: Double
)