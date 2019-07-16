package io.festa.app.di.module

import dagger.Binds
import dagger.Module
import io.festa.app.data.repository.EventListRepositoryImpl
import io.festa.app.domain.event.EventListRepository
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    internal abstract fun provideEventListRepositroy(repository: EventListRepositoryImpl): EventListRepository
}