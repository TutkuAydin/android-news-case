package com.example.case1.data.repo

import android.content.Context
import com.example.case1.data.backup.dao.ArticleDao
import com.example.case1.data.backup.database.AppDatabase
import com.example.case1.data.backup.mappers.ArticleEntityMapper
import com.example.case1.domain.models.Article

class LocalRepo(private val context: Context) {

    private val articleEntityMapper = ArticleEntityMapper()

    private val dao: ArticleDao by lazy {
        AppDatabase.getDatabase(context).articleDao()
    }

    fun getArticles(): List<Article> {
        return dao.getAllArticles().map {
            articleEntityMapper.map(it)
        }
    }

    fun saveArticles(articles: List<Article>) {
        for (item in articles)
            dao.insertAll(articleEntityMapper.articleEntityDetails(item))
    }

    fun deleteAllArticles() {
        dao.deleteAll()
    }
}