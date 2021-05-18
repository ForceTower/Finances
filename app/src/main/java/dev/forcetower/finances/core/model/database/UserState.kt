package dev.forcetower.finances.core.model.database

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [
    ForeignKey(entity = User::class, parentColumns = ["id"], childColumns = ["id"], onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE)
])
data class UserState(
    @PrimaryKey
    val id: Int,
    val needsRegistration: Boolean
)
