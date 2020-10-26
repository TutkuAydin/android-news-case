package com.example.case1

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.case1.api.APIRequest
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import java.util.*

const val BASE_URL="https://newsapi.org"

class MainActivity : AppCompatActivity() {

    private var titlesList= mutableListOf<String>()
    private var imageList= mutableListOf<String>()
    private var descList= mutableListOf<String>()
    private var urlList= mutableListOf<String>()

    var from: String ="2020-10-23"
    var to: String ="2020-10-23"
    val q:String="football"
    val sortBy:String="publishedAt"
    val apiKey:String="ae68088e70d04639b4950bdc9d546924"

    lateinit var countDownTimer: CountDownTimer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createAPIRequest()
        //calender()
        val c=Calendar.getInstance()
        val year=c.get(Calendar.YEAR)
        val month=c.get(Calendar.MONTH)
        val day=c.get(Calendar.DAY_OF_MONTH)


        pickerCalender.setOnClickListener{
            val dpd=DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                val date= convertToDate(mYear,mMonth,mDay)
                // from=date.convertToString()
                //to="2020-10-23"
                
            },year,month,day)
            dpd.show()



        }
    }


    private fun refreshRecyclerView(){
        //val recyclerView=findViewById(R.id.listview) as RecyclerView

        listview.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        val adapter=NewsAdapter(titlesList,imageList,descList,urlList)
        listview.adapter=adapter
    }

    private  fun addList(title:String,image: String,description:String,link:String){
        titlesList.add(title)
        descList.add(description)
        imageList.add(image)
        urlList.add(link)
    }

    private fun createAPIRequest(){
        val api=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(com.example.case1.APIRequest::class.java)

        GlobalScope.launch(Dispatchers.IO){
            try {
                val response=api.getNews(q,from,to,sortBy,apiKey)

                for(article in response.articles){
                    Log.i("MainActivity","Result=$article")
                    addList(article.title,article.urlToImage,article.description,article.url)
                }
                withContext(Dispatchers.Main){
                    refreshRecyclerView()
                }

            }catch (e:Exception){
                Log.e("MainActivity",e.toString())

            }
        }
    }

}