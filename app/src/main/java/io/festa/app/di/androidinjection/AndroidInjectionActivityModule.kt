package io.festa.app.di.androidinjection

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.festa.app.di.androidinjection.AndroidInjectionFragmentModule.AiLoginFragmentModule
import io.festa.app.di.androidinjection.AndroidInjectionFragmentModule.AiLoginWebFragmentModule
import io.festa.app.di.module.LoginActivityModule
import io.festa.app.di.module.MainActivityModule
import io.festa.app.di.scope.ActivityScope
import io.festa.app.presentation.MainActivity
import io.festa.app.presentation.login.LoginActivity

@Module
abstract class AndroidInjectionActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun mainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [LoginActivityModule::class, AiLoginFragmentModule::class, AiLoginWebFragmentModule::class])
    internal abstract fun loginActivity(): LoginActivity

}