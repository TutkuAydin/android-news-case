package com.example.case1.domain.repositories

import android.content.Context
import com.example.case1.data.repo.LocalRepo
import com.example.case1.data.repo.RemoteRepo
import com.example.case1.domain.models.Article
import java.util.*

class ArticlesRepository(context: Context) {
    private val remoteRepo = RemoteRepo()
    private val localRepo = LocalRepo(context)
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
