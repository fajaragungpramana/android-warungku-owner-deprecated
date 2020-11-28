package com.implizstudio.android.app.warungkuowner.ui.component

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.implizstudio.android.app.warungkuowner.R
import kotlinx.android.synthetic.main.component_feature.view.*

@SuppressLint("CustomViewStyleable")
class FeatureComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes) {

    init {
        LayoutInflater.from(context).inflate(R.layout.component_feature, this, true)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.feature_component_attributes, 0, 0)

        val icon = typedArray.getResourceId(R.styleable.feature_component_attributes_featureIcon, 0)
        val title = typedArray.getResourceId(R.styleable.feature_component_attributes_featureTitle, R.string.title)

        iv_feature_icon.setImageResource(icon)
        tv_feature_title.text = resources.getText(title)

        typedArray.recycle()
    }

}