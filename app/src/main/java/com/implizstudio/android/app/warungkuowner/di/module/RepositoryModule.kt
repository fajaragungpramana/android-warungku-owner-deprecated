package com.implizstudio.android.app.warungkuowner.di.module

import com.implizstudio.android.app.warungkuowner.data.remote.ApiService
import com.implizstudio.android.app.warungkuowner.data.repository.warungku.WarungKuRepository
import com.implizstudio.android.app.warungkuowner.data.repository.warungku.WarungKuRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {

    @Provides
    fun provideWarungKuRepository(warungKuService: ApiService): WarungKuRepository =
        WarungKuRepositoryImpl(warungKuService.createWarungKuService())

}