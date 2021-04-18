package dev.forcetower.finances.view.transaction.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.forcetower.finances.databinding.FragmentSelectSubcategoryBinding
import dev.forcetower.toolkit.components.BaseFragment

class SelectSubcategoryFragment : BaseFragment() {
    private lateinit var binding: FragmentSelectSubcategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentSelectSubcategoryBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }
}