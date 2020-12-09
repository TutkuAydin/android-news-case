package com.example.case1.ui.main.article

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.case1.R
import com.example.case1.domain.models.Article


class NewsRecyclerViewAdapter(
    private val articleList: List<Article>,
    private val clickListener: (Article) -> Unit
) : RecyclerView.Adapter<ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_news, parent, false)
        return ArticleViewHolder(v, clickListener)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articleList[position])
    }
}

class ArticleViewHolder(itemView: View, private val clickListener: (Article) -> Unit) :
    RecyclerView.ViewHolder(itemView) {

    private val textTitle = itemView.findViewById(R.id.textViewNewsTitle) as TextView
    private val newsImage = itemView.findViewById(R.id.imageViewNews) as ImageView
    private val textInfo = itemView.findViewById(R.id.textViewNewsInfo) as TextView

    fun bind(article: Article) {
        itemView.setOnClickListener {
            clickListener.invoke(article)
        }
        textTitle.text = article.title

        Glide.with(newsImage) //nerede kullanacağız
            .load(article.urlToImage) //neyi yükleyeceğiz
            .into(newsImage) //nereye yükleyeceğiz
        textInfo.text = article.description
    }
}

