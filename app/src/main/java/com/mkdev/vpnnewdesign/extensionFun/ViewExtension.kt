package com.mkdev.vpnnewdesign.extensionFun

import android.view.View

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.setAvailability(isAvailable: Boolean) {
    isEnabled = isAvailable
    isClickable = isAvailable
}
