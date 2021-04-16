package dev.forcetower.finances.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dev.forcetower.finances.databinding.FragmentAuthPasswordBinding
import dev.forcetower.toolkit.components.BaseFragment

class PasswordFragment : BaseFragment() {
    private lateinit var binding: FragmentAuthPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentAuthPasswordBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBackEmail.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}