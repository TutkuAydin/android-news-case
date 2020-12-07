package com.example.case1.data.models

import com.google.gson.annotations.SerializedName

class RequestDataModel(
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int,
    @SerializedName("articles")
    val reports: ArrayList<ArticleDataModel>
)
