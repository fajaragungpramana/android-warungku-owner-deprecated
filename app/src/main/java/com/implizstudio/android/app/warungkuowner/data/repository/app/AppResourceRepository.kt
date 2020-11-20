package com.implizstudio.android.app.warungkuowner.data.repository.app

import android.content.res.TypedArray

interface AppResourceRepository {

    suspend fun getListIntroImage(): TypedArray

    suspend fun getListIntroTitle(): Array<String>

    suspend fun getListIntroMessage(): Array<String>

}