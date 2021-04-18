package dev.forcetower.finances.view.transaction.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.transition.MaterialSharedAxis
import dev.forcetower.finances.databinding.FragmentCreateTransactionBinding
import dev.forcetower.toolkit.components.BaseFragment
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class CreateTransactionFragment : BaseFragment() {
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
        val base = LocalDateTime.now()

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
            .apply {
                setSelection(open)
            }
            .build()

        picker.addOnPositiveButtonClickListener {
            val instant = Instant.ofEpochMilli(it)
            val date = LocalDateTime.ofInstant(instant, ZoneId.ofOffset("UTC", ZoneOffset.UTC))
            binding.transactionDate.setText(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
        }

        picker.show(childFragmentManager, "transaction_date_picker")
    }
}