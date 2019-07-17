package io.festa.app.di.module

import android.app.Activity
import android.content.Context
import dagger.Binds
import dagger.Module
import io.festa.app.di.name.ActivityContext
import io.festa.app.di.scope.ActivityScope
import io.festa.app.presentation.MainActivity

@Module
abstract class MainActivityModule {

    @Binds
    @ActivityScope
    @ActivityContext
    internal abstract fun provideContext(activity: MainActivity): Context

    @Binds
    @ActivityScope
    internal abstract fun provideActivity(activity: MainActivity): Activity

}