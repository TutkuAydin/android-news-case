package com.example.case1.data.backup.mappers

import com.example.case1.data.backup.model.ArticleEntity
import com.example.case1.domain.models.Article

class ArticleEntityMapper {

    fun articleEntityDetails(dataModel: Article): ArticleEntity {
        return ArticleEntity(
            title = dataModel.title ?: "",
            description = dataModel.description ?: "",
            url = dataModel.url ?: "",
            urlToImage = dataModel.imageUrl ?: ""
        )
    }

    fun map(response: ArticleEntity): Article {
        return Article(
            title = response.title,
            description = response.description,
            url = response.url,
            imageUrl = response.urlToImage
        )
    }
}