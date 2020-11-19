package com.implizstudio.android.app.warungkuowner.ui.activity.started

import android.os.Bundle
import com.implizstudio.android.app.warungkuowner.R
import com.implizstudio.android.app.warungkuowner.databinding.ActivityStartedBinding
import com.implizstudio.android.app.warungkuowner.ui.base.BaseActivity
import com.implizstudio.android.app.warungkuowner.ui.sheet.ConditionSheet
import com.implizstudio.android.app.warungkuowner.util.EventListener
import kotlinx.android.synthetic.main.activity_started.*

class StartedActivity : BaseActivity<ActivityStartedBinding>() {

    override fun getContentView() = R.layout.activity_started

    override fun onCreated(savedInstanceState: Bundle?) {
        getViewDataBinding().eventListener = EventListener(this)

        iv_started_info.setOnClickListener {
            ConditionSheet().show(supportFragmentManager, null)
        }

    }

}