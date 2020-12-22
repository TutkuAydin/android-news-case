package com.example.case1.ui.main.article

import android.app.DatePickerDialog
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.case1.addition.ViewModelFactory
import com.example.case1.addition.convertToDate
import com.example.case1.databinding.FragmentArticleListBinding
import com.example.case1.domain.models.Article
import com.example.case1.ui.main.base.BaseFragment
import java.util.*

class ArticleListFragment : BaseFragment<FragmentArticleListBinding>(), OnClickListener {

    var from: Date = Date()
    var to: Date = Date()

    private val viewModel: ArticleListViewModel by viewModels {
        ViewModelFactory(
            requireContext()
        )
    }

    override fun getViewBinding() = FragmentArticleListBinding.inflate(layoutInflater)

    override fun initViews() {

        binding?.pickerCalenderButton?.setOnClickListener {
            datePicker()
        }

        binding?.imageButtonShowDatabase?.setOnClickListener {
            findNavController().navigate(
                ArticleListFragmentDirections.backupArticleDetails()
            )
        }

        viewModel.getArticlesInfo(from, to)

        binding?.recyclerViewArticle?.layoutManager =
            LinearLayoutManager(context)

        viewModel.newsList.observe(viewLifecycleOwner, Observer {
            val adapter =
                NewsRecyclerViewAdapter(it, this@ArticleListFragment)
            binding?.recyclerViewArticle?.adapter = adapter
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