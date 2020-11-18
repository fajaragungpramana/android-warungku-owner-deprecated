package com.implizstudio.android.app.warungkuowner.ui.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("app:imageSrc")
    fun ImageView.imageSrc(id: Int) {
        setImageResource(id)
    }

}