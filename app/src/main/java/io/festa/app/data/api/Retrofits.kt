package io.festa.app.data.api

import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Retrofits @Inject constructor(
    private var client: OkHttpClient,
    private var gsonConverterFactory: Converter.Factory
) {

    private val DEFAULT_BASE_URL = "https://festa.io/"
    private var rxJava2CallAdapterFactory: RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.createAsync()

    fun <T> buildApi(apiClass: Class<T>): T {
        return createRetrofit(DEFAULT_BASE_URL).create(apiClass)
    }

    private fun createRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .client(client)
            .build()
    }

}