package com.implizstudio.android.app.component.field

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.implizstudio.android.app.component.R
import com.implizstudio.android.app.component.util.ResourceUtil
import kotlinx.android.synthetic.main.component_unit_field.view.*

@SuppressLint("CustomViewStyleable")
class UnitField @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyle, defStyleRes) {

    private val resource = ResourceUtil(context)
    private val unitList = mutableListOf<String>()

    private var unitHint = 0
    private var unitClickable = 0
    private var unitBackgroundFocus = 0
    private var unitBackgroundUnFocus = 0

    private var unitText = 0

    private lateinit var onSelectedUnitListener: OnSelectedUnitListener

    init {
        LayoutInflater.from(context).inflate(R.layout.component_unit_field, this, true)

        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.unitField,
            defStyle,
            defStyleRes
        )

        unitHint = typedArray.getResourceId(
            R.styleable.unitField_unitHint,
            R.string.unit
        )
        unitClickable = typedArray.getResourceId(
            R.styleable.unitField_unitClickable,
            R.bool.is_true
        )
        unitBackgroundFocus = typedArray.getResourceId(
            R.styleable.unitField_unitBackgroundFocus,
            0
        )
        unitBackgroundUnFocus = typedArray.getResourceId(
            R.styleable.unitField_unitBackgroundUnFocus,
            0
        )

        setUnitHint()
        isUnitClickable()

        typedArray.recycle()
    }

    private fun setUnitHint() {
        til_unit_field.hint = resources.getText(unitHint)
    }

    private fun isUnitClickable() {
        val isClickable = resource.getBoolean(unitClickable)

        if (isClickable)
            tie_unit_field.setOnFocusChangeListener { _, isFocus ->

                tv_unit_field.let {
                    it.isEnabled = isFocus

                    if (unitBackgroundFocus != 0 && unitBackgroundUnFocus != 0) {
                        val backgroundFocus = resource.getDrawable(unitBackgroundFocus)
                        val backgroundUnFocus = resource.getDrawable(unitBackgroundUnFocus)

                        it.setTextColor(resource.getColor(R.color.color_on_primary_light))
                        it.background = if (isFocus) backgroundFocus else backgroundUnFocus
                        it.setOnClickListener { _ ->
                            it.text = unitList[unitText]
                            unitText += 1

                            if (unitText == unitList.size) unitText = 0

                            if (::onSelectedUnitListener.isInitialized)
                                onSelectedUnitListener.getUnitText(it.text.toString())
                        }
                    } else
                        it.setOnClickListener { _ ->
                            it.text = unitList[unitText]
                            unitText += 1

                            if (unitText == unitList.size) unitText = 0

                            if (::onSelectedUnitListener.isInitialized)
                                onSelectedUnitListener.getUnitText(it.text.toString())
                        }

                }

            }
    }

    fun setUnitList(unitList: Array<out String>) {
        this.unitList.addAll(unitList)
        setOnSelectedUnitText(unitList[unitText])
    }

    fun setOnSelectedUnitText(text: String) {
        tv_unit_field.text = text
    }

    fun setOnSelectedUnitListener(onSelectedUnitListener: OnSelectedUnitListener) {
        this.onSelectedUnitListener = onSelectedUnitListener
    }

    interface OnSelectedUnitListener {
        fun getUnitText(text: String)
    }

}

