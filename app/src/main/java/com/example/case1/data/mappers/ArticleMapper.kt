package com.example.case1.data.mappers

import com.example.case1.data.models.ArticleDataModel
import com.example.case1.domain.models.Article

class ArticleMapper {
    fun articleDetails(dataModel: ArticleDataModel): Article {
        return Article(
            title = dataModel.title ?: "",
            description = dataModel.description ?: "",
            url = dataModel.url ?: "",
            urlToImage = dataModel.urlToImage ?: ""
        )
    }
}
