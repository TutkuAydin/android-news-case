package com.example.case1.data.models

import com.google.gson.annotations.SerializedName

class ArticleDataModel(
    @SerializedName("source")
    val source: SourceDataModel?,
    @SerializedName("author")
    val author: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("urlToImage")
    val imageUrl: String?,
    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("content")
    val content: String?
)
