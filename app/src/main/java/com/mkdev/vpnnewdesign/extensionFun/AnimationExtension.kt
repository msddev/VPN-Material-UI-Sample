package com.mkdev.vpnnewdesign.extensionFun

import android.view.View
import android.view.animation.DecelerateInterpolator

fun View.fadeInAndVisible(dur: Long = 300, initialize: Boolean = false) {
    if (initialize) {
        alpha = 0f
    }
    animate().alpha(1f).withStartAction {
        visible()
    }.setInterpolator(DecelerateInterpolator()).setDuration(dur).start()
}

fun View.fadeOutAndGone(dur: Long = 300) {
    animate().alpha(0f).withEndAction {
        gone()
    }.setInterpolator(DecelerateInterpolator()).setDuration(dur).start()
}

fun View.fadeOutAndInVisible(dur: Long = 300) {
    animate().alpha(0f).withEndAction {
        invisible()
    }.setInterpolator(DecelerateInterpolator()).setDuration(dur).start()
}
