package com.implizstudio.android.app.warungkuowner.data.model

import com.google.gson.annotations.SerializedName

data class ReportResult(

    @SerializedName("income")
    var income: Long? = null,

    @SerializedName("net_income")
    var netIncome: Long? = null,

    @SerializedName("percentage")
    var percentage: String? = null

)