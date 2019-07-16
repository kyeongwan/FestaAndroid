package io.festa.app.di.module

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides
import io.festa.app.di.name.ActivityContext
import io.festa.app.di.scope.ActivityScope
import io.festa.app.presentation.MainActivity

@Module
class MainActivityModule {

    @Provides
    @ActivityScope
    @ActivityContext
    internal fun provideContext(activity: MainActivity): Context {
        return activity
    }

    @Provides
    @ActivityScope
    internal fun provideActivity(activity: MainActivity): Activity {
        return activity
    }

}