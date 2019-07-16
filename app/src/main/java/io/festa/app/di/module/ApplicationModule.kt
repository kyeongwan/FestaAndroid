package io.festa.app.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import io.festa.app.data.api.Retrofits
import io.festa.app.di.name.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(context: Context) {

    private val context: Context = context

    @Provides
    @Singleton
    @ApplicationContext
    internal fun provideContext(): Context = context

    @Provides
    @Singleton
    internal fun provideRetrofit(client: OkHttpClient, gsonConverterFactory: Converter.Factory): Retrofits =
        Retrofits(client, gsonConverterFactory)

    @Provides
    @Singleton
    internal fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

    @Provides
    @Singleton
    fun provideRetrofitConverterFactory(): Converter.Factory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

}