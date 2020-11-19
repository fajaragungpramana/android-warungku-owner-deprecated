package com.implizstudio.android.app.warungkuowner.ui.activity.started

import android.os.Bundle
import com.implizstudio.android.app.warungkuowner.R
import com.implizstudio.android.app.warungkuowner.databinding.ActivityStartedBinding
import com.implizstudio.android.app.warungkuowner.ui.base.BaseActivity
import com.implizstudio.android.app.warungkuowner.util.EventListener

class StartedActivity : BaseActivity<ActivityStartedBinding>() {

    override fun getContentView() = R.layout.activity_started

    override fun onCreated(savedInstanceState: Bundle?) {
        getViewDataBinding().eventListener = EventListener(this)
    }

}