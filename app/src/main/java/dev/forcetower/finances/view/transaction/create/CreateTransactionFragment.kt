package dev.forcetower.finances.view.transaction.create

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.transition.MaterialSharedAxis
import dagger.hilt.android.AndroidEntryPoint
import dev.forcetower.finances.R
import dev.forcetower.finances.databinding.FragmentCreateTransactionBinding
import dev.forcetower.toolkit.components.BaseFragment
import timber.log.Timber
import java.text.NumberFormat
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class CreateTransactionFragment : BaseFragment() {
    private val viewModel by hiltNavGraphViewModels<CreateTransactionViewModel>(R.id.create_transaction_graph)
    private lateinit var binding: FragmentCreateTransactionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enter
        enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, true)
        // pop-exit
        returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, false)
        reenterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, false)
        exitTransition = MaterialSharedAxis(MaterialSharedAxis.Z, true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentCreateTransactionBinding.inflate(inflater, container, false).also {
            binding = it
            binding.actions = viewModel
            binding.lifecycleOwner = viewLifecycleOwner
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.transactionDate.setOnClickListener {
            showDatePicker()
        }
        binding.transactionCategory.setOnClickListener {
            navigateToSelectCategory()
        }
        binding.transactionAccount.setOnClickListener {
            navigateToSelectAccount()
        }

        binding.transactionValue.addTextChangedListener(object : TextWatcher {
            private var current = ""
            private val format = NumberFormat.getInstance().apply { minimumFractionDigits = 2 }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString() != current) {
                    binding.transactionValue.removeTextChangedListener(this)

                    val cleanString: String = s.replace("""[,.]""".toRegex(), "").trim()

                    val parsed = cleanString.toDouble()
                    val value = parsed / 100
                    val formatted = format.format(value)

                    current = formatted
                    binding.transactionValue.setText(formatted)
                    binding.transactionValue.setSelection(formatted.length)

                    binding.transactionValue.addTextChangedListener(this)
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun navigateToSelectCategory() {
        val directions = CreateTransactionFragmentDirections.actionCreateTransactionToSelectCategory()
        findNavController().navigate(directions)
    }

    private fun navigateToSelectAccount() {
        val directions = CreateTransactionFragmentDirections.actionCreateTransactionToSelectAccount()
        findNavController().navigate(directions)
    }

    private fun showDatePicker() {
        val base = viewModel.date.value ?: LocalDate.now().atStartOfDay()

        val open = base
            .atZone(ZoneId.ofOffset("UTC", ZoneOffset.UTC))
            .toInstant()
            .toEpochMilli()

        val constraints = CalendarConstraints.Builder()
            .setOpenAt(open)
            .build()

        val picker = MaterialDatePicker.Builder
            .datePicker()
            .setCalendarConstraints(constraints)
            .apply { setSelection(open) }
            .build()

        picker.addOnPositiveButtonClickListener {
            val instant = Instant.ofEpochMilli(it)
            val date = LocalDateTime.ofInstant(instant, ZoneId.ofOffset("UTC", ZoneOffset.UTC))
            viewModel.setTransactionDate(date)
        }

        picker.show(childFragmentManager, "transaction_date_picker")
    }
}