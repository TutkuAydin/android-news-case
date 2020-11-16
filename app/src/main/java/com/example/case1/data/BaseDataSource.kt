package com.example.case1.data

import com.example.case1.data.apiservice.APIRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://newsapi.org"
object BaseDataSource {
    val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(APIRequest::class.java)

}