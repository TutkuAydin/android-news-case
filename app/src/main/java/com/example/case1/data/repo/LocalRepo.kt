package com.example.case1.data.repo

import com.example.case1.data.backup.dao.ArticleDao
import com.example.case1.data.backup.mappers.ArticleEntityMapper
import com.example.case1.domain.models.Article
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalRepo @Inject constructor(private val dao: ArticleDao) {

    private val articleEntityMapper = ArticleEntityMapper()

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