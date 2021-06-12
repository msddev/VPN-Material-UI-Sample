package com.mkdev.vpnnewdesign.extensionFun

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import android.view.animation.AnimationUtils
import com.mkdev.vpnnewdesign.R

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

fun View.setCustomAnimation(currentPosition: Int, lastPosition: Int) {
    if (currentPosition > lastPosition) {
        val animation = AnimationUtils.loadAnimation(context, R.anim.fade_in)
        animation.duration = 700
        this.startAnimation(animation)
    }
}

