package com.implizstudio.android.app.warungkuowner.ui.fragment.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.implizstudio.android.app.warungkuowner.data.model.ReportResult
import com.implizstudio.android.app.warungkuowner.data.model.Tip
import com.implizstudio.android.app.warungkuowner.data.remote.ApiResult
import com.implizstudio.android.app.warungkuowner.data.repository.warungku.WarungKuRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(private val warungKuRepository: WarungKuRepository) :
    ViewModel() {

    private val _isShowProgressBar = MutableLiveData<Boolean>()
    val isShowProgressBar: LiveData<Boolean>
        get() = _isShowProgressBar

    private val _isRefreshing = MutableLiveData<Boolean>()
    val isRefreshing: LiveData<Boolean>
        get() {

            loadReportToday()
            loadTip()

            return _isRefreshing
        }


    private var accountId: String? = null
    private var category: String? = null

    private val _reportToday = MutableLiveData<ReportResult>()
    fun reportToday(accountId: String?): LiveData<ReportResult> {
        this.accountId = accountId

        loadReportToday()

        return _reportToday
    }

    private fun loadReportToday() {
        _isShowProgressBar.value = true
        GlobalScope.launch {

            when (val response = warungKuRepository.getReportToday(accountId)) {

                is ApiResult.Success -> {
                    _isShowProgressBar.postValue(false)
                    _isRefreshing.postValue(false)
                    _reportToday.postValue(response.data?.data)
                }

                is ApiResult.Failure -> {
                    _isShowProgressBar.postValue(false)
                    _isRefreshing.postValue(false)
                }

                is ApiResult.Error -> {
                    _isShowProgressBar.postValue(false)
                    _isRefreshing.postValue(false)
                }

            }

        }
    }

    private val _tip = MutableLiveData<List<Tip>>()
    fun getTip(category: String?): LiveData<List<Tip>> {
        this.category = category

        loadTip()

        return _tip
    }

    private fun loadTip() {
        _isShowProgressBar.value = true
        GlobalScope.launch {

            when (val response = warungKuRepository.getTip(category)) {

                is ApiResult.Success -> {
                    _isShowProgressBar.postValue(false)
                    _isRefreshing.postValue(false)
                    _tip.postValue(response.data?.data)
                }

                is ApiResult.Failure -> {
                    _isShowProgressBar.postValue(false)
                    _isRefreshing.postValue(false)
                }

                is ApiResult.Error -> {
                    _isShowProgressBar.postValue(false)
                    _isRefreshing.postValue(false)
                }

            }

        }
    }

}