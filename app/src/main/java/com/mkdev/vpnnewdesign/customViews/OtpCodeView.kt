package com.mkdev.vpnnewdesign.customViews

import android.content.Context
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.addTextChangedListener
import com.mkdev.vpnnewdesign.R
import kotlinx.android.synthetic.main.view_opt_code.view.*

class OtpCodeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var otpCodeText1ChangedListener: TextWatcher? = null
    private var otpCodeText2ChangedListener: TextWatcher? = null
    private var otpCodeText3ChangedListener: TextWatcher? = null
    private var otpCodeText4ChangedListener: TextWatcher? = null
    private var otpCodeText5ChangedListener: TextWatcher? = null
    private var otpCodeText6ChangedListener: TextWatcher? = null
    var onChangeStateCallback: ((value: Boolean) -> Unit)? = null

    init {
        inflate(context, R.layout.view_opt_code, this)
        setTextWatcher()
    }

    private fun setTextWatcher() {
        otpCodeText1ChangedListener = otpCodeText1.addTextChangedListener {
            onChangeStateCallback?.invoke(!checkNullOrEmptyBox())
            if (!it.isNullOrEmpty()) {
                otpCodeText2.requestFocus()
            }
        }

        otpCodeText2ChangedListener = otpCodeText2.addTextChangedListener {
            onChangeStateCallback?.invoke(!checkNullOrEmptyBox())
            if (!it.isNullOrEmpty()) {
                otpCodeText3.requestFocus()
            } else {
                otpCodeText1.requestFocus()
            }
        }

        otpCodeText3ChangedListener = otpCodeText3.addTextChangedListener {
            onChangeStateCallback?.invoke(!checkNullOrEmptyBox())
            if (!it.isNullOrEmpty()) {
                otpCodeText4.requestFocus()
            } else {
                otpCodeText2.requestFocus()
            }
        }

        otpCodeText4ChangedListener = otpCodeText4.addTextChangedListener {
            onChangeStateCallback?.invoke(!checkNullOrEmptyBox())
            if (!it.isNullOrEmpty()) {
                otpCodeText5.requestFocus()
            } else {
                otpCodeText3.requestFocus()
            }
        }

        otpCodeText5ChangedListener = otpCodeText5.addTextChangedListener {
            onChangeStateCallback?.invoke(!checkNullOrEmptyBox())
            if (!it.isNullOrEmpty()) {
                otpCodeText6.requestFocus()
            } else {
                otpCodeText4.requestFocus()
            }
        }

        otpCodeText6ChangedListener = otpCodeText6.addTextChangedListener {
            onChangeStateCallback?.invoke(!checkNullOrEmptyBox())
            if (it.isNullOrEmpty()) {
                otpCodeText5.requestFocus()
            }
        }
    }

    fun getDigits(): Int {
        if (checkNullOrEmptyBox()) {
            return -1
        }
        val num1 = otpCodeText1.text.toString().toInt()
        val num2 = otpCodeText2.text.toString().toInt()
        val num3 = otpCodeText3.text.toString().toInt()
        val num4 = otpCodeText4.text.toString().toInt()
        val num5 = otpCodeText5.text.toString().toInt()
        val num6 = otpCodeText6.text.toString().toInt()

        return (num1 * 100000) + (num2 * 10000) + (num3 * 1000) + (num4 * 100) + (num5 * 10) + (num6 * 1)
    }

    private fun checkNullOrEmptyBox(): Boolean {
        return otpCodeText1.text.isNullOrEmpty() ||
                otpCodeText2.text.isNullOrEmpty() ||
                otpCodeText3.text.isNullOrEmpty() ||
                otpCodeText4.text.isNullOrEmpty() ||
                otpCodeText5.text.isNullOrEmpty() ||
                otpCodeText6.text.isNullOrEmpty()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        otpCodeText1.removeTextChangedListener(otpCodeText1ChangedListener)
        otpCodeText2.removeTextChangedListener(otpCodeText2ChangedListener)
        otpCodeText3.removeTextChangedListener(otpCodeText3ChangedListener)
        otpCodeText4.removeTextChangedListener(otpCodeText4ChangedListener)
        otpCodeText5.removeTextChangedListener(otpCodeText5ChangedListener)
        otpCodeText6.removeTextChangedListener(otpCodeText6ChangedListener)
    }
}

private fun <R> ((() -> R)?).invoke(b: Boolean) {

}
