package com.example.case1.ui.main.article

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.case1.databinding.RecyclerItemNewsBinding
import com.example.case1.domain.models.Article

class NewsRecyclerViewAdapter(
    private val articleList: List<Article>,
    private val clickListener: OnClickListener
) : RecyclerView.Adapter<ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerItemNewsBinding.inflate(inflater, parent, false)
        return ArticleViewHolder(binding, clickListener)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articleList[position])
    }
}

class ArticleViewHolder(
    binding: RecyclerItemNewsBinding,
    private val clickListener: OnClickListener
) :
    RecyclerView.ViewHolder(binding.root) {

    private val textTitle = binding.textViewNewsTitle
    private val newsImage = binding.imageViewNews
    private val textInfo = binding.textViewNewsInfo

    fun bind(article: Article) {
        textTitle.setOnClickListener {
            clickListener.onItemClick(article)
        }
        newsImage.setOnClickListener {
            clickListener.onImageClick(article)
        }
        textTitle.text = article.title

        Glide.with(newsImage)
            .load(article.imageUrl)
            .into(newsImage)

        textInfo.text = article.description
    }
}