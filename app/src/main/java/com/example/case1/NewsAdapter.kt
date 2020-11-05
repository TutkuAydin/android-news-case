package com.example.case1

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
import com.example.case1.api.Article

class NewsAdapter(
    private var articleList: List<Article>
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textTitle = itemView.findViewById(R.id.title) as TextView
        private val newsImage = itemView.findViewById(R.id.news_image) as ImageView
        private val textInfo = itemView.findViewById(R.id.info) as TextView

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(articleList[position])
    }
}