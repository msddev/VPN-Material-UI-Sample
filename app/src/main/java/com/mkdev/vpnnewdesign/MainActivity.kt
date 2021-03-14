package com.mkdev.vpnnewdesign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.app_bar_detail.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar()
    }

    private fun setupToolbar() {
        detailToolbar.setNavigationOnClickListener {
            //handleBackPress()
        }
        detailToolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24)
    }
}