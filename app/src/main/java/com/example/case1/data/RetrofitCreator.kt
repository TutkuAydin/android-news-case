package com.example.case1.data

import com.example.case1.data.apiservice.APIService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://newsapi.org"
object RetrofitCreator {

    fun createRetrofit(): APIService {
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return api.create(APIService::class.java)

    }


}
