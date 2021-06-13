package com.mkdev.vpnnewdesign.models

data class ConnectionModel(
    val isHeader:Boolean = false,
    var isSelected: Boolean = false,
    var isActive: Boolean = false,
    val data: Int = 0,
    var title: String = ""
)
