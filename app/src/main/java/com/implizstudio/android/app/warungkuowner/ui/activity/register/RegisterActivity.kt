package com.implizstudio.android.app.warungkuowner.ui.activity.register

import android.os.Bundle
import com.implizstudio.android.app.warungkuowner.R
import com.implizstudio.android.app.warungkuowner.databinding.ActivityRegisterBinding
import com.implizstudio.android.app.warungkuowner.ui.base.BaseActivity
import com.implizstudio.android.app.warungkuowner.util.EventListener

class RegisterActivity : BaseActivity<ActivityRegisterBinding>() {

    override fun getContentView() = R.layout.activity_register

    override fun onCreated(savedInstanceState: Bundle?) {
        getViewDataBinding().eventListener = EventListener(this)
    }

}