package com.implizstudio.android.app.warungkuowner.ui.activity.intro

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.implizstudio.android.app.warungkuowner.R
import com.implizstudio.android.app.warungkuowner.data.model.constant.Constant
import com.implizstudio.android.app.warungkuowner.extension.startActivity
import com.implizstudio.android.app.warungkuowner.ui.activity.started.StartedActivity
import com.implizstudio.android.app.warungkuowner.ui.adapter.IntroAdapter
import com.implizstudio.android.app.warungkuowner.util.TemporarySave
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_intro.*
import javax.inject.Inject

@AndroidEntryPoint
class IntroActivity : AppCompatActivity() {

    private companion object {
        const val INTRO_SIZE = 3
    }

    private val viewModel by viewModels<IntroViewModel>()

    @Inject
    lateinit var temporarySave: TemporarySave

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        viewModel.listIntroData.observe(this, {
            vp_intro.adapter = IntroAdapter(this, it)
            di_intro.setViewPager(vp_intro)
        })

        tv_intro_skip.setOnClickListener { gotoStartedPage() }
        btn_intro_next.setOnClickListener { if (vp_intro.currentItem == 0) vp_intro.currentItem += 1 }

        vp_intro.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (position == INTRO_SIZE) {
                    btn_intro_next.let {
                        it.startAnimation(
                            AnimationUtils.loadAnimation(this@IntroActivity, R.anim.bounce)
                        )
                        it.text = getString(R.string.started)
                        it.setOnClickListener { gotoStartedPage() }
                    }
                } else
                    btn_intro_next.let {
                        it.text = getString(R.string.next)
                        it.setOnClickListener { vp_intro.currentItem += 1 }
                    }
            }

            override fun onPageScrollStateChanged(state: Int) {}

        })

    }

    private fun gotoStartedPage() {
        temporarySave.set(Constant.KEY_IS_INTRODUCED, true)

        startActivity<StartedActivity>()
        finish()
    }

}