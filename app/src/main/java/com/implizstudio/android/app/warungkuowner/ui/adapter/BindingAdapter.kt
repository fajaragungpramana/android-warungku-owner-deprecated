package com.implizstudio.android.app.warungkuowner.ui.adapter

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.implizstudio.android.app.warungkuowner.extension.invisible
import com.implizstudio.android.app.warungkuowner.extension.visible

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("app:imageSrc")
    fun ImageView.imageSrc(id: Int) {
        setImageResource(id)
    }

    @JvmStatic
    @BindingAdapter("app:isShowed")
    fun View.isShowed(isShowed: Boolean) {
        if (isShowed) visible() else invisible()
    }

}