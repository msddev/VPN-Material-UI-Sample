package com.mkdev.vpnnewdesign

import android.content.Intent
import android.os.Bundle
import com.mkdev.vpnnewdesign.base.BaseActivity
import kotlinx.android.synthetic.main.activity_server_name.*

class ServerNameActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_server_name)

        nextButton.setOnClickListener {
            startActivity(Intent(this@ServerNameActivity, MainActivity::class.java))
            finish()
        }
    }
}