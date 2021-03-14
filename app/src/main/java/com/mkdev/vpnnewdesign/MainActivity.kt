package com.mkdev.vpnnewdesign

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_detail.*


class MainActivity : AppCompatActivity() {

    private var enableAnimate: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar()

        mainOnOffAction.setOnClickListener {
            startRotation()
        }
    }

    private fun setupToolbar() {
        detailToolbar.setNavigationOnClickListener {
            //handleBackPress()
        }
        detailToolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24)
    }

    private fun startRotation() {
        if (!enableAnimate) {
            val rotateA = RotateAnimation(
                0f,
                360f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
            ).apply {
                duration = 2500
                repeatCount = Animation.INFINITE
                interpolator = LinearInterpolator()
            }
            val rotateB = RotateAnimation(
                0f,
                -360f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
            ).apply {
                duration = 2500
                repeatCount = Animation.INFINITE
                interpolator = LinearInterpolator()
            }

            mainLogoCircleImageA.startAnimation(rotateA)
            mainLogoCircleImageB.startAnimation(rotateB)
        } else {
            mainLogoCircleImageA.clearAnimation()
            mainLogoCircleImageB.clearAnimation()
        }
        enableAnimate = !enableAnimate
    }
}