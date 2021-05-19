package dev.forcetower.finances.view.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.transition.MaterialSharedAxis
import dev.forcetower.finances.databinding.FragmentHomeOverviewBinding
import dev.forcetower.toolkit.components.BaseFragment

class OverviewFragment : BaseFragment() {
    private val viewModel by activityViewModels<OverviewViewModel>()
    private lateinit var binding: FragmentHomeOverviewBinding
    private lateinit var adapter: TransactionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, true)
        // pop-enter
        reenterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, false)
        // exit
        exitTransition = MaterialSharedAxis(MaterialSharedAxis.Z, true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        adapter = TransactionAdapter()
        return FragmentHomeOverviewBinding.inflate(inflater, container, false).also {
            binding = it
            binding.actions = viewModel
            binding.recyclerTransactions.adapter = adapter
            binding.lifecycleOwner = viewLifecycleOwner
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddTransaction.setOnClickListener {
            val directions = OverviewFragmentDirections.actionHomeOverviewToCreateTransaction()
            findNavController().navigate(directions)
        }
    }
}