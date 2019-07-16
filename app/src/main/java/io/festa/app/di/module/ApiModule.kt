package io.festa.app.di.module

import dagger.Module
import dagger.Provides
import io.festa.app.data.api.EventAPI
import io.festa.app.data.api.Retrofits
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    internal fun provideEventAPI(retrofit: Retrofits): EventAPI = retrofit.buildApi(EventAPI::class.java)
}
