package com.mkdev.vpnnewdesign

import android.content.Intent
import android.os.Bundle
import com.mkdev.vpnnewdesign.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main_menu.*
import kotlinx.android.synthetic.main.app_bar_detail.*

class MainMenuActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        setupToolbar()

        menuAboutItem.setOnClickListener {
            finish()
            startActivity(Intent(this@MainMenuActivity, AboutActivity::class.java))
        }

        menuFeedbackItem.setOnClickListener {
            finish()
            startActivity(Intent(this@MainMenuActivity, FeedbackActivity::class.java))
        }
    }

    private fun setupToolbar() {
        detailToolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        detailToolbar.title = getString(R.string.menu)
    }
}