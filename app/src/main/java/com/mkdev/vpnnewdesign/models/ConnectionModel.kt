package com.mkdev.vpnnewdesign.models

data class ConnectionModel(
    val isHeader:Boolean = true,
    var isSelected: Boolean = false,
    var isActive: Boolean = false,
    val data: Int = 0,
    val title: String = ""
)
