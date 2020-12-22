package com.example.case1.ui.main.article

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.case1.domain.models.Article
import com.example.case1.domain.usecases.GetArticles
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class ArticleListViewModel(context: Context) : ViewModel() {

    private val articleUseCase = GetArticles(context)
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