package com.implizstudio.android.app.warungkuowner.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.implizstudio.android.app.warungkuowner.R
import com.implizstudio.android.app.warungkuowner.extension.invisible
import com.implizstudio.android.app.warungkuowner.extension.visible
import com.squareup.picasso.Picasso
import java.text.NumberFormat
import java.util.*

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

    @JvmStatic
    @BindingAdapter("app:currencyFormat")
    fun TextView.currencyFormat(amount: Long) {
        val format = NumberFormat.getNumberInstance(Locale.getDefault()).format(amount)
        val currency = "${resources.getString(R.string.rp)} $format"

        text = currency
    }

    @JvmStatic
    @BindingAdapter("app:imageUrl")
    fun ImageView.imageUrl(url: String) {
        Picasso.get().load(url).into(this)
    }

}