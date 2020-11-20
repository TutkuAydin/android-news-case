package com.example.case1.domain.usecases

import com.example.case1.data.repo.RemoteRepo
import com.example.case1.domain.models.Article
import java.util.*

class GetArticles : BaseUseCase<Article> {
    override fun execute(
        from: Date,
        to: Date
    ): List<Article> {
        return RemoteRepo.getArticles(from, to)
    }
}