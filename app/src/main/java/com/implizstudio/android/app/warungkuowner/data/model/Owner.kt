package com.implizstudio.android.app.warungkuowner.data.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.google.gson.annotations.SerializedName

data class Owner(

    @SerializedName("id")
    var id: String? = null,

    @SerializedName("photo")
    var photo: String? = null,

    @Bindable
    @SerializedName("full_name")
    var fullName: String? = null,

    @SerializedName("address")
    var address: String? = null,

    @Bindable
    @SerializedName("email")
    var email: String? = null,

    @Bindable
    @SerializedName("password")
    var password: String? = null

) : BaseObservable()