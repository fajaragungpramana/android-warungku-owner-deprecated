package com.implizstudio.android.app.warungkuowner.data.local

import android.content.res.Resources
import android.content.res.TypedArray
import com.implizstudio.android.app.warungkuowner.R
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import javax.inject.Inject

class AppResource @Inject constructor(resources: Resources) {

    private val _listIntroImage = GlobalScope.async { resources.obtainTypedArray(R.array.list_intro_image) }
    val listIntroImage: Deferred<TypedArray>
        get() = _listIntroImage

    private val _listIntroTitle = GlobalScope.async { resources.getStringArray(R.array.list_intro_title) }
    val listIntroTitle: Deferred<Array<String>>
        get() = _listIntroTitle

    private val _listIntroMessage = GlobalScope.async { resources.getStringArray(R.array.list_intro_message) }
    val listIntroMessage: Deferred<Array<String>>
        get() = _listIntroMessage

}