package com.example.case1.domain.usecases

import android.content.Context
import com.example.case1.domain.models.Article
import com.example.case1.domain.repositories.ArticlesRepository
import java.util.*

class GetArticles(context: Context) : BaseUseCase<Article> {

    private val repository = ArticlesRepository(context)

    override fun execute(
        from: Date,
        to: Date
    ): List<Article> {
        return repository.getArticles(from, to)
    }

    fun getArticleDatabase(): List<Article> {
        return repository.getArticlesFromDatabase()
    }
    fun deleteAllArticles(){
        return repository.deleteAllArticles()
    }
}
