package com.mkdev.vpnnewdesign

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.animation.*
import com.mkdev.vpnnewdesign.base.BaseActivity
import com.mkdev.vpnnewdesign.extensionFun.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_otp_code.*
import kotlinx.android.synthetic.main.app_bar_detail.*


class MainActivity : BaseActivity() {

    private var timer: CountDownTimer? = null
    private val animationDuration = 100L
    private val lineSet = mutableSetOf(
        "label1" to 0f,
        "label2" to 0f,
        "label3" to 0f,
        "label4" to 0f,
        "label5" to 0f,
        "label6" to 0f,
        "label7" to 0f,
        "label8" to 0f,
        "label9" to 0f,
        "label10" to 0f,
        "label11" to 0f,
        "label12" to 0f,
        "label13" to 0f,
        "label14" to 0f,
        "label15" to 0f,
        "label16" to 0f,
        "label17" to 0f,
        "label18" to 0f,
        "label19" to 0f,
        "label20" to 0f
    )
    private var labelIndex: Int = 12

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

                startTimer()
            }, 1000)
        }

        mainOffAction.setOnClickListener {
            hideOffViews()
            showOnViews()
            timer?.cancel()
        }
        connectionListButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, ConnectionActivity::class.java))
        }
    }

    private fun startTimer() {
        timer = object : CountDownTimer(5 * 60 * 1000, 500) {
            override fun onTick(millisUntilFinished: Long) {
                lineSet.remove(lineSet.elementAt(1))
                val randomNumber = (0..10).random()
                Log.d("onTick", randomNumber.toString())
                lineSet.add("label${labelIndex++}" to 10.toFloat())
                lineChart.show(lineSet.toList())
            }

            override fun onFinish() {

            }
        }.start()
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

        lineChart.animate().duration = animationDuration

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
        lineChart.show(lineSet.toList())
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

    override fun onDestroy() {
        timer?.cancel()
        super.onDestroy()
    }
}