package com.example.case1.ui.main

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.case1.R
import com.example.case1.addition.convertToDate
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var from: Date = Date()
    var to: Date = Date()

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pickerCalenderButton.setOnClickListener {
            chooseDate()
        }

        viewModel.getArticlesInfo(from, to)

        recyclerViewArticle.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel.newsList.observe(this, Observer { articleList ->
            val adapter = NewsRecyclerViewAdapter(articleList)
            recyclerViewArticle.adapter = adapter
        })
    }

    private fun chooseDate() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog =
            DatePickerDialog(
                this,
                { _, mYear, mMonth, mDay ->
                    val date =
                        convertToDate(
                            mYear,
                            mMonth,
                            mDay
                        )
                    from = date
                    to = Date()
                    viewModel.getArticlesInfo(from, to)
                },
                year,
                month,
                day
            )
        datePickerDialog.show()
    }
}
