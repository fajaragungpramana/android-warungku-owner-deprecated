package com.implizstudio.android.app.warungkuowner.data.repository.warungku

import com.implizstudio.android.app.warungkuowner.data.model.response.OwnerResponse
import com.implizstudio.android.app.warungkuowner.data.remote.ApiResult

interface WarungKuRepository {

    suspend fun doAccountRegister(data: MutableMap<String, String?>) : ApiResult<OwnerResponse>

    suspend fun doAccountLogin(email: String?, password: String?) : ApiResult<OwnerResponse>

}