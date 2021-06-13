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
        ConnectionModel(title = "Connection1", isSelected = true, isActive = true),
        ConnectionModel(title = "Connection2"),
        ConnectionModel(title = "Connection3"),
        ConnectionModel(title = "Connection4"),
        ConnectionModel(title = "Connection5"),
        ConnectionModel(title = "Connection6"),
        ConnectionModel(title = "Connection7"),
        ConnectionModel(title = "Connection8")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connection)

        dataList.add(0, ConnectionModel(isHeader = true, title = "Active Connection"))
        dataList.add(2, ConnectionModel(isHeader = true, title = "Other Connections"))

        listAdapter = ConnectionsAdapter(
            dataList = dataList,
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
                    listAdapter.notifyItemMoved(position, 0)
                    listAdapter.notifyItemMoved(1, position)
                    listAdapter.notifyItemChanged(position)
                    listAdapter.notifyItemChanged(0)
                } else {
                    Toast.makeText(this, "Unchanged", Toast.LENGTH_SHORT).show()
                }
            })
        listView.adapter = listAdapter
    }
}
