package com.example.case1.domain.repositories

import com.example.case1.domain.models.Article

interface Repo {
    fun getArticles(from: String, to: String): List<Article>
}
