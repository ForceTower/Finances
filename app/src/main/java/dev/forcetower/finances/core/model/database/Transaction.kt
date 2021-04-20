package dev.forcetower.finances.core.model.database

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(indices = [
    Index("userId"),
    Index("categoryId"),
    Index("subcategoryId"),
    Index("accountId"),
])
data class Transaction(
    @PrimaryKey
    val id: Int,
    val title: String,
    val price: Float,
    val type: Int,
    val dateStart: LocalDateTime,
    val dateEnd: LocalDateTime?,
    val repeatRate: Int?,
    val description: String?,
    val userId: Int,
    val categoryId: Int,
    val subcategoryId: Int,
    val accountId: Int
)
