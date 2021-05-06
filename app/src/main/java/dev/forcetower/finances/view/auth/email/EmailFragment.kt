package dev.forcetower.finances.view.auth.email

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.forcetower.finances.R
import dev.forcetower.finances.databinding.FragmentAuthEmailBinding
import dev.forcetower.finances.view.auth.AuthViewModel
import dev.forcetower.toolkit.components.BaseFragment

@AndroidEntryPoint
class EmailFragment : BaseFragment() {
    private val viewModel by navGraphViewModels<AuthViewModel>(R.id.auth_graph) { defaultViewModelProviderFactory }
    private lateinit var binding: FragmentAuthEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = FragmentAuthEmailBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
        binding.actions = viewModel
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.connected.observe(viewLifecycleOwner, {
            navigateToConnected()
        })

        binding.btnLoginEmail.setOnClickListener {
            val directions = EmailFragmentDirections.actionAuthEmailToAuthPassword()
            findNavController().navigate(directions)
        }
    }

    private fun navigateToConnected() {
        val directions = EmailFragmentDirections.actionGlobalHomeOverview()
        findNavController().navigate(directions)
    }
}