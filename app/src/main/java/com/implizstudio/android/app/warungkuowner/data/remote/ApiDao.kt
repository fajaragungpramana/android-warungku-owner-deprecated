package com.implizstudio.android.app.warungkuowner.data.remote

import com.implizstudio.android.app.warungkuowner.data.model.Owner
import com.implizstudio.android.app.warungkuowner.data.model.Verification
import com.implizstudio.android.app.warungkuowner.data.model.response.WarungKuResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiDao {

    interface WarungKu {

        @POST("owner/auth/register")
        @FormUrlEncoded
        suspend fun doAccountRegister(@FieldMap data: MutableMap<String, String?>): Response<WarungKuResponse.Data<Owner>>

        @POST("owner/auth/login")
        @FormUrlEncoded
        suspend fun doAccountLogin(
            @Field("email") email: String?,
            @Field("password") password: String?
        ): Response<WarungKuResponse.Data<Owner>>

        @GET("owner/auth/code")
        suspend fun doSendVerificationCode(
            @Query("account_id") accountId: String?,
            @Query("account_email") accountEmail: String?
        ): Response<WarungKuResponse.Data<Verification>>

    }

}