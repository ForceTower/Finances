package dev.forcetower.finances.view.auth.register.basic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import dev.forcetower.finances.R
import dev.forcetower.finances.databinding.FragmentAuthCreateBasicBinding
import dev.forcetower.finances.view.auth.register.CreateAccountViewModel
import dev.forcetower.toolkit.components.BaseFragment
import dev.forcetower.toolkit.lifecycle.EventObserver

class CreateBasicFragment : BaseFragment() {
    private val viewModel by hiltNavGraphViewModels<CreateAccountViewModel>(R.id.auth_graph)
    private lateinit var binding: FragmentAuthCreateBasicBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentAuthCreateBasicBinding.inflate(inflater, container, false).also {
            binding = it
            binding.actions = viewModel
            binding.lifecycleOwner = viewLifecycleOwner
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onBasicContinue.observe(viewLifecycleOwner, EventObserver {
            val directions = CreateBasicFragmentDirections.actionCreateBasicToCreatePassword()
            findNavController().navigate(directions)
        })
    }
}