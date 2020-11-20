package com.implizstudio.android.app.warungkuowner.di.module

import com.implizstudio.android.app.warungkuowner.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideApiService() = ApiService

}