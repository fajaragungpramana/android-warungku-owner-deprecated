package com.implizstudio.android.app.warungkuowner.data.remote

sealed class ApiResult<T> {

    data class Success<T>(val data: T?) : ApiResult<T>()
    data class Failure<T>(val code: Int?) : ApiResult<T>()
    data class Error<T>(val exc: Throwable?) : ApiResult<T>()

}