package com.mkdev.vpnnewdesign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.app_bar_detail.*

class ThemeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme)

        detailToolbar.title = "Test title "
        detailToolbar.subtitle = "Test"

    }

    override fun onBackPressed() {

    }
}