package com.mkdev.vpnnewdesign.extensionFun

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
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

fun View.slideUp(duration: Long = 500, transY: Float) {
    visible()
    animate().translationY(transY)
        .alpha(1f)
        .setDuration(duration)
        .setListener(null)
}

fun View.slideDown(duration: Long = 500, transY: Float) {
    animate().translationY(transY)
        .alpha(0f)
        .setDuration(duration)
        .setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationStart(animation)
                invisible()
            }
        })
}
