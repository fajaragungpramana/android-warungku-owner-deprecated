package com.implizstudio.android.app.warungkuowner.extension

import android.content.Context
import android.content.Intent
import android.os.Parcelable

@Suppress("UNCHECKED_CAST")
inline fun <reified T> Context.startActivity(vararg listData: Pair<String, Any>){
    val intent = Intent(this, T::class.java)

    if (listData.isNotEmpty())
        listData.forEach {
            when (it.second) {
                is String -> intent.putExtra(it.first, it.second as String)
                is Int -> intent.putExtra(it.first, it.second as Int)
                is Boolean -> intent.putExtra(it.first, it.second as Boolean)
                is Parcelable -> intent.putParcelableArrayListExtra(it.first, it.second as ArrayList<Parcelable>)
                else -> throw TypeCastException("The data type you entered has not been recognized!")
            }
        }

    startActivity(intent)
}