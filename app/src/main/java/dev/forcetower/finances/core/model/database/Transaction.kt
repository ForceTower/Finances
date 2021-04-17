package dev.forcetower.finances.core.model.database

data class Transaction(
    val id: Int,
    val title: String,
    val description: String?,
    val price: Float,
    val category: Int,
    val type: Int
)
