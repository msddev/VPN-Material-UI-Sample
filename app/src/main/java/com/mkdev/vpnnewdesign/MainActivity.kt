package com.mkdev.vpnnewdesign

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.*
import com.mkdev.vpnnewdesign.base.BaseActivity
import com.mkdev.vpnnewdesign.extensionFun.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_detail.*


class MainActivity : BaseActivity() {

    private val animationDuration = 1000L
    private val lineSet = listOf(
        "label1" to 5f,
        "label2" to 4.5f,
        "label3" to 4.7f,
        "label4" to 3.5f,
        "label5" to 3.6f,
        "label6" to 7.5f,
        "label7" to 7.5f,
        "label8" to 10f,
        "label9" to 5f,
        "label10" to 6.5f,
        "label11" to 3f,
        "label12" to 4f
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar()
        setupChart()

        mainOnAction.setOnClickListener {
            runRotationAnimation(true)

            Handler(Looper.getMainLooper()).postDelayed({
                runRotationAnimation(false)
                hideOnViews()
            }, 2000)
        }

        mainOffAction.setOnClickListener {
            hideOffViews()
            showOnViews()
        }
    }

    private fun setupChart() {
        /**
         * Line Chart
         */
        lineChart.gradientFillColors =
            intArrayOf(
                Color.parseColor("#81FFFFFF"),
                Color.TRANSPARENT
            )
        lineChart.animation.duration = animationDuration
        /*lineChart.tooltip =
            SliderTooltip().also {
                it.color = Color.WHITE
            }*/
        lineChart.onDataPointTouchListener = { index, _, _ ->
            /*lineChartValue.text =
                lineSet.toList()[index]
                    .second
                    .toString()*/
        }
        lineChart.animate(lineSet)
    }

    private fun hideOnViews() {
        mainOnAction.fadeOutAndInVisible()
        mainLogoCircleImageA.fadeOutAndInVisible()
        mainLogoCircleImageB.fadeOutAndInVisible()

        showOffViews()
    }

    private fun showOnViews() {
        mainOnAction.fadeInAndVisible()
        mainLogoCircleImageA.fadeInAndVisible()
        mainLogoCircleImageB.fadeInAndVisible()
    }

    private fun showOffViews() {
        mainOffGroup.visible()
        runSlideUp()
    }

    private fun hideOffViews() {
        mainOffGroup.invisible()
        runSlideDown()
    }

    private fun setupToolbar() {
        detailToolbar.setNavigationOnClickListener {
            startActivity(Intent(this@MainActivity, MainMenuActivity::class.java))
        }
        detailToolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24)
    }

    private fun runRotationAnimation(animationStart: Boolean) {
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

    private fun runSlideUp() {
        mainOffAction.slideUp(duration = 500, transY = -(mainOffAction.height / 2).toFloat())
        mainTimerString.slideUp(duration = 500, transY = -(mainOffAction.height / 2).toFloat())
        mainDownloadStatusString.slideUp(
            duration = 500,
            transY = -(mainOffAction.height / 2).toFloat()
        )
        LineChartRoot.slideUp(
            duration = 500,
            transY = -(mainOffAction.height / 4).toFloat()
        )
    }

    private fun runSlideDown() {
        mainOffAction.slideDown(duration = 500, transY = 0f)
        mainTimerString.slideDown(duration = 500, transY = 0f)
        mainDownloadStatusString.animate().translationY(0f)
            .alpha(1f)
            .setDuration(300)
            .setListener(null)

        LineChartRoot.slideDown(duration = 500, 0f)
    }

    override fun onBackPressed() {}
}