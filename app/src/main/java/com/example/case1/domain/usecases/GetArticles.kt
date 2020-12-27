package com.example.case1.domain.usecases

import com.example.case1.domain.models.Article
import com.example.case1.domain.repositories.ArticlesRepository
import java.util.*
import javax.inject.Inject

class GetArticles @Inject constructor(private val repository: ArticlesRepository) : BaseUseCase<Article> {

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
