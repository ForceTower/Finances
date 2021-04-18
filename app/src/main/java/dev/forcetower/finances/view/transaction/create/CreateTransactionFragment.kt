package dev.forcetower.finances.view.transaction.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.transition.MaterialSharedAxis
import dev.forcetower.finances.databinding.FragmentCreateTransactionBinding
import dev.forcetower.toolkit.components.BaseFragment

class CreateTransactionFragment : BaseFragment() {
    private lateinit var binding: FragmentCreateTransactionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enter
        enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, true)
        // pop-exit
        returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, false)
        exitTransition = MaterialSharedAxis(MaterialSharedAxis.Z, true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentCreateTransactionBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }
}