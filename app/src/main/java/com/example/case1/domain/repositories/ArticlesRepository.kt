package com.example.case1.domain.repositories

import com.example.case1.domain.models.Article
import java.util.*

interface ArticlesRepository {
    fun getArticles(from: Date, to: Date): List<Article>
}