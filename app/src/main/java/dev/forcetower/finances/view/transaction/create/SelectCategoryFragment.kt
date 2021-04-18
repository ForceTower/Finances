package dev.forcetower.finances.view.transaction.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.forcetower.finances.databinding.FragmentSelectCategoryBinding
import dev.forcetower.toolkit.components.BaseFragment

class SelectCategoryFragment : BaseFragment() {
    private lateinit var binding: FragmentSelectCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentSelectCategoryBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }
}