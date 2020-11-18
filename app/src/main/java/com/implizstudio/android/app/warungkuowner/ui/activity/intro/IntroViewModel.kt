package com.implizstudio.android.app.warungkuowner.ui.activity.intro

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.implizstudio.android.app.warungkuowner.data.model.Intro
import com.implizstudio.android.app.warungkuowner.data.repository.AppResourceRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class IntroViewModel @ViewModelInject constructor(private val appResourceRepository: AppResourceRepository) :
    ViewModel() {

    private val listIntro = mutableListOf<Intro>()

    private val _listIntroData = MutableLiveData<List<Intro>>()
    val listIntroData: LiveData<List<Intro>>
        get() {

            GlobalScope.launch {
                for (index in appResourceRepository.getListIntroTitle().indices)
                    listIntro.add(
                        Intro(
                            appResourceRepository.getListIntroImage().getResourceId(index, 0),
                            appResourceRepository.getListIntroTitle()[index],
                            appResourceRepository.getListIntroMessage()[index]
                        )
                    )

                _listIntroData.postValue(listIntro)
            }

            return _listIntroData
        }

}