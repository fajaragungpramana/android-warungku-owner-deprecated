package com.implizstudio.android.app.warungkuowner.data.model

import com.google.gson.annotations.SerializedName

data class Verification(

    @SerializedName("access_token")
    var accessToken: String? = null

)