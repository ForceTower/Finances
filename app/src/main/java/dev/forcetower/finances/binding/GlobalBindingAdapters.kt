package dev.forcetower.finances.binding

import android.widget.EditText
import androidx.databinding.BindingAdapter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@BindingAdapter("transactionDate")
fun EditText.transactionDate(date: LocalDateTime) {
    setText(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
}