package com.example.case1.data

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://newsapi.org"
private const val API_KEY = "ae68088e70d04639b4950bdc9d546924"

object RetrofitCreator {

    private val retrofit: Retrofit by lazy {
        createRetrofit()
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttpClient())
            .build()
    }

    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(getInterceptor())
            .build()
    }

    private fun getInterceptor(): Interceptor {
        return Interceptor { chain ->
            val original: Request = chain.request()
            val originalHttpUrl: HttpUrl = original.url()

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", "football")
                .addQueryParameter("sortBy", "publishedAt")
                .build()

            val requestBuilder = original.newBuilder().url(url)

            val request: Request = requestBuilder.build()
            chain.proceed(request)
        }
    }

    fun <S> getService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }
}
