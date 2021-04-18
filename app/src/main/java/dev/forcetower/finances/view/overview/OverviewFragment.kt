package dev.forcetower.finances.view.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dev.forcetower.finances.core.model.database.Transaction
import dev.forcetower.finances.databinding.FragmentHomeOverviewBinding
import dev.forcetower.toolkit.components.BaseFragment

class OverviewFragment : BaseFragment() {
    private lateinit var binding: FragmentHomeOverviewBinding
    private lateinit var adapter: TransactionAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        adapter = TransactionAdapter()
        return FragmentHomeOverviewBinding.inflate(inflater, container, false).also {
            binding = it
            binding.recyclerTransactions.adapter = adapter
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.submitList(transactions)

        binding.btnAddTransaction.setOnClickListener {
            val directions = OverviewFragmentDirections.actionHomeOverviewToCreateTransaction()
            findNavController().navigate(directions)
        }
    }

    companion object {
        private val transactions = listOf(
            Transaction(1, "Netflix", "Streaming service", 45.90f, 1, 1),
            Transaction(2, "Spotify", "Streaming service", 45.90f, 1, 1),
            Transaction(3, "YouTube Premium", "Streaming service", 45.90f, 1, 1),
            Transaction(4, "Netflix", "Streaming service", 45.90f, 1, 1),
            Transaction(5, "Netflix", "Streaming service", 45.90f, 1, 1),
            Transaction(6, "Netflix", "Streaming service", 45.90f, 1, 1),
        )
    }
}