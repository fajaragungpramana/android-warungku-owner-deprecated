package com.implizstudio.android.app.warungkuowner.util

import android.content.res.Resources
import java.util.*

class Language(private val resources: Resources) {

    @Suppress("DEPRECATION")
    val setDefault: (language: String) -> Unit = {

        val locale = Locale(it)
        Locale.setDefault(locale)

        val config = resources.configuration
        config.setLocale(locale)

        resources.updateConfiguration(config, resources.displayMetrics)

    }

}