package com.implizstudio.android.app.warungkuowner.data.remote

import com.implizstudio.android.app.warungkuowner.data.model.Owner
import com.implizstudio.android.app.warungkuowner.data.model.response.WarungKuResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

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

    }

}