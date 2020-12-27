package com.example.case1.ui.main.backup

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.case1.databinding.FragmentArticleBackupBinding
import com.example.case1.di.ViewModelFactory
import com.example.case1.domain.models.Article
import com.example.case1.ui.main.article.ArticleListFragmentDirections
import com.example.case1.ui.main.article.ArticleListViewModel
import com.example.case1.ui.main.article.NewsRecyclerViewAdapter
import com.example.case1.ui.main.article.OnClickListener
import com.example.case1.ui.main.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArticleBackupFragment :
    BaseFragment<FragmentArticleBackupBinding>(), OnClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: ArticleListViewModel by viewModels {
        viewModelFactory
    }

    override fun getViewBinding() = FragmentArticleBackupBinding.inflate(layoutInflater)

    override fun initViews() {

        viewModel.getArticlesFromDatabase()

        binding?.imageButtonDeleteAll?.setOnClickListener {
            viewModel.deleteArticles()
            refreshFragmentView()
        }

        binding?.recyclerViewArticle?.layoutManager =
            LinearLayoutManager(context)

        viewModel.newsListDatabase.observe(viewLifecycleOwner, Observer {
            val adapter =
                NewsRecyclerViewAdapter(it, this@ArticleBackupFragment)
            binding?.recyclerViewArticle?.adapter = adapter
        })
    }

    private fun refreshFragmentView() {
        fragmentManager?.beginTransaction()?.detach(this)?.attach(this)?.commit()
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