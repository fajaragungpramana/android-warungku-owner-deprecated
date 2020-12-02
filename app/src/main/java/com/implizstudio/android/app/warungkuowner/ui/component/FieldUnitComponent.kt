package com.implizstudio.android.app.warungkuowner.ui.component

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.implizstudio.android.app.warungkuowner.R
import kotlinx.android.synthetic.main.component_field_unit.view.*

@SuppressLint("CustomViewStyleable")
class FieldUnitComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyle, defStyleRes) {

    private var isUnitClicked = 0

    init {
        LayoutInflater.from(context).inflate(R.layout.component_field_unit, this, true)

        val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.field_unit_component_attributes, 0, 0)

        val unitPrimary =
            typedArray.getResourceId(
                R.styleable.field_unit_component_attributes_unitPrimary,
                R.string.unit
            )
        val unitSecondary =
            typedArray.getResourceId(
                R.styleable.field_unit_component_attributes_unitSecondary,
                R.string.unit
            )
        val unitHint =
            typedArray.getResourceId(
                R.styleable.field_unit_component_attributes_unitHint,
                R.string.unit
            )

        tv_field_unit.text = getString(unitPrimary)
        til_field_unit.hint = getString(unitHint)

        isFieldFocused(unitPrimary, unitSecondary)

        typedArray.recycle()

    }

    private fun isFieldFocused(unitPrimary: Int, unitSecondary: Int) {
        tie_field_unit.setOnFocusChangeListener { _, isFocus ->
            tv_field_unit.let {
                it.isEnabled = isFocus
                it.background =
                    if (isFocus)
                        getDrawable(R.drawable.bg_unit_focus)
                    else
                        getDrawable(R.drawable.bg_unit_un_focus)
                it.setOnClickListener { _ ->
                    isUnitClicked =
                        if (isUnitClicked == 0) {
                            it.text = getString(unitPrimary)
                            1
                        } else {
                            it.text = getString(unitSecondary)
                            0
                        }
                }
            }
        }
    }

    private fun getDrawable(resId: Int) = ContextCompat.getDrawable(context, resId)
    private fun getString(resId: Int) = resources.getString(resId)

}