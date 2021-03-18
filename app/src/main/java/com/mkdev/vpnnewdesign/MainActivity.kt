package com.mkdev.vpnnewdesign

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import com.mkdev.vpnnewdesign.base.BaseActivity
import com.mkdev.vpnnewdesign.extensionFun.fadeOutAndInVisible
import com.mkdev.vpnnewdesign.extensionFun.visible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_detail.*


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar()

        mainOnAction.setOnClickListener {
            runRotation(true)

            Handler(Looper.getMainLooper()).postDelayed({
                runRotation(false)
                fadeOutViews()
            }, 2000)
        }
    }

    private fun fadeOutViews() {
        mainOnAction.fadeOutAndInVisible()
        mainLogoCircleImageA.fadeOutAndInVisible()
        mainLogoCircleImageB.fadeOutAndInVisible()

        showOffActionButton()
    }

    private fun showOffActionButton() {
        mainOffGroup.visible()
    }

    private fun setupToolbar() {
        detailToolbar.setNavigationOnClickListener {
            startActivity(Intent(this@MainActivity, MainMenuActivity::class.java))
        }
        detailToolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24)
    }

    private fun runRotation(animationStart: Boolean) {
        if (animationStart) {
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
    }

    override fun onBackPressed() {}
}