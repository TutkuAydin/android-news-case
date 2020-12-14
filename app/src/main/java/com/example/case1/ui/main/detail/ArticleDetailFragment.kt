package com.example.case1.ui.main.detail

import androidx.navigation.fragment.navArgs
import com.example.case1.databinding.FragmentArticleDetailsBinding
import com.example.case1.ui.main.base.BaseFragment

class ArticleDetailFragment : BaseFragment<FragmentArticleDetailsBinding>() {

    private val args: ArticleDetailFragmentArgs by navArgs()

    override fun getViewBinding() = FragmentArticleDetailsBinding.inflate(layoutInflater)

    override fun initViews() {
        binding?.webViewArticle?.loadUrl(args.article.url.toString())
    }
}