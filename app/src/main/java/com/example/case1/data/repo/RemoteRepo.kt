package com.example.case1.data.repo

import com.example.case1.data.RetrofitCreator
import com.example.case1.data.apiservice.APIService
import com.example.case1.data.mappers.ArticleMapper
import com.example.case1.domain.models.Article
import com.example.case1.domain.repositories.ArticlesRepository
import java.util.*

object RemoteRepo : ArticlesRepository {

    private val apiService: APIService by lazy {
        RetrofitCreator.getService(APIService::class.java)
    }

    override fun getArticles(from: Date, to: Date): List<Article> {
        val articleMapper = ArticleMapper()
        val response = apiService.getNews(from, to).execute()
        return response.body()!!.reports!!.map {
            articleMapper.articleDetails(it)
        }
    }
}
