package dev.forcetower.finances.view.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import dev.forcetower.finances.R
import dev.forcetower.finances.databinding.FragmentOnboardingBinding
import dev.forcetower.toolkit.components.BaseFragment

class OnboardingFragment : BaseFragment() {
    private lateinit var binding: FragmentOnboardingBinding
    private lateinit var backHandler: OnBackPressedCallback

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = FragmentOnboardingBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

        binding.viewPager.adapter = OnboardingFragmentAdapter(this)
        binding.dotsIndicator.setViewPager2(binding.viewPager)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backHandler = object : OnBackPressedCallback(false) {
            override fun handleOnBackPressed() {
                val prev = binding.viewPager.currentItem - 1
                binding.viewPager.setCurrentItem(prev, true)
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, backHandler)

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                backHandler.isEnabled = position != 0
            }
        })

        binding.btnContinue.setOnClickListener {
            if (binding.viewPager.currentItem == 2) {
                val directions = OnboardingFragmentDirections.actionOnboardingToAuthEmail()
                findNavController().navigate(directions)
            } else {
                binding.viewPager.setCurrentItem(binding.viewPager.currentItem + 1, true)
            }
        }
    }

    private inner class OnboardingFragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
        private val fragments = listOf(
            OnboardingPageFragment.createInstance(R.string.onboarding_title_one, R.string.onboarding_subtitle_one, R.drawable.revenue_graph_colour),
            OnboardingPageFragment.createInstance(R.string.onboarding_title_two, R.string.onboarding_subtitle_two, R.drawable.save_your_money),
            OnboardingPageFragment.createInstance(R.string.onboarding_title_three, R.string.onboarding_subtitle_three, R.drawable.business_woman_colour)
        )

        override fun getItemCount() = fragments.size
        override fun createFragment(position: Int) = fragments[position]
    }
}