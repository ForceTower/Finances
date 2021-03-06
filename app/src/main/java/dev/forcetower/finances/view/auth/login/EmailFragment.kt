package dev.forcetower.finances.view.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.forcetower.finances.R
import dev.forcetower.finances.databinding.FragmentAuthEmailBinding
import dev.forcetower.finances.view.auth.AuthViewModel
import dev.forcetower.toolkit.components.BaseFragment
import dev.forcetower.toolkit.lifecycle.EventObserver

@AndroidEntryPoint
class EmailFragment : BaseFragment() {
    private val authViewModel by hiltNavGraphViewModels<AuthViewModel>(R.id.auth_graph)
    private val viewModel by hiltNavGraphViewModels<EmailViewModel>(R.id.auth_graph)
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
        binding.lifecycleOwner = viewLifecycleOwner
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authViewModel.connected.observe(viewLifecycleOwner, {
            navigateToConnected()
        })
        viewModel.onCreateAccount.observe(viewLifecycleOwner, EventObserver {
            navigateToCreateAccount()
        })
    }

    private fun navigateToCreateAccount() {
        val directions = EmailFragmentDirections.actionAuthEmailToCreateBasicFragment()
        findNavController().navigate(directions)
    }

    private fun navigateToConnected() {
        val directions = EmailFragmentDirections.actionGlobalHomeOverview()
        findNavController().navigate(directions)
    }
}