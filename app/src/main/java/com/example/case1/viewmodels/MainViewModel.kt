package com.example.case1.viewmodels


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.case1.domain.models.Article
import com.example.case1.domain.usecases.GetArticles
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val articleUseCase = GetArticles()
    var newsList = MutableLiveData<List<Article>>()

    fun createAPIRequest(from: String, to: String) {

        GlobalScope.launch(Dispatchers.IO) {
            newsList.postValue(articleUseCase.execute(from,to))
        }
    }

}