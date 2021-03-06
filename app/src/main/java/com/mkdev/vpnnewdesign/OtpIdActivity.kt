package com.mkdev.vpnnewdesign

import android.os.Bundle
import com.mkdev.vpnnewdesign.base.BaseActivity
import kotlinx.android.synthetic.main.app_bar_detail.*

class OtpIdActivity : BaseActivity() {
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