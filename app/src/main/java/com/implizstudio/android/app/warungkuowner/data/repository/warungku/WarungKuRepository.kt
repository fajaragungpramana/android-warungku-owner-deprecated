package com.implizstudio.android.app.warungkuowner.data.repository.warungku

import com.implizstudio.android.app.warungkuowner.data.model.Owner
import com.implizstudio.android.app.warungkuowner.data.model.Verification
import com.implizstudio.android.app.warungkuowner.data.model.response.WarungKuResponse
import com.implizstudio.android.app.warungkuowner.data.remote.ApiResult

interface WarungKuRepository {

    suspend fun doAccountRegister(data: MutableMap<String, String?>): ApiResult<WarungKuResponse.Data<Owner>>

    suspend fun doAccountLogin(
        email: String?,
        password: String?
    ): ApiResult<WarungKuResponse.Data<Owner>>

    suspend fun doSendVerificationCode(
        accountId: String?,
        accountEmail: String?
    ): ApiResult<WarungKuResponse.Data<Verification>>

    suspend fun doAccountVerification(
        accessToken: String?,
        accountId: String?,
        accountCode: Int?
    ): ApiResult<WarungKuResponse.Data<Any>>

}