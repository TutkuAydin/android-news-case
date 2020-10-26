package com.example.case1.api

data class APIRequest(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)