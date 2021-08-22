package com.mkdev.vpnnewdesign

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.mkdev.vpnnewdesign.base.BaseActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity, ConnectActivity::class.java))
            finish()
        }, 2000)
    }

    override fun onBackPressed() {}
}