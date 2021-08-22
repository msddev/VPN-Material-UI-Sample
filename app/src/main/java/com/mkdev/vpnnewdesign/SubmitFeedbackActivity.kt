package com.mkdev.vpnnewdesign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.app_bar_detail.*

class SubmitFeedbackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit_feedback)

        setupToolbar()
    }

    private fun setupToolbar() {
        detailToolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        detailToolbar.title = getString(R.string.feedback)
    }
}