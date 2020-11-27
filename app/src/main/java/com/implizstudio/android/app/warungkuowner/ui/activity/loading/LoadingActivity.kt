package com.implizstudio.android.app.warungkuowner.ui.activity.loading

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.implizstudio.android.app.warungkuowner.R
import com.implizstudio.android.app.warungkuowner.data.model.constant.Constant
import com.implizstudio.android.app.warungkuowner.extension.startActivity
import com.implizstudio.android.app.warungkuowner.ui.activity.intro.IntroActivity
import com.implizstudio.android.app.warungkuowner.ui.activity.main.MainActivity
import com.implizstudio.android.app.warungkuowner.ui.activity.started.StartedActivity
import com.implizstudio.android.app.warungkuowner.util.TemporarySave
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoadingActivity : AppCompatActivity() {

    private companion object {
        const val LOADING_TIME = 3000L
    }

    @Inject lateinit var temporarySave: TemporarySave

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        Handler(Looper.getMainLooper()).postDelayed({

            if (temporarySave.get(Constant.KEY_IS_INTRODUCED, false) as Boolean)
                if (temporarySave.get(Constant.KEY_IS_LOGGED_IN, false) as Boolean)
                    startActivity<MainActivity>()
                else
                    startActivity<StartedActivity>()
            else
                startActivity<IntroActivity>()

            finish()

        }, LOADING_TIME)

    }

}