package dev.forcetower.finances.view.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.os.bundleOf
import dev.forcetower.finances.databinding.FragmentOnboardingPageBinding
import dev.forcetower.toolkit.components.BaseFragment

class OnboardingPageFragment : BaseFragment() {
    private lateinit var binding: FragmentOnboardingPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = FragmentOnboardingPageBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

        val args = requireArguments()
        val title = args.getInt("title")
        val subtitle = args.getInt("subtitle")
        val image = args.getInt("image")

        binding.title.setText(title)
        binding.subtitle.setText(subtitle)
        binding.image.setImageResource(image)

        return view
    }

    companion object {
        fun createInstance(
            @StringRes title: Int,
            @StringRes subtitle: Int,
            @DrawableRes image: Int
        ): OnboardingPageFragment {
            return OnboardingPageFragment().apply {
                arguments = bundleOf(
                    "title" to title,
                    "subtitle" to subtitle,
                    "image" to image
                )
            }
        }
    }
}