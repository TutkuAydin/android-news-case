package com.example.case1.data.apiservice

import com.example.case1.data.models.RequestDataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface APIService {

    @GET("https://newsapi.org/v2/everything")
    fun getNews(
        @Query("from") from: Date,
        @Query("to") to: Date
    ): Call<RequestDataModel>
}
