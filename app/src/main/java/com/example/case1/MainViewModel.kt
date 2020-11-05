package com.example.case1

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.case1.api.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {
    val newsList = MutableLiveData<List<Article>>()

    private val keyword: String = "football"
    private val sortBy: String = "publishedAt"
    private val apiKey: String = "ae68088e70d04639b4950bdc9d546924"

    fun createAPIRequest(from: String, to: String) {
        val api = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(com.example.case1.APIRequest::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = api.getNews(keyword, from, to, sortBy, apiKey)

                //newsList.value = response.articles
                newsList.postValue(response.articles)

            } catch (e: Exception) {
                Log.e("MainActivity", e.toString())
            }
        }
    }
}
