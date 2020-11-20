package com.implizstudio.android.app.warungkuowner.data.remote

import com.implizstudio.android.app.warungkuowner.data.model.response.OwnerResponse
import retrofit2.Response
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiDao {

    interface WarungKu {

        @POST
        @FormUrlEncoded
        suspend fun doAccountRegister(@FieldMap data: Pair<String, String>): Response<OwnerResponse>

    }

}