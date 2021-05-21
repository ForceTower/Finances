package dev.forcetower.finances.core.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(
    @PrimaryKey
    val id: Int,
    val name: String,
    val icon: String,
    val default: Boolean
)
