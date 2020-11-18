package com.implizstudio.android.app.warungkuowner.data.repository

import com.implizstudio.android.app.warungkuowner.data.local.AppResource

class AppResourceRepositoryImpl(private val appResource: AppResource) : AppResourceRepository {

    override suspend fun getListIntroImage() = appResource.listIntroImage.await()

    override suspend fun getListIntroTitle() = appResource.listIntroTitle.await()

    override suspend fun getListIntroMessage() = appResource.listIntroMessage.await()

}