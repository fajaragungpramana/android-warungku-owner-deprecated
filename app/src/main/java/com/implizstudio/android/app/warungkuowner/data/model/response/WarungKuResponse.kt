package com.implizstudio.android.app.warungkuowner.data.model.response

import com.google.gson.annotations.SerializedName

sealed class WarungKuResponse() {

    data class Data<T>(@SerializedName("data") var data: T? = null) : WarungKuResponse()

}