package com.implizstudio.android.app.warungkuowner.data.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.google.gson.annotations.SerializedName

data class Store(

    @Bindable
    @SerializedName("name")
    var name: String? = null,

    @SerializedName("address")
    var address: String? = null

) : BaseObservable()