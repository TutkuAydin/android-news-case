package com.example.case1.ui.main.article

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.case1.domain.models.Article
import com.example.case1.domain.usecases.GetArticles
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class ArticleListViewModel @Inject constructor(private val articleUseCase:GetArticles) : ViewModel() {

    var newsList = MutableLiveData<List<Article>>()
    var newsListDatabase = MutableLiveData<List<Article>>()

    fun getArticlesInfo(from: Date, to: Date) {
        GlobalScope.launch(Dispatchers.IO) {
            newsList.postValue(articleUseCase.execute(from, to))
        }
    }

    fun getArticlesFromDatabase() {
        GlobalScope.launch(Dispatchers.IO) {
            newsListDatabase.postValue((articleUseCase.getArticleDatabase()))
        }
    }

    fun deleteArticles() {
        GlobalScope.launch(Dispatchers.IO) {
            articleUseCase.deleteAllArticles()
        }
    }
}