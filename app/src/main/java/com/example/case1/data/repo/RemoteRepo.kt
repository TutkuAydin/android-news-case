package com.example.case1.data.repo

import com.example.case1.data.RetrofitCreator
import com.example.case1.data.mappers.ArticleMapper
import com.example.case1.domain.models.Article
import com.example.case1.domain.repositories.ArticlesRepository
import java.util.*

object RemoteRepo : ArticlesRepository {

    override fun getArticles(from: Date, to: Date): List<Article> {
        val articleMapper = ArticleMapper()
        val retrofitCreator = RetrofitCreator
        val response = retrofitCreator.createRetrofit().getNews(from, to).execute()
        return response.body()!!.reports!!.map {
            articleMapper.articleDetails(it)
        }
    }
}