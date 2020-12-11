package com.example.case1.ui.main.detail

import androidx.navigation.fragment.navArgs
import com.example.case1.R
import com.example.case1.ui.main.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_article_details.*

class ArticleDetailFragment : BaseFragment() {
    private val args: ArticleDetailFragmentArgs by navArgs()

    override fun getLayoutId(): Int {
        return R.layout.fragment_article_details
    }

    override fun initViews() {
        webViewArticle.loadUrl(args.article.url.toString())
    }
}