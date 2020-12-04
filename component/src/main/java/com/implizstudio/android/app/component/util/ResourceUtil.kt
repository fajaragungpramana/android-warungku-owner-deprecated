package com.implizstudio.android.app.component.util

import android.content.Context
import androidx.core.content.ContextCompat

class ResourceUtil(private val context: Context) {

    fun getString(resId: Int) = context.resources.getString(resId)

    fun getDrawable(resId: Int) = ContextCompat.getDrawable(context, resId)

    fun getBoolean(resId: Int) = context.resources.getBoolean(resId)

    fun getColor(resId: Int) = ContextCompat.getColor(context, resId)

}