package com.implizstudio.android.app.warungkuowner.ui.activity.verification

import android.content.Context
import android.content.Intent
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.implizstudio.android.app.warungkuowner.data.model.Owner
import com.implizstudio.android.app.warungkuowner.data.model.Verification
import com.implizstudio.android.app.warungkuowner.data.remote.ApiResult
import com.implizstudio.android.app.warungkuowner.data.repository.warungku.WarungKuRepository
import com.implizstudio.android.app.warungkuowner.service.CountDownService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class VerificationViewModel @ViewModelInject constructor(
    private val context: Context, private val warungKuRepository: WarungKuRepository
) : ViewModel() {

    private val _isShowProgressBar = MutableLiveData<Boolean>()
    val isShowProgressBar: LiveData<Boolean>
        get() = _isShowProgressBar

    private val _responseBody = MutableLiveData<Verification>()
    val responseBody: LiveData<Verification>
        get() = _responseBody

    private val _responseCode = MutableLiveData<Int>()
    val responseCode: LiveData<Int>
        get() = _responseCode

    fun doSendVerificationCode(owner: Owner) {
        context.startService(Intent(context, CountDownService::class.java))

        _isShowProgressBar.value = true
        GlobalScope.launch {

            when (val result = warungKuRepository.doSendVerificationCode(owner.id, owner.email)) {

                is ApiResult.Success -> {
                    _isShowProgressBar.postValue(false)
                    _responseBody.postValue(result.data?.data)
                }

                is ApiResult.Failure ->
                    _isShowProgressBar.postValue(false)

                is ApiResult.Error ->
                    _isShowProgressBar.postValue(false)

            }

        }
    }

    fun doAccountVerification(accessToken: String?, accountId: String?, code: String?) {
        _isShowProgressBar.value = true
        GlobalScope.launch {

            when (val result = warungKuRepository.doAccountVerification(accessToken, accountId, code?.toInt())) {

                is ApiResult.Success -> {
                    _isShowProgressBar.postValue(false)
                    _responseCode.postValue(result.code)
                }

                is ApiResult.Failure -> {
                    _isShowProgressBar.postValue(false)
                    _responseCode.postValue(result.code)
                }

                is ApiResult.Error ->
                    _isShowProgressBar.postValue(false)

            }

        }

    }

}