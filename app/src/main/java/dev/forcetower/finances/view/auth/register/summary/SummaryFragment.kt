package dev.forcetower.finances.view.auth.register.summary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.forcetower.finances.R
import dev.forcetower.finances.databinding.FragmentAuthCreateSummaryBinding
import dev.forcetower.finances.view.auth.register.CreateAccountViewModel
import dev.forcetower.toolkit.components.BaseFragment

@AndroidEntryPoint
class SummaryFragment : BaseFragment() {
    private val viewModel by hiltNavGraphViewModels<CreateAccountViewModel>(R.id.auth_graph)
    private lateinit var binding: FragmentAuthCreateSummaryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentAuthCreateSummaryBinding.inflate(inflater, container, false).also {
            binding = it
            binding.actions = viewModel
            binding.lifecycleOwner = viewLifecycleOwner
        }.root
    }
}