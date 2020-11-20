package com.example.case1.ui.main

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.case1.R
import com.example.case1.domain.models.Article

class NewsRecyclerViewAdapter(
    private var articleList: List<Article>
) : RecyclerView.Adapter<ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_news, parent, false)
        return ArticleViewHolder(v)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articleList[position])
    }
}

class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val textTitle = itemView.findViewById(R.id.textViewNewsTitle) as TextView
    private val newsImage = itemView.findViewById(R.id.imageViewNews) as ImageView
    private val textInfo = itemView.findViewById(R.id.textViewNewsInfo) as TextView

    fun bind(article: Article) {
        itemView.setOnClickListener { v: View ->
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(article.url)
            startActivity(itemView.context, intent, null)
        }
        textTitle.text = article.title

        Glide.with(newsImage) //nerede kullanacağız
            .load(article.urlToImage) //neyi yükleyeceğiz
            .into(newsImage) //nereye yükleyeceğiz
        textInfo.text = article.description
    }
}
