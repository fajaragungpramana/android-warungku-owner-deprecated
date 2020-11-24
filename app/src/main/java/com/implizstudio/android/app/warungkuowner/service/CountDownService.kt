package com.implizstudio.android.app.warungkuowner.service

import android.app.Service
import android.content.Intent
import android.os.CountDownTimer
import android.os.IBinder
import com.implizstudio.android.app.warungkuowner.data.model.constant.Constant

class CountDownService : Service() {

    companion object {
        private const val COUNT_TIME_IN_MILLISECONDS = 60000L
        private const val TIME_IN_MILLISECONDS = 1000L
        const val INTENT_ACTION = "com.implizstudio.android.app.warungkuowner.service"
    }

    private lateinit var countDownTimer: CountDownTimer

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()

        val intent = Intent(INTENT_ACTION)

        countDownTimer = object : CountDownTimer(COUNT_TIME_IN_MILLISECONDS, TIME_IN_MILLISECONDS) {

            override fun onTick(millisecondsUntilFinished: Long) {
                intent.putExtra(Constant.KEY_COUNT_TIME, millisecondsUntilFinished)
                sendBroadcast(intent)
            }

            override fun onFinish() {
                intent.putExtra(Constant.KEY_COUNT_TIME_FINISHED, true)
                sendBroadcast(intent)
            }

        }.start()

    }

    override fun onDestroy() {
        countDownTimer.cancel()
        super.onDestroy()
    }

}