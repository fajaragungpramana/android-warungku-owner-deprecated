package com.implizstudio.android.app.warungkuowner.ui.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.implizstudio.android.app.warungkuowner.util.Language

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    private lateinit var viewDataBinding: T

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        Language(resources).setDefault("in")
    }

    abstract fun getContentView(): Int

    abstract fun onCreated(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding = DataBindingUtil.setContentView<T>(this, getContentView()).apply {
            lifecycleOwner = this@BaseActivity
        }

        onCreated(savedInstanceState)

    }

    protected fun getViewDataBinding() = viewDataBinding

}