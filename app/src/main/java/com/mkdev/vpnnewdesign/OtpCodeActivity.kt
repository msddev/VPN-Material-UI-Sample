package com.mkdev.vpnnewdesign

import android.os.Bundle
import android.os.CountDownTimer
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

        object : CountDownTimer(120000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minute = String.format("%02d", millisUntilFinished / (60 * 1000) % 60)
                val second = String.format("%02d", millisUntilFinished / 1000 % 60)
                otpCodeTimer.text = "$minute:$second"
                //here you can have your logic to set text to edittext
            }

            override fun onFinish() {
                otpCodeTimer.text = "00:00"
            }
        }.start()
    }
}