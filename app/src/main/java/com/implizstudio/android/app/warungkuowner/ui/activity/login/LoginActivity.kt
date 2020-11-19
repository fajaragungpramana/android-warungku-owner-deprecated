package com.implizstudio.android.app.warungkuowner.ui.activity.login

import android.os.Bundle
import com.implizstudio.android.app.warungkuowner.R
import com.implizstudio.android.app.warungkuowner.databinding.ActivityLoginBinding
import com.implizstudio.android.app.warungkuowner.ui.base.BaseActivity
import com.implizstudio.android.app.warungkuowner.util.EventListener

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    override fun getContentView() = R.layout.activity_login

    override fun onCreated(savedInstanceState: Bundle?) {
        getViewDataBinding().eventListener = EventListener(this)
    }

}