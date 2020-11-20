package com.implizstudio.android.app.warungkuowner.data.model

import com.google.gson.annotations.SerializedName

data class Owner(

    @SerializedName("id")
    var id: String? = null,

    @SerializedName("photo")
    var photo: String? = null,

    @SerializedName("full_name")
    var fullName: String? = null,

    @SerializedName("address")
    var address: String? = null

)