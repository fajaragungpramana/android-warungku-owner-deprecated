package com.implizstudio.android.app.warungkuowner.data.repository.warungku

import com.implizstudio.android.app.warungkuowner.data.model.response.OwnerResponse
import com.implizstudio.android.app.warungkuowner.data.remote.ApiDao
import com.implizstudio.android.app.warungkuowner.data.remote.ApiResult
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class WarungKuRepositoryImpl(private val warungKuDao: ApiDao.WarungKu) : WarungKuRepository {

    override suspend fun doAccountRegister(data: Pair<String, String>): ApiResult<OwnerResponse> =
        try {

            val response = GlobalScope.async { warungKuDao.doAccountRegister(data) }
            val result = response.await()

            if (result.isSuccessful)
                ApiResult.Success(result.body())
            else
                ApiResult.Failure(result.code())

        } catch (exc: Throwable) {
            ApiResult.Error(exc)
        }

}