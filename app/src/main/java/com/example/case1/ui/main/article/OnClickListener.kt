package com.example.case1.ui.main.article

import com.example.case1.domain.models.Article

interface OnClickListener {
    fun onItemClick(article: Article)
    fun onImageClick(article: Article)
}