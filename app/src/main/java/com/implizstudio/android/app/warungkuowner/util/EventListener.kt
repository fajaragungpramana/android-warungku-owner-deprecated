package com.implizstudio.android.app.warungkuowner.util

import android.app.Activity
import android.content.Context
import com.implizstudio.android.app.warungkuowner.extension.startActivity
import com.implizstudio.android.app.warungkuowner.ui.activity.login.LoginActivity
import javax.inject.Inject

class EventListener @Inject constructor(private val context: Context) {

    fun destroyPage() {
        context as Activity
        context.finish()
    }

    fun gotoLoginPage() {
        context.startActivity<LoginActivity>()
    }

}