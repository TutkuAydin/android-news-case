package com.example.case1.data.repo

import com.example.case1.data.BaseDataSource
import com.example.case1.data.mappers.ArticleMapper
import com.example.case1.domain.models.Article
import com.example.case1.domain.repositories.Repo

object RemoteRepo : Repo {

    private val keyword: String = "football"
    private val sortBy: String = "publishedAt"
    private val apiKey: String = "ae68088e70d04639b4950bdc9d546924"

    override fun getArticles(from: String, to: String): List<Article> {
        val articleMapper = ArticleMapper()
        val bds = BaseDataSource
        val response = bds.api.getNews(keyword, from, to, sortBy, apiKey).execute()
        return response.body()!!.reports!!.map {
            articleMapper.articleDetails(it)
        }
    }
}