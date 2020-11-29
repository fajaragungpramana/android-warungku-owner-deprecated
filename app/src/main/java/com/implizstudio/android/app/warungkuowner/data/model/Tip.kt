package com.implizstudio.android.app.warungkuowner.data.model

import com.google.gson.annotations.SerializedName

data class Tip(

    @SerializedName("image")
    var image: String? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("body")
    var body: String? = null

)