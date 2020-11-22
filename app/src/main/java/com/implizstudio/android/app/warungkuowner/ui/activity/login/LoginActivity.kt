package com.implizstudio.android.app.warungkuowner.ui.activity.login

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.implizstudio.android.app.warungkuowner.R
import com.implizstudio.android.app.warungkuowner.data.model.Owner
import com.implizstudio.android.app.warungkuowner.data.model.constant.Constant
import com.implizstudio.android.app.warungkuowner.databinding.ActivityLoginBinding
import com.implizstudio.android.app.warungkuowner.extension.startActivity
import com.implizstudio.android.app.warungkuowner.ui.activity.verification.VerificationActivity
import com.implizstudio.android.app.warungkuowner.ui.base.BaseActivity
import com.implizstudio.android.app.warungkuowner.util.EventListener
import com.implizstudio.android.app.warungkuowner.util.TemporarySave
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    private val viewModel by viewModels<LoginViewModel>()

    @Inject
    lateinit var temporarySave: TemporarySave

    override fun getContentView() = R.layout.activity_login

    override fun onCreated(savedInstanceState: Bundle?) {
        getViewDataBinding().let {
            it.eventListener = EventListener(this)
            it.viewModel = viewModel
            it.owner = Owner()
        }

        viewModel.isErrorEmail.observe(this, {
            til_login_email.error = if (it) getString(R.string.error_text_changed_email) else null
        })
        viewModel.isErrorPassword.observe(this, {
            til_login_password.error =
                if (it) getString(R.string.error_text_changed_password_empty) else null
        })
        viewModel.isEnableLogin.observe(this, {
            btn_login.isEnabled = it
            btn_login.background =
                if (it)
                    ContextCompat.getDrawable(this, R.drawable.bg_button_rounded)
                else
                    ContextCompat.getDrawable(this, R.drawable.bg_button_rounded_disable)
        })
        viewModel.responseBody.observe(this, {
            temporarySave.set(Constant.KEY_OWNER_ID, it.data?.id.toString())
        })
        viewModel.responseCode.observe(this, {
            when (it) {
                Constant.HTTP_RESPONSE_OK -> {
                }

                Constant.HTTP_RESPONSE_NOT_FOUND -> til_login_email.error =
                    getString(R.string.error_text_changed_account_is_not_registered)

                Constant.HTTP_RESPONSE_NOT_ACCEPTABLE -> til_login_password.error =
                    getString(R.string.error_text_changed_wrong_password)

                Constant.HTTP_RESPONSE_UNAUTHORIZED -> startActivity<VerificationActivity>()

            }
        })

    }

}