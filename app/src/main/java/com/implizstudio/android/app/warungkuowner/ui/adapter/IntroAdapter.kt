package com.implizstudio.android.app.warungkuowner.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.implizstudio.android.app.warungkuowner.R
import com.implizstudio.android.app.warungkuowner.data.model.Intro
import com.implizstudio.android.app.warungkuowner.databinding.AdapterIntroBinding
import kotlinx.android.synthetic.main.adapter_intro.view.*

class IntroAdapter(private val context: Context, private val listIntro: List<Intro>) :
    PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any) = view == `object` as ConstraintLayout

    override fun getCount() = listIntro.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val dataBindingUtil = DataBindingUtil.inflate<AdapterIntroBinding>(
            LayoutInflater.from(context), R.layout.adapter_intro, container, false
        )

        val view = dataBindingUtil.root
        container.addView(view)

        dataBindingUtil.let {
            it.image = listIntro[position].image
            it.title = listIntro[position].title
            it.message = listIntro[position].message
        }

        view.iv_intro_image.startAnimation(AnimationUtils.loadAnimation(context, R.anim.bounce))
        view.tv_intro_title.let {
            it.alpha = 0f
            it.translationY = 100f
            it.animate().alpha(1f).translationY(0f).setStartDelay(300).setDuration(800).start()
        }
        view.tv_intro_message.let {
            it.alpha = 0f
            it.translationY = 100f
            it.animate().alpha(1f).translationY(0f).setStartDelay(600).setDuration(800).start()
        }

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }

}