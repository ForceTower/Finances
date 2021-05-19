package dev.forcetower.finances.view.overview

import androidx.lifecycle.LiveData
import dev.forcetower.finances.core.model.database.User

interface OverviewActions {
    val user: LiveData<User>

}