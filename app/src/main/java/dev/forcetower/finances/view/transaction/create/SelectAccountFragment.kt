package dev.forcetower.finances.view.transaction.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.transition.MaterialSharedAxis
import dev.forcetower.finances.databinding.FragmentSelectAccountBinding
import dev.forcetower.toolkit.components.BaseFragment

class SelectAccountFragment : BaseFragment() {
    private lateinit var binding: FragmentSelectAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, true)
        returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, false)
        exitTransition = MaterialSharedAxis(MaterialSharedAxis.Z, true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentSelectAccountBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }
}