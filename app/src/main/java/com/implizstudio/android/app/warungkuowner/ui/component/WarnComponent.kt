package com.implizstudio.android.app.warungkuowner.ui.component

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.implizstudio.android.app.warungkuowner.R
import kotlinx.android.synthetic.main.component_warn.view.*

@SuppressLint("CustomViewStyleable")
class WarnComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes) {

    init {
        LayoutInflater.from(context).inflate(R.layout.component_warn, this, true)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.warn_component_attributes, 0, 0)
        val message = typedArray.getResourceId(R.styleable.warn_component_attributes_warnMessage, R.string.message)

        tv_warn_message.text = resources.getText(message)

        typedArray.recycle()
    }

}