package com.example.case1.data.mappers

import com.example.case1.data.models.ArticleDataModel
import com.example.case1.domain.models.Article

class ArticleMapper {
    fun articleDetails(articleModelServer: ArticleDataModel): Article {
        return Article(
            articleModelServer.title ?: "",
            articleModelServer.description ?: "",
            articleModelServer.url ?: "",
            articleModelServer.urlToImage ?: ""
        )
    }
}
