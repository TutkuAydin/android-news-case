package com.example.case1.ui.main.article

import android.app.DatePickerDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.case1.R
import com.example.case1.addition.convertToDate
import com.example.case1.domain.models.Article
import com.example.case1.ui.main.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_article_list.*
import java.util.*


class ArticleListFragment : BaseFragment(),
    OnClickListener {

    var from: Date = Date()
    var to: Date = Date()

    private val viewModel: ArticleListViewModel by lazy {
        ViewModelProvider(this).get(ArticleListViewModel::class.java)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_article_list
    }

    override fun initViews() {

        pickerCalenderButton.setOnClickListener {
            datePicker()
        }
        viewModel.getArticlesInfo(from, to)

        recyclerViewArticle.layoutManager =
            LinearLayoutManager(context)

        viewModel.newsList.observe(viewLifecycleOwner, Observer {
            val adapter =
                NewsRecyclerViewAdapter(it, this@ArticleListFragment)
            recyclerViewArticle.adapter = adapter
        })
    }

    private fun datePicker() {
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

    override fun onItemClick(article: Article) {
        findNavController().navigate(
            ArticleListFragmentDirections.articleDetails(
                article
            )
        )
    }

    override fun onImageClick(article: Article) {
        findNavController().navigate(
            ArticleListFragmentDirections.dialogImage(
                article
            )
        )
    }
}