package io.festa.app.di.module

import dagger.Module
import dagger.Provides
import io.festa.app.data.api.EventAPI
import io.festa.app.data.api.Retrofits
import io.festa.app.data.api.UserAPI
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    internal fun provideEventAPI(retrofit: Retrofits): EventAPI = retrofit.buildApi(EventAPI::class.java)

}
