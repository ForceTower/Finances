package dev.forcetower.finances.view.overview

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.forcetower.finances.R
import dev.forcetower.finances.core.model.database.Transaction
import dev.forcetower.finances.databinding.ItemTransactionSimpleBinding
import dev.forcetower.toolkit.extensions.inflate

class TransactionAdapter : ListAdapter<Transaction, TransactionAdapter.TransactionHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionHolder {
        return TransactionHolder(parent.inflate(R.layout.item_transaction_simple))
    }

    override fun onBindViewHolder(holder: TransactionHolder, position: Int) {

    }

    inner class TransactionHolder(
        val binding: ItemTransactionSimpleBinding
    ) : RecyclerView.ViewHolder(binding.root)

    private object DiffCallback : DiffUtil.ItemCallback<Transaction>() {
        override fun areItemsTheSame(oldItem: Transaction, newItem: Transaction): Boolean {
            return oldItem.id == newItem.id

        }

        override fun areContentsTheSame(oldItem: Transaction, newItem: Transaction): Boolean {
            return oldItem == newItem
        }
    }

}