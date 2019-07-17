package io.festa.app.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.festa.app.base.ViewModelFactory
import io.festa.app.di.name.ViewModelKey
import io.festa.app.presentation.login.AuthViewModel

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    internal abstract fun bindCounterViewModel(viewModel: AuthViewModel): ViewModel

}