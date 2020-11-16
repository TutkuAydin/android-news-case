package com.example.case1.domain.usecases

import com.example.case1.data.repo.RemoteRepo
import com.example.case1.domain.models.Article

class GetArticles : BaseUseCase<Article> {
    override fun execute(
        from: String,
        to: String
    ): List<Article> {
        return RemoteRepo.getArticles(from, to)
    }
}