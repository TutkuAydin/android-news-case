package com.example.case1.ui.main.article

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.case1.R
import com.example.case1.addition.convertToDate
import kotlinx.android.synthetic.main.fragment_article_list.*
import java.util.*

class ArticleListFragment : Fragment() {

    var from: Date = Date()
    var to: Date = Date()

    private val viewModel: ArticleListViewModel by lazy {
        ViewModelProvider(this).get(ArticleListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_article_list, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pickerCalenderButton.setOnClickListener {
            chooseDate()
        }
        viewModel.getArticlesInfo(from, to)

        recyclerViewArticle.layoutManager =
            LinearLayoutManager(context)

        viewModel.newsList.observe(viewLifecycleOwner, Observer {
            val adapter =
                NewsRecyclerViewAdapter(it) { article ->
                    findNavController().navigate(
                        ArticleListFragmentDirections.articleDetails(
                            article
                        )
                    )
                }
            recyclerViewArticle.adapter = adapter
        })
    }

    private fun chooseDate() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog =
            getActivity()?.let {
                DatePickerDialog(
                    it,
                    DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
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
            }
        datePickerDialog?.show()
    }
}