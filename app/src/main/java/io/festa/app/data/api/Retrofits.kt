package io.festa.app.data.api

import android.webkit.CookieManager
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Retrofits @Inject constructor(
    private var client: OkHttpClient,
    private var gsonConverterFactory: Converter.Factory
) {

    companion object {
        const val DEFAULT_BASE_URL = "https://festa.io/"
        private const val HEADER_COOKIE = "Cookie"
    }


    private var rxJava2CallAdapterFactory: RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.createAsync()

    fun updateCookieFromWebView() {
        client.newBuilder().addInterceptor(object :
            Interceptor {

            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val original = chain.request()

                val request = original.newBuilder()
                    .addHeader(
                        HEADER_COOKIE,
                        CookieManager.getInstance().getCookie(DEFAULT_BASE_URL)
                    )
                    .build()
                return chain.proceed(request)
            }
        }).build()
    }

    fun <T> buildApi(apiClass: Class<T>): T {
        return createRetrofit().create(apiClass)
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(DEFAULT_BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .client(client)
            .build()
    }

}