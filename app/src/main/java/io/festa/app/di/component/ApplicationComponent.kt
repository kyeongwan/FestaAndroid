package io.festa.app.di.component

import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import io.festa.app.base.FestaApplication
import io.festa.app.data.api.Retrofits
import io.festa.app.di.androidinjection.AndroidInjectionActivityModule
import io.festa.app.di.module.*
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        RemoteDataSourceModule::class,
        RepositoryModule::class,
        ServiceModule::class,
        ApiModule::class,
        ViewModelModule::class,
        AndroidInjectionActivityModule::class]
)
interface ApplicationComponent {

    fun inject(application: FestaApplication)

    fun retrofits(): Retrofits

}