package com.implizstudio.android.app.warungkuowner.util

import android.content.Context
import androidx.core.content.edit
import javax.inject.Inject

class TemporarySave @Inject constructor(context: Context) {

    private companion object {
        const val TAG = "temporary_save_warungku"
    }

    private val sharedPreferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE)

    val set: (key: String, value: Any) -> Unit = { key, value ->
        when (value) {
            is String -> sharedPreferences.edit { putString(key, value) }
            is Int -> sharedPreferences.edit { putInt(key, value) }
            is Boolean -> sharedPreferences.edit { putBoolean(key, value) }
            else -> throw TypeCastException("The data type you entered has not been recognized!")
        }
    }

    val get: (key: String, defValue: Any) -> Any? = { key, defValue ->
        when (defValue) {
            is String -> sharedPreferences.getString(key, defValue)
            is Int -> sharedPreferences.getInt(key, defValue)
            is Boolean -> sharedPreferences.getBoolean(key, defValue)
            else -> throw TypeCastException("The data type you entered has not been recognized!")
        }
    }

}