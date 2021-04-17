package dev.forcetower.finances.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.google.android.material.card.MaterialCardView
import dev.forcetower.finances.R
import dev.forcetower.finances.databinding.ViewOverviewBalanceCardBinding
import dev.forcetower.toolkit.bindings.roundedViewRadius
import java.text.NumberFormat
import java.util.Currency

class OverviewBalanceCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {
    private val bind = ViewOverviewBalanceCardBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )
    private val balance = bind.valueBalance
    private val income = bind.valueIncome
    private val payment = bind.valuePayment

    private val numberFormat = NumberFormat.getCurrencyInstance()

    init {
        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.OverviewBalanceCardView,
            defStyleAttr,
            0
        )

        val balance = typedArray.getFloat(R.styleable.OverviewBalanceCardView_balance, 0f)
        val income = typedArray.getFloat(R.styleable.OverviewBalanceCardView_income, 0f)
        val payment = typedArray.getFloat(R.styleable.OverviewBalanceCardView_payment, 0f)

        typedArray.recycle()

        setBalance(balance)
        setIncome(income)
        setPayment(payment)

        roundedViewRadius(this.bind.iconIncome, 4)
        roundedViewRadius(this.bind.iconPayment, 4)

        numberFormat.maximumFractionDigits = 2
        numberFormat.minimumFractionDigits = 2
        numberFormat.currency = Currency.getInstance("BRL")
    }

    fun setBalance(balance: Float) {
        val str = numberFormat.format(balance)
        this.balance.text = context.getString(R.string.money_string_format, str)
    }

    fun setIncome(income: Float) {
        val str = numberFormat.format(income)
        this.income.text = context.getString(R.string.money_string_format, str)
    }

    fun setPayment(payment: Float) {
        val str = numberFormat.format(payment)
        this.payment.text = context.getString(R.string.money_string_format, str)
    }
}