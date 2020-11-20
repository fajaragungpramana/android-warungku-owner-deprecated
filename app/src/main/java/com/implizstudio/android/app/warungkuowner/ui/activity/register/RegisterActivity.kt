package com.implizstudio.android.app.warungkuowner.ui.activity.register

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.implizstudio.android.app.warungkuowner.R
import com.implizstudio.android.app.warungkuowner.data.model.Owner
import com.implizstudio.android.app.warungkuowner.data.model.Store
import com.implizstudio.android.app.warungkuowner.data.model.constant.Constant
import com.implizstudio.android.app.warungkuowner.databinding.ActivityRegisterBinding
import com.implizstudio.android.app.warungkuowner.extension.startActivity
import com.implizstudio.android.app.warungkuowner.ui.activity.verification.VerificationActivity
import com.implizstudio.android.app.warungkuowner.ui.base.BaseActivity
import com.implizstudio.android.app.warungkuowner.util.EventListener
import com.implizstudio.android.app.warungkuowner.util.TemporarySave
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

@AndroidEntryPoint
class RegisterActivity : BaseActivity<ActivityRegisterBinding>() {

    private val viewModel by viewModels<RegisterViewModel>()

    @Inject
    lateinit var temporarySave: TemporarySave

    override fun getContentView() = R.layout.activity_register

    override fun onCreated(savedInstanceState: Bundle?) {
        getViewDataBinding().let {
            it.eventListener = EventListener(this)
            it.viewModel = viewModel
            it.owner = Owner()
            it.store = Store()
        }

        viewModel.isErrorName.observe(this, {
            til_register_name.error =
                if (it) getString(R.string.error_text_changed_full_name) else null
        })
        viewModel.isErrorStoreName.observe(this, {
            til_register_store.error =
                if (it) getString(R.string.error_text_changed_store) else null
        })
        viewModel.isErrorEmail.observe(this, {
            til_register_email.error =
                if (it) getString(R.string.error_text_changed_email) else null
        })
        viewModel.isErrorPassword.observe(this, {
            til_register_password.error =
                if (it) getString(R.string.error_text_changed_password) else null
        })
        viewModel.isEnableRegister.observe(this, {
            btn_register.isEnabled = it
            btn_register.background =
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
                Constant.HTTP_RESPONSE_CREATED -> startActivity<VerificationActivity>()

                Constant.HTTP_RESPONSE_NOT_ACCEPTABLE -> til_register_email.error =
                    getString(R.string.error_text_changed_account_already_registered)
            }
        })

    }

}