package com.example.case1.data.apiservice

import com.example.case1.data.models.RequestDataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface APIService {
    @GET("https://newsapi.org/v2/everything?q=football&sortBy=publishedAt&apiKey=ae68088e70d04639b4950bdc9d546924")

     fun getNews(
        @Query("from") from: Date,
        @Query("to") to: Date
    ): Call<RequestDataModel>
}