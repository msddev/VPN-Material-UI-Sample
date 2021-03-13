package com.mkdev.vpnnewdesign

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_otp_code.*

class OtpCodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_code)

        otpCodeText.onChangeStateCallback = {
            otpCodeNextAction.isVisible = it
        }

        otpCodeNextAction.setOnClickListener {
            if (otpCodeText.getDigits() == -1) {
                Toast.makeText(this, "Please fill all blank box!", Toast.LENGTH_LONG).show()
            }
        }
    }
}