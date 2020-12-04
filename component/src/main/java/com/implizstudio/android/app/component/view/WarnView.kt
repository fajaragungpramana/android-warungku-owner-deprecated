package com.implizstudio.android.app.component.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.implizstudio.android.app.component.R
import kotlinx.android.synthetic.main.component_warn_view.view.*

@SuppressLint("CustomViewStyleable")
class WarnView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes) {

    init {
        LayoutInflater.from(context).inflate(R.layout.component_warn_view, this, true)

        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.warnView,
            defStyle,
            defStyleRes
        )
        val warnMessage = typedArray.getResourceId(
            R.styleable.warnView_warnMessage,
            R.string.message
        )

        tv_warn_message.setText(warnMessage)

        typedArray.recycle()

    }

}