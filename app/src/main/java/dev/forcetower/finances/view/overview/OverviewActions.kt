package dev.forcetower.finances.view.overview

import androidx.lifecycle.LiveData
import dev.forcetower.finances.core.model.database.User

interface OverviewActions {
    val user: LiveData<User>
    val balance: LiveData<Float>
    val income: LiveData<Float>
    val payment: LiveData<Float>
}