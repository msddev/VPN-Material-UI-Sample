package com.mkdev.vpnnewdesign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mkdev.vpnnewdesign.adapter.ConnectionsAdapter
import com.mkdev.vpnnewdesign.models.ConnectionModel
import kotlinx.android.synthetic.main.activity_connection.*


class ConnectionActivity : AppCompatActivity() {

    private lateinit var listAdapter: ConnectionsAdapter
    private val data: MutableList<ConnectionModel> = mutableListOf(
        ConnectionModel(), ConnectionModel(), ConnectionModel(isSelected = true), ConnectionModel(),
        ConnectionModel(), ConnectionModel(), ConnectionModel(), ConnectionModel()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connection)

        listAdapter = ConnectionsAdapter(dataList = data, onItemClicked = { position ->
            val lastIndex = data.indexOfFirst { it.isSelected }
            if (lastIndex >= 0) {
                data[lastIndex].isSelected = false
                listAdapter.notifyItemChanged(lastIndex)
            }

            if (position != lastIndex) {
                data[position].isSelected = true
                listAdapter.notifyItemChanged(position)
            }
        })
        listView.adapter = listAdapter
    }
}
