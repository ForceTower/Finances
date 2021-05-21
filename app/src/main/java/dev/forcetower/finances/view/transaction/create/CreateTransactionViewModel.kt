package dev.forcetower.finances.view.transaction.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.forcetower.finances.core.domain.usecase.transaction.CreateTransactionUseCase
import dev.forcetower.finances.core.model.database.Account
import dev.forcetower.finances.core.model.database.Category
import dev.forcetower.finances.core.model.database.Subcategory
import dev.forcetower.toolkit.extensions.setValueIfNew
import java.time.LocalDate
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class CreateTransactionViewModel @Inject constructor(
    private val createTransaction: CreateTransactionUseCase,
) : ViewModel(), CreateTransactionActions {
    override val value = MutableLiveData("")
    override val name = MutableLiveData("")
    override val date = MutableLiveData(LocalDate.now().atStartOfDay())
    override val category = MutableLiveData<Category>(null)
    override val subcategory = MutableLiveData<Subcategory>(null)
    override val account = MutableLiveData<Account>(null)

    fun setTransactionDate(date: LocalDateTime) {
        this.date.setValueIfNew(date)
    }

    fun setTransactionCategory(category: Category) {

    }
}