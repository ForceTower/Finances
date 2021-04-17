package dev.forcetower.finances.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.getResourceIdOrThrow
import androidx.core.content.res.getStringOrThrow
import dev.forcetower.finances.R
import dev.forcetower.finances.databinding.ViewOverviewActionItemBinding

class OverviewActionItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val bind = ViewOverviewActionItemBinding.inflate(LayoutInflater.from(context), this, true)
    private val icon = bind.icon
    private val text = bind.text

    init {
        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.OverviewActionItemView,
            defStyleAttr,
            0
        )

        val icon = typedArray.getResourceIdOrThrow(R.styleable.OverviewActionItemView_icon)
        val text = typedArray.getStringOrThrow(R.styleable.OverviewActionItemView_text)

        typedArray.recycle()

        setText(text)
        setIcon(icon)
    }

    private fun setIcon(@DrawableRes src: Int?) {
        src?.let { icon.setImageDrawable(ContextCompat.getDrawable(context, src)) }
    }

    private fun setText(str: String) {
        text.text = str
    }
}