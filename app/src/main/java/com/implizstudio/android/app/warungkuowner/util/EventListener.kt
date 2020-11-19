package com.implizstudio.android.app.warungkuowner.util

import android.app.Activity
import android.content.Context
import com.implizstudio.android.app.warungkuowner.extension.startActivity
import com.implizstudio.android.app.warungkuowner.ui.activity.login.LoginActivity
import com.implizstudio.android.app.warungkuowner.ui.activity.register.RegisterActivity
import javax.inject.Inject

class EventListener @Inject constructor(private val context: Context) {

    fun destroyPage() {
        context as Activity
        context.finish()
    }

    fun gotoLoginPage() {
        context.startActivity<LoginActivity>()
    }

    fun gotoRegisterPage() {
        context.startActivity<RegisterActivity>()
    }

}