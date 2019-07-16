package io.festa.app.di.androidinjection

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.festa.app.di.module.MainActivityModule
import io.festa.app.di.scope.ActivityScope
import io.festa.app.presentation.MainActivity

@Module
abstract class AndroidInjectionActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun mainActivity(): MainActivity

}