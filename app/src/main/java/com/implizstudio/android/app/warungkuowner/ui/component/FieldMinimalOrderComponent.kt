package com.implizstudio.android.app.warungkuowner.ui.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.implizstudio.android.app.warungkuowner.R
import kotlinx.android.synthetic.main.component_field_minimal_order.view.*

class FieldMinimalOrderComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyle, defStyleRes) {

    init {
        LayoutInflater.from(context).inflate(R.layout.component_field_minimal_order, this, true)
    }

    fun setUnit(text: String) {
        tv_field_minimal_order.text = text
    }

}