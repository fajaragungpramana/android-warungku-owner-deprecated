package com.implizstudio.android.app.warungkuowner.ui.activity.register

import android.util.Patterns
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.implizstudio.android.app.warungkuowner.data.model.Owner
import com.implizstudio.android.app.warungkuowner.data.model.Store
import com.implizstudio.android.app.warungkuowner.data.remote.ApiResult
import com.implizstudio.android.app.warungkuowner.data.repository.warungku.WarungKuRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterViewModel @ViewModelInject constructor(private val warungKuRepository: WarungKuRepository) :
    ViewModel() {

    private val _isShowProgressBar = MutableLiveData<Boolean>()
    val isShowProgressBar: LiveData<Boolean>
        get() = _isShowProgressBar

    private val _isErrorName = MutableLiveData<Boolean>()
    val isErrorName: LiveData<Boolean>
        get() = _isErrorName

    private val _isErrorStoreName = MutableLiveData<Boolean>()
    val isErrorStoreName: LiveData<Boolean>
        get() = _isErrorStoreName

    private val _isErrorEmail = MutableLiveData<Boolean>()
    val isErrorEmail: LiveData<Boolean>
        get() = _isErrorEmail

    private val _isErrorPassword = MutableLiveData<Boolean>()
    val isErrorPassword: LiveData<Boolean>
        get() = _isErrorPassword

    private val _isEnableRegister = MutableLiveData<Boolean>()
    val isEnableRegister: LiveData<Boolean>
        get() = _isEnableRegister

    fun onNameTextChanged(name: CharSequence?) {
        _isErrorName.value = name.let { it != null && it.length < 4 }
        _isEnableRegister.value = isEnableRegister()
    }

    fun onStoreNameTextChanged(name: CharSequence?) {
        _isErrorStoreName.value = name.let { it != null && it.length < 4 }
        _isEnableRegister.value = isEnableRegister()
    }

    fun onEmailTextChanged(email: CharSequence?) {
        _isErrorEmail.value =
            email.let { it != null && !Patterns.EMAIL_ADDRESS.matcher(it).matches() }
        _isEnableRegister.value = isEnableRegister()
    }

    fun onPasswordTextChanged(password: CharSequence?) {
        _isErrorPassword.value = password.let { it != null && it.length < 8 }
        _isEnableRegister.value = isEnableRegister()
    }

    private fun isEnableRegister() =
        _isErrorName.value.let { it != null && !it } &&
                _isErrorStoreName.value.let { it != null && !it } &&
                _isErrorEmail.value.let { it != null && !it } &&
                _isErrorPassword.value.let { it != null && !it }

    fun doRegisterAccount(owner: Owner, store: Store) {

        _isShowProgressBar.value = true
        GlobalScope.launch {

            val data = mutableMapOf(
                "full_name" to owner.fullName,
                "store_name" to store.name,
                "email" to owner.email,
                "password" to owner.password
            )

            when (val result = warungKuRepository.doAccountRegister(data)) {

                is ApiResult.Success -> {
                    _isShowProgressBar.postValue(false)
                }

                is ApiResult.Failure -> {
                    _isShowProgressBar.postValue(false)
                }

                is ApiResult.Error -> {
                    _isShowProgressBar.postValue(false)
                }

            }

        }

    }

}