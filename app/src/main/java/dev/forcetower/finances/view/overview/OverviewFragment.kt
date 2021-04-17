package dev.forcetower.finances.view.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.forcetower.finances.databinding.FragmentHomeOverviewBinding
import dev.forcetower.toolkit.components.BaseFragment

class OverviewFragment : BaseFragment() {
    private lateinit var binding: FragmentHomeOverviewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentHomeOverviewBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }
}