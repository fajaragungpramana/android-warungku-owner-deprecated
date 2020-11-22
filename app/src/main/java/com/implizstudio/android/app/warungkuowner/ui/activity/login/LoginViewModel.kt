package com.implizstudio.android.app.warungkuowner.ui.activity.login

import android.util.Patterns
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.implizstudio.android.app.warungkuowner.data.model.Owner
import com.implizstudio.android.app.warungkuowner.data.model.response.OwnerResponse
import com.implizstudio.android.app.warungkuowner.data.remote.ApiResult
import com.implizstudio.android.app.warungkuowner.data.repository.warungku.WarungKuRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginViewModel @ViewModelInject constructor(private val warungKuRepository: WarungKuRepository) :
    ViewModel() {

    private val _isShowProgressBar = MutableLiveData<Boolean>()
    val isShowProgressBar: LiveData<Boolean>
        get() = _isShowProgressBar

    private val _isErrorEmail = MutableLiveData<Boolean>()
    val isErrorEmail: LiveData<Boolean>
        get() = _isErrorEmail

    private val _isErrorPassword = MutableLiveData<Boolean>()
    val isErrorPassword: LiveData<Boolean>
        get() = _isErrorPassword

    private val _isEnableLogin = MutableLiveData<Boolean>()
    val isEnableLogin: LiveData<Boolean>
        get() = _isEnableLogin

    private val _responseBody = MutableLiveData<OwnerResponse>()
    val responseBody: LiveData<OwnerResponse>
        get() = _responseBody

    private val _responseCode = MutableLiveData<Int>()
    val responseCode: LiveData<Int>
        get() = _responseCode

    fun onEmailTextChanged(email: CharSequence?) {
        _isErrorEmail.value =
            email.let { it != null && !Patterns.EMAIL_ADDRESS.matcher(it).matches() }
        _isEnableLogin.value = isEnableLogin()
    }

    fun onPasswordTextChanged(password: CharSequence?) {
        _isErrorPassword.value = password.let { it != null && it.isEmpty() }
        _isEnableLogin.value = isEnableLogin()
    }

    private fun isEnableLogin() =
        _isErrorEmail.value.let { it != null && !it } && _isErrorPassword.value.let { it != null && !it }

    fun doLoginAccount(owner: Owner) {

        _isShowProgressBar.value = true
        GlobalScope.launch {

            val email = owner.email
            val password = owner.password

            when (val result = warungKuRepository.doAccountLogin(email, password)) {

                is ApiResult.Success -> {
                    _isShowProgressBar.postValue(false)
                    _responseBody.postValue(result.data)
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