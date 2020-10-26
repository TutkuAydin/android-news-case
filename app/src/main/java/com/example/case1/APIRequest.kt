package com.example.case1

import com.example.case1.api.APIRequest
import retrofit2.http.GET
import retrofit2.http.Query

interface APIRequest {
    @GET("https://newsapi.org/v2/everything")

    suspend fun getNews(
            @Query("q") q: String,
            @Query("from") from: String,
            @Query("to") to: String,
            @Query("sortBy") sortBy: String,
            @Query("apiKey") apiKey: String
    ): APIRequest

    //  @GET("https://newsapi.org/v2/everything?q=football&from=2020-10-21&to=2020-10-21&sortBy=publishedAt&apiKey=ae68088e70d04639b4950bdc9d546924")
    //suspend fun getNews() : APIRequest
}
