package dev.forcetower.finances.view

import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.forcetower.finances.R
import dev.forcetower.finances.databinding.ActivityMainBinding
import dev.forcetower.toolkit.components.BaseActivity

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        WindowCompat.setDecorFitsSystemWindows(window, false)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.fragment_container).navigateUp()
}