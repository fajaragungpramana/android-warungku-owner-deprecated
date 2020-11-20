package com.implizstudio.android.app.warungkuowner.data.model.response

import com.google.gson.annotations.SerializedName
import com.implizstudio.android.app.warungkuowner.data.model.Owner

data class OwnerResponse(

    @SerializedName("data")
    var data: Owner? = null

)