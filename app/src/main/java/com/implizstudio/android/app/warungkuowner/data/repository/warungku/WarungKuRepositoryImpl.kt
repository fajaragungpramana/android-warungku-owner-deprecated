package com.implizstudio.android.app.warungkuowner.data.repository.warungku

import com.implizstudio.android.app.warungkuowner.data.model.response.OwnerResponse
import com.implizstudio.android.app.warungkuowner.data.remote.ApiDao
import com.implizstudio.android.app.warungkuowner.data.remote.ApiResult
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class WarungKuRepositoryImpl(private val warungKuDao: ApiDao.WarungKu) : WarungKuRepository {

    override suspend fun doAccountRegister(data: MutableMap<String, String?>): ApiResult<OwnerResponse> =
        try {

            val response = GlobalScope.async { warungKuDao.doAccountRegister(data) }
            val result = response.await()

            if (result.isSuccessful)
                ApiResult.Success(result.body(), result.code())
            else
                ApiResult.Failure(result.code())

        } catch (exc: Throwable) {
            ApiResult.Error(exc)
        }

    override suspend fun doAccountLogin(
        email: String?,
        password: String?
    ): ApiResult<OwnerResponse> =
        try {

            val response = GlobalScope.async { warungKuDao.doAccountLogin(email, password) }
            val result = response.await()

            if (result.isSuccessful)
                ApiResult.Success(result.body(), result.code())
            else
                ApiResult.Failure(result.code())

        } catch (exc: Throwable) {
            ApiResult.Error(exc)
        }

}