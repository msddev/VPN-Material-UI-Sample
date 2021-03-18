package com.mkdev.vpnnewdesign

import android.content.Intent
import android.os.Bundle
import com.mkdev.vpnnewdesign.base.BaseActivity
import kotlinx.android.synthetic.main.activity_connect.*

class ConnectActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connect)

        connectQrButton.setOnClickListener {
            startActivity(Intent(this@ConnectActivity, DownloadQrActivity::class.java))
        }

        connectOtpButton.setOnClickListener {
            startActivity(Intent(this@ConnectActivity, OtpCodeActivity::class.java))
        }
    }

    override fun onBackPressed() {}
}