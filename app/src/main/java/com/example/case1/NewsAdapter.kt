package com.example.case1


import android.content.Intent
import android.media.Image
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(
    private var titles: List<String>,
    private var imagesUrl: List<String>,
    private var descriptions:  List<String>,
    private var url: List<String>
    ):RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val textTitle=itemView.findViewById(R.id.title) as TextView
        val newsImage=itemView.findViewById(R.id.news_image) as ImageView
        val textInfo=itemView.findViewById(R.id.info) as TextView

        init {
            itemView.setOnClickListener {v: View ->
                val position: Int=adapterPosition

                val intent =Intent(Intent.ACTION_VIEW)
                intent.data= Uri.parse(url[position])
                startActivity(itemView.context,intent,null)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.list_layout,parent,false)
        return  ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {

        holder.textTitle.text=titles[position]

        Glide.with(holder.newsImage) //nerede kullanacağız
            .load(imagesUrl[position]) //neyi yükleyeceğiz
            .into(holder.newsImage) //nereye yükleyeceğiz

        holder.textInfo.text=descriptions[position]

    }
}