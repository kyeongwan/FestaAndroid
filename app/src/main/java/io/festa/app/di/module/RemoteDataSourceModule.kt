package io.festa.app.di.module

import dagger.Binds
import dagger.Module
import io.festa.app.data.repository.source.event.EventListRemoteDataSource
import io.festa.app.data.repository.source.event.EventListRemoteDataSourceImpl
import javax.inject.Singleton

@Module
abstract class RemoteDataSourceModule {

    @Binds
    @Singleton
    internal abstract fun provideEventListRemoteDataSource(remoteDataSource: EventListRemoteDataSourceImpl)
            : EventListRemoteDataSource
}