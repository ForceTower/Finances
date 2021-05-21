package dev.forcetower.finances.view.transaction.create

import androidx.lifecycle.MutableLiveData
import dev.forcetower.finances.core.model.database.Account
import dev.forcetower.finances.core.model.database.Category
import dev.forcetower.finances.core.model.database.Subcategory
import java.time.LocalDateTime

interface CreateTransactionActions {
    val value: MutableLiveData<String>
    val name: MutableLiveData<String>
    val date: MutableLiveData<LocalDateTime>
    val category: MutableLiveData<Category>
    val subcategory: MutableLiveData<Subcategory>
    val account: MutableLiveData<Account>
}