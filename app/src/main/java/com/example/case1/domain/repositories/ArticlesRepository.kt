package com.example.case1.domain.repositories

import com.example.case1.data.repo.LocalRepo
import com.example.case1.data.repo.RemoteRepo
import com.example.case1.domain.models.Article
import java.util.*
import javax.inject.Inject

class ArticlesRepository @Inject constructor(
    private val remoteRepo: RemoteRepo,
    private val localRepo: LocalRepo
) {

    fun getArticles(from: Date, to: Date): List<Article> {
        val articles = remoteRepo.getArticles(from, to)
        localRepo.saveArticles(articles)
        return articles
    }

    fun getArticlesFromDatabase(): List<Article> {
        return localRepo.getArticles()
    }

    fun deleteAllArticles() {
        return localRepo.deleteAllArticles()
    }
}
