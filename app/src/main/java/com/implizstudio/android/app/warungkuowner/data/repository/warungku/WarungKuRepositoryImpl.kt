package com.implizstudio.android.app.warungkuowner.data.repository.warungku

import com.implizstudio.android.app.warungkuowner.data.model.Owner
import com.implizstudio.android.app.warungkuowner.data.model.ReportResult
import com.implizstudio.android.app.warungkuowner.data.model.Tip
import com.implizstudio.android.app.warungkuowner.data.model.Verification
import com.implizstudio.android.app.warungkuowner.data.model.response.WarungKuResponse
import com.implizstudio.android.app.warungkuowner.data.remote.ApiDao
import com.implizstudio.android.app.warungkuowner.data.remote.ApiResult
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class WarungKuRepositoryImpl(private val warungKuDao: ApiDao.WarungKu) : WarungKuRepository {

    override suspend fun doAccountRegister(data: MutableMap<String, String?>): ApiResult<WarungKuResponse.Data<Owner>> =
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
    ): ApiResult<WarungKuResponse.Data<Owner>> =
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

    override suspend fun getVerificationCode(
        accountId: String?,
        accountEmail: String?
    ): ApiResult<WarungKuResponse.Data<Verification>> =
        try {

            val response = GlobalScope.async {
                warungKuDao.getVerificationCode(accountId, accountEmail)
            }
            val result = response.await()

            if (result.isSuccessful)
                ApiResult.Success(result.body(), result.code())
            else
                ApiResult.Failure(result.code())

        } catch (exc: Throwable) {
            ApiResult.Error(exc)
        }

    override suspend fun doAccountVerification(
        accessToken: String?,
        accountId: String?,
        accountCode: Int?
    ): ApiResult<WarungKuResponse.Data<Any>> =
        try {

            val response = GlobalScope.async {
                warungKuDao.doAccountVerification(accessToken, accountId, accountCode)
            }
            val result = response.await()

            if (result.isSuccessful)
                ApiResult.Success(result.body(), result.code())
            else
                ApiResult.Failure(result.code())

        } catch (exc: Throwable) {
            ApiResult.Error(exc)
        }

    override suspend fun getReportToday(accountId: String?): ApiResult<WarungKuResponse.Data<ReportResult>> =
        try {

            val response = GlobalScope.async { warungKuDao.getReportToday(accountId) }
            val result = response.await()

            if (result.isSuccessful)
                ApiResult.Success(result.body(), result.code())
            else
                ApiResult.Failure(result.code())

        } catch (exc: Throwable) {
            ApiResult.Error(exc)
        }

    override suspend fun getTip(category: String?): ApiResult<WarungKuResponse.Data<List<Tip>>> =
        try {

            val response = GlobalScope.async { warungKuDao.getTip(category) }
            val result = response.await()

            if (result.isSuccessful)
                ApiResult.Success(result.body(), result.code())
            else
                ApiResult.Failure(result.code())

        } catch (exc: Throwable) {
            ApiResult.Error(exc)
        }

}