package com.mkdev.vpnnewdesign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mkdev.vpnnewdesign.adapter.LogsAdapter
import kotlinx.android.synthetic.main.activity_logs.*

class LogsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logs)

        logsList.adapter = LogsAdapter(
            items = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        ) {

        }
    }
}