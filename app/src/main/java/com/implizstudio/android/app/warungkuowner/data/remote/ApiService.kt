package com.implizstudio.android.app.warungkuowner.data.remote

import com.implizstudio.android.app.warungkuowner.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private val httpLoggingInterceptor: () -> HttpLoggingInterceptor = {
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    fun createWarungKuService(): ApiDao.WarungKu {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor())
                    .addInterceptor {
                        it.proceed(
                            it.request().newBuilder()
                                .addHeader("access_key_owner", BuildConfig.ACCESS_KEY_OWNER)
                                .build()
                        )
                    }
                    .build()
            )
            .build()

        return retrofit.create(ApiDao.WarungKu::class.java)
    }

}