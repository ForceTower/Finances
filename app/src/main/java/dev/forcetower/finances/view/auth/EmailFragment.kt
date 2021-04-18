package dev.forcetower.finances.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dev.forcetower.finances.databinding.FragmentAuthEmailBinding
import dev.forcetower.toolkit.components.BaseFragment

class EmailFragment : BaseFragment() {
    private lateinit var binding: FragmentAuthEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentAuthEmailBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLoginEmail.setOnClickListener {
            val directions = EmailFragmentDirections.actionAuthEmailToAuthPassword()
            findNavController().navigate(directions)
        }

        binding.btnLoginGuest.setOnClickListener {
            val directions = EmailFragmentDirections.actionGlobalHomeOverview()
            findNavController().navigate(directions)
        }
    }
}