package com.implizstudio.android.app.warungkuowner.ui.activity.verification

import android.os.Bundle
import com.implizstudio.android.app.warungkuowner.R
import com.implizstudio.android.app.warungkuowner.databinding.ActivityVerificationBinding
import com.implizstudio.android.app.warungkuowner.ui.base.BaseActivity
import com.implizstudio.android.app.warungkuowner.util.EventListener

class VerificationActivity : BaseActivity<ActivityVerificationBinding>() {

    override fun getContentView() = R.layout.activity_verification

    override fun onCreated(savedInstanceState: Bundle?) {
        getViewDataBinding().eventListener = EventListener(this)
    }

}