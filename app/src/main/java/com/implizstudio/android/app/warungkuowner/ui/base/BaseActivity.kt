package com.implizstudio.android.app.warungkuowner.ui.base

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.implizstudio.android.app.warungkuowner.util.Language

abstract class BaseActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)

        Language(resources).setDefault("en_US")

    }

}