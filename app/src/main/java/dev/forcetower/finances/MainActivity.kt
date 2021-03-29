package dev.forcetower.finances

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.forcetower.toolkit.components.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val (added, removed) = listOf(true, false, true, false).partition { it }
    }
}