package io.festa.app.di.androidinjection

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.festa.app.di.module.LoginFragmentModule
import io.festa.app.di.module.LoginWebFragmentModule
import io.festa.app.di.scope.FragmentScope
import io.festa.app.presentation.login.LoginFragment
import io.festa.app.presentation.login.LoginWebFragment

@Module
abstract class AndroidInjectionFragmentModule {

    @Module
    abstract class AiLoginFragmentModule {

        @FragmentScope
        @ContributesAndroidInjector(modules = [LoginFragmentModule::class])
        internal abstract fun loginFragment(): LoginFragment
    }

    @Module
    abstract class AiLoginWebFragmentModule {

        @FragmentScope
        @ContributesAndroidInjector(modules = [LoginWebFragmentModule::class])
        internal abstract fun loginWebFragment(): LoginWebFragment
    }

}