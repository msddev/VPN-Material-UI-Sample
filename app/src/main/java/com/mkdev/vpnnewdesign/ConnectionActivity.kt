package com.mkdev.vpnnewdesign

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mkdev.vpnnewdesign.adapter.ConnectionsAdapter
import com.mkdev.vpnnewdesign.models.ConnectionModel
import kotlinx.android.synthetic.main.activity_connection.*
import java.util.*


class ConnectionActivity : AppCompatActivity() {

    private lateinit var listAdapter: ConnectionsAdapter
    private val dataList: MutableList<ConnectionModel> = mutableListOf(
        ConnectionModel(name = "Connection1", isSelected = true, isActive = true),
        ConnectionModel(name = "Connection2"),
        ConnectionModel(name = "Connection3"),
        ConnectionModel(name = "Connection4"),
        ConnectionModel(name = "Connection5"),
        ConnectionModel(name = "Connection6"),
        ConnectionModel(name = "Connection7"),
        ConnectionModel(name = "Connection8")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connection)

        listAdapter = ConnectionsAdapter(dataList = dataList,
            onItemClicked = { position ->
                val lastIndex = dataList.indexOfFirst { it.isSelected }
                if (lastIndex >= 0) {
                    dataList[lastIndex].isSelected = false
                    listAdapter.notifyItemChanged(lastIndex)
                }

                if (position != lastIndex) {
                    dataList[position].isSelected = true
                    listAdapter.notifyItemChanged(position)
                }
            },
            onItemActivationClicked = { position ->
                val lastActiveIndex = dataList.indexOfFirst { it.isActive }
                if (lastActiveIndex >= 0 && lastActiveIndex != position) {
                    dataList[lastActiveIndex].isActive = false
                    dataList[position].isActive = true
                    Collections.swap(dataList, position, 0)
                    listAdapter.notifyItemChanged(position)
                    listAdapter.notifyItemChanged(lastActiveIndex)
                } else {
                    Toast.makeText(this, "Unchanged", Toast.LENGTH_SHORT).show()
                }
            })
        listView.adapter = listAdapter
    }
}
