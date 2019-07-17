package io.festa.app.di.module

import dagger.Binds
import dagger.Module
import io.festa.app.domain.event.EventListService
import io.festa.app.domain.event.EventListServiceImpl
import io.festa.app.domain.user.UserService
import io.festa.app.domain.user.UserServiceImpl
import javax.inject.Singleton

@Module
abstract class ServiceModule {

    @Binds
    @Singleton
    internal abstract fun provideEventListService(service: EventListServiceImpl): EventListService

    @Binds
    @Singleton
    internal abstract fun provideUserService(service: UserServiceImpl): UserService
}
