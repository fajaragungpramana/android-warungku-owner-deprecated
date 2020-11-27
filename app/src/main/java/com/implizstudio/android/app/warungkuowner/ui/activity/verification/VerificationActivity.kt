package com.implizstudio.android.app.warungkuowner.ui.activity.verification

import `in`.aabhasjindal.otptextview.OTPListener
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.implizstudio.android.app.warungkuowner.R
import com.implizstudio.android.app.warungkuowner.data.model.Owner
import com.implizstudio.android.app.warungkuowner.data.model.constant.Constant
import com.implizstudio.android.app.warungkuowner.databinding.ActivityVerificationBinding
import com.implizstudio.android.app.warungkuowner.extension.startActivity
import com.implizstudio.android.app.warungkuowner.service.CountDownService
import com.implizstudio.android.app.warungkuowner.ui.activity.main.MainActivity
import com.implizstudio.android.app.warungkuowner.ui.base.BaseActivity
import com.implizstudio.android.app.warungkuowner.util.EventListener
import com.implizstudio.android.app.warungkuowner.util.TemporarySave
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_verification.*
import javax.inject.Inject

@AndroidEntryPoint
class VerificationActivity : BaseActivity<ActivityVerificationBinding>() {

    private val viewModel by viewModels<VerificationViewModel>()

    @Inject
    lateinit var temporarySave: TemporarySave

    private val broadCastReceiver = object : BroadcastReceiver() {

        override fun onReceive(context: Context?, intent: Intent) {
            val isCountDownServiceFinished =
                intent.getBooleanExtra(Constant.KEY_COUNT_TIME_FINISHED, false)

            if (isCountDownServiceFinished) {
                stopService(Intent(context, CountDownService::class.java))
                tv_verification_count_time.let {
                    it.text = getString(R.string.resending)
                    it.setTextColor(
                        ContextCompat.getColor(
                            this@VerificationActivity,
                            R.color.color_secondary
                        )
                    )
                    it.isEnabled = true
                }
            } else {
                val millisecondsUntilFinished = intent.getLongExtra(Constant.KEY_COUNT_TIME, 0)
                val minutes = (millisecondsUntilFinished / 1000) / 60
                val seconds = (millisecondsUntilFinished / 1000) % 60

                val time = "$minutes:$seconds"
                tv_verification_count_time.let {
                    it.text = time
                    it.setTextColor(
                        ContextCompat.getColor(
                            this@VerificationActivity,
                            R.color.color_primary_divide
                        )
                    )
                    it.isEnabled = false
                }
            }
        }

    }

    override fun getContentView() = R.layout.activity_verification

    override fun onCreated(savedInstanceState: Bundle?) {
        getViewDataBinding().let {
            it.eventListener = EventListener(this)
            it.viewModel = viewModel
            it.owner = Owner(
                id = temporarySave.get(Constant.KEY_OWNER_ID, "") as String,
                email = intent.getStringExtra(Constant.KEY_OWNER_EMAIL)
            )
        }

        otv_verification.otpListener = object : OTPListener {

            override fun onInteractionListener() {
                btn_verification.let {
                    it.isEnabled = false
                    it.background = ContextCompat.getDrawable(
                        this@VerificationActivity,
                        R.drawable.bg_button_rounded_disable
                    )
                }
            }

            override fun onOTPComplete(otp: String?) {
                if (otp.let { it != null && it.length == 6 }) {
                    btn_verification.let {
                        it.isEnabled = true
                        it.background = ContextCompat.getDrawable(
                            this@VerificationActivity,
                            R.drawable.bg_button_rounded
                        )
                    }
                    getViewDataBinding().code = otp
                }

            }

        }

        viewModel.responseBody.observe(this, { getViewDataBinding().accessToken = it.token })
        viewModel.responseCode.observe(this, {
            when (it) {

                Constant.HTTP_RESPONSE_OK -> {
                    temporarySave.set(Constant.KEY_IS_LOGGED_IN, true)

                    startActivity<MainActivity>()
                    finishAffinity()
                }

                Constant.HTTP_RESPONSE_NOT_ACCEPTABLE ->
                    Toasty.error(this, getString(R.string.wrong_verification_code)).show()

                Constant.HTTP_RESPONSE_UNAUTHORIZED ->
                    Toasty.error(this, getString(R.string.verification_code_expired)).show()

            }
        })

    }

    override fun onResume() {
        super.onResume()
        registerReceiver(broadCastReceiver, IntentFilter(CountDownService.INTENT_ACTION))
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(broadCastReceiver)
    }

    override fun onDestroy() {
        stopService(Intent(this, CountDownService::class.java))
        super.onDestroy()
    }

}