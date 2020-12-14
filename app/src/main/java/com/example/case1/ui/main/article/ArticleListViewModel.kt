package com.example.case1.ui.main.article

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.case1.domain.models.Article
import com.example.case1.domain.usecases.GetArticles
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class ArticleListViewModel : ViewModel() {

    private val articleUseCase = GetArticles()
    var newsList = MutableLiveData<List<Article>>()

    fun getArticlesInfo(from: Date, to: Date) {
        GlobalScope.launch(Dispatchers.IO) {
            newsList.postValue(articleUseCase.execute(from, to))
        }
    }
}