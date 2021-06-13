package com.mkdev.vpnnewdesign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout
import com.mkdev.vpnnewdesign.adapter.ConnectionsAdapter
import com.mkdev.vpnnewdesign.enums.ItemModifyType
import com.mkdev.vpnnewdesign.models.ConnectionModel
import kotlinx.android.synthetic.main.activity_connection.*


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

        dataList.add(
            0,
            ConnectionModel(isHeader = true, title = getString(R.string.header_active_connection))
        )
        dataList.add(
            2,
            ConnectionModel(isHeader = true, title = getString(R.string.header_other_connection))
        )

        listAdapter = ConnectionsAdapter(
            items = dataList,
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
            onItemModifyClicked = { position, actionType ->
                when (actionType) {
                    ItemModifyType.CHANGE_CONNECTION -> {

                        val lastActiveIndex = dataList.indexOfFirst { it.isActive }

                        if (lastActiveIndex >= 0 && lastActiveIndex != position) {
                            dataList[lastActiveIndex].isActive = false
                            dataList[position].isActive = true
                            listAdapter.swap(position, lastActiveIndex)
                            listAdapter.notifyItemRangeChanged(lastActiveIndex, position)
                        } else {
                            Toast.makeText(this, "Unchanged", Toast.LENGTH_SHORT).show()
                        }
                    }

                    ItemModifyType.EDIT -> {
                        showConnectionNameDialog { title ->
                            updateConnectionItem(position, title)
                        }
                    }

                    ItemModifyType.DELETE -> {
                        showDialog(
                            text = R.string.delete_connection_question,
                            decline = R.string.cancel_string,
                            onCallback = {
                                deleteConnectionItem(position)
                            }
                        )
                    }

                    ItemModifyType.CREDENTIAL -> {
                        showCredentialDialog { username, password ->

                        }
                    }
                }

            })
        listView.adapter = listAdapter
    }

    private fun showDialog(
        @StringRes title: Int = R.string.moka_string,
        @StringRes text: Int,
        @StringRes decline: Int = R.string.decline_string,
        @StringRes accept: Int = R.string.accept_string,
        onCallback: (() -> Unit)
    ) {
        MaterialAlertDialogBuilder(this)
            .setTitle(resources.getString(title))
            .setMessage(resources.getString(text))
            .setNegativeButton(resources.getString(decline)) { dialog, _ ->
                dialog.dismiss()
            }
            .setPositiveButton(resources.getString(accept)) { _, _ ->
                onCallback()
            }.show()
    }

    private fun showConnectionNameDialog(onCallback: ((String) -> Unit)) {
        val customAlertDialogView: View = LayoutInflater.from(this)
            .inflate(R.layout.custom_connection_name_dialog, null, false)
        val nameTextField =
            customAlertDialogView.findViewById<TextInputLayout>(R.id.connection_name_text_field)

        val materialAlertDialogBuilder = MaterialAlertDialogBuilder(this)
        materialAlertDialogBuilder.setView(customAlertDialogView)
            .setTitle(resources.getString(R.string.moka_string))
            .setPositiveButton(getString(R.string.update_string)) { _, _ ->
                val name = nameTextField.editText?.text.toString()
                onCallback(name)
            }
            .setNegativeButton(resources.getString(R.string.cancel_string)) { dialog, _ ->
                dialog.dismiss()
            }.show()
    }

    private fun showCredentialDialog(onCallback: ((String, String) -> Unit)) {
        val customAlertDialogView: View = LayoutInflater.from(this)
            .inflate(R.layout.custom_connection_credential_dialog, null, false)
        val usernameTextField =
            customAlertDialogView.findViewById<TextInputLayout>(R.id.username_text_field)
        val passwordTextField =
            customAlertDialogView.findViewById<TextInputLayout>(R.id.password_text_field)

        val materialAlertDialogBuilder = MaterialAlertDialogBuilder(this)
        materialAlertDialogBuilder.setView(customAlertDialogView)
            .setTitle(resources.getString(R.string.moka_string))
            .setPositiveButton(getString(R.string.update_string)) { _, _ ->
                val username = usernameTextField.editText?.text.toString()
                val password = passwordTextField.editText?.text.toString()
                onCallback(username, password)
            }
            .setNegativeButton(resources.getString(R.string.cancel_string)) { dialog, _ ->
                dialog.dismiss()
            }.show()
    }

    private fun updateConnectionItem(position: Int, title: String) {
        dataList[position].title = title
        listAdapter.notifyItemChanged(position)
    }

    private fun deleteConnectionItem(position: Int) {
        dataList.removeAt(position)
        listAdapter.notifyItemRemoved(position)
    }
}
