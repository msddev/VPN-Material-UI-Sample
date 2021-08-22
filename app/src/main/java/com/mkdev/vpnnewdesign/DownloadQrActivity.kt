package com.mkdev.vpnnewdesign

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.mkdev.vpnnewdesign.base.BaseActivity

class DownloadQrActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download_qr)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@DownloadQrActivity, ServerNameActivity::class.java))
            finish()
        }, 2000)
    }
}