package dev.forcetower.finances.core.model.database

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [
    Index("categoryId")
])
data class Subcategory(
    @PrimaryKey
    val id: Int,
    val name: String,
    val icon: String,
    val categoryId: Int
)
