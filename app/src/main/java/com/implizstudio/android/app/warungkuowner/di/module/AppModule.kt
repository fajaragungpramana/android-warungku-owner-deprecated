package com.implizstudio.android.app.warungkuowner.di.module

import android.content.Context
import android.content.res.Resources
import com.implizstudio.android.app.warungkuowner.data.local.AppResource
import com.implizstudio.android.app.warungkuowner.data.repository.app.AppResourceRepository
import com.implizstudio.android.app.warungkuowner.data.repository.app.AppResourceRepositoryImpl
import com.implizstudio.android.app.warungkuowner.util.TemporarySave
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Provides
    fun provideContext(@ApplicationContext context: Context) = context

    @Provides
    fun provideResources(context: Context): Resources = context.resources

    @Provides
    fun provideTemporarySave(context: Context) = TemporarySave(context)

    @Provides
    fun provideAppResource(resource: Resources) = AppResource(resource)

    @Provides
    fun provideAppResourceRepository(appResource: AppResource): AppResourceRepository {
        return AppResourceRepositoryImpl(appResource)
    }

}