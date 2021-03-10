package com.mkdev.vpnnewdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.app_bar_detail.*

class OtpIdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_id)

        setupToolbar()
    }

    private fun setupToolbar() {
        detailToolbar.title = getString(R.string.toolbar_title)
        detailToolbar.setNavigationOnClickListener {
            //handleBackPress()
        }
    }
}