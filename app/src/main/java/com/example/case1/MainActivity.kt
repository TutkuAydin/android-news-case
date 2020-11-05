package com.example.case1

import android.app.DatePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.case1.api.Article
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import java.util.*
import androidx.lifecycle.ViewModelProvider as ViewModelProvider

const val BASE_URL = "https://newsapi.org"

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    var from: String = ""
    var to: String = ""
    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    var month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)
    val dateForToday=convertToDate(year, month, day)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        pickerCalender.setOnClickListener {
            chooseDate()
        }

        from = dateForToday.convertToString()
        to = dateForToday.convertToString()

        Log.i("frommmmmmmmm", from)
        Log.i("frommmmmmmmm", to)


        viewModel.createAPIRequest(from, to)
        viewModel.newsList.observe(this, androidx.lifecycle.Observer { articleList ->
            listview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            val adapter = NewsAdapter(articleList)
            listview.adapter = adapter

        })
    }

    private fun chooseDate() {
        val dpd =
            DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                    val date = convertToDate(mYear, mMonth, mDay)
                    from = date.convertToString()
                    to = dateForToday.convertToString()
                    Log.i("from", from)
                    Log.i("to", to)
                    viewModel.createAPIRequest(from, to)

                },
                year,
                month,
                day
            )
        dpd.show()
    }


}