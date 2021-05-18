package dev.forcetower.finances.view.auth.register.image

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.forcetower.finances.R
import dev.forcetower.finances.databinding.FragmentAuthCreatePictureBinding
import dev.forcetower.finances.view.auth.register.CreateAccountViewModel
import dev.forcetower.toolkit.components.BaseFragment
import dev.forcetower.toolkit.lifecycle.EventObserver

@AndroidEntryPoint
class PickImageFragment : BaseFragment() {
    private val viewModel by hiltNavGraphViewModels<CreateAccountViewModel>(R.id.auth_graph)
    private lateinit var binding: FragmentAuthCreatePictureBinding

    private val pickImage = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri ?: return@registerForActivityResult
        viewModel.setUserRegisterImage(uri)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentAuthCreatePictureBinding.inflate(inflater, container, false).also {
            binding = it
            binding.actions = viewModel
            binding.lifecycleOwner = viewLifecycleOwner
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onImageContinue.observe(viewLifecycleOwner, EventObserver {
            val directions = PickImageFragmentDirections.actionPickImageToSummary()
            findNavController().navigate(directions)
        })

        viewModel.onSelectPicture.observe(viewLifecycleOwner, EventObserver {
            pickImage.launch("image/*")
        })
    }
}