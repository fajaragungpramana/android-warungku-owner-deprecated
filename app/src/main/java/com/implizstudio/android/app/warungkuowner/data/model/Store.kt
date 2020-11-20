package com.implizstudio.android.app.warungkuowner.data.model

import com.google.gson.annotations.SerializedName

data class Store(

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("address")
    var address: String? = null
)