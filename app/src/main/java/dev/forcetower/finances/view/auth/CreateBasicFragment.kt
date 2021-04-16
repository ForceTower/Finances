package dev.forcetower.finances.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.forcetower.finances.databinding.FragmentAuthCreateBasicBinding
import dev.forcetower.toolkit.components.BaseFragment

class CreateBasicFragment : BaseFragment() {
    private lateinit var binding: FragmentAuthCreateBasicBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentAuthCreateBasicBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }
}