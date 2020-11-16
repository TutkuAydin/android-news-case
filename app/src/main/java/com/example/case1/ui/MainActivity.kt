package com.example.case1.ui

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.case1.R
import com.example.case1.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    var from: String = ""
    var to: String = ""
    private val c = Calendar.getInstance()
    private val year = c.get(Calendar.YEAR)
    private var month = c.get(Calendar.MONTH)
    private val day = c.get(Calendar.DAY_OF_MONTH)
    private val dateForToday = convertToDate(year, month, day)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        pickerCalender.setOnClickListener {
            chooseDate()
        }

        from = dateForToday.convertToString()
        to = dateForToday.convertToString()

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
                    val date =
                        convertToDate(mYear, mMonth, mDay)
                    from = date.convertToString()
                    to = dateForToday.convertToString()
                    viewModel.createAPIRequest(from, to)
                },
                year,
                month,
                day
            )
        dpd.show()
    }
}
