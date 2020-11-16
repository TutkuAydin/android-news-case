package com.example.case1.data.apiservice

import com.example.case1.data.models.RequestDataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIRequest {

    @GET("https://newsapi.org/v2/everything")
    fun getNews(
        @Query("q") q: String,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String
    ): Call<RequestDataModel>
}
