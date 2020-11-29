package com.implizstudio.android.app.warungkuowner.ui.activity.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.implizstudio.android.app.warungkuowner.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}