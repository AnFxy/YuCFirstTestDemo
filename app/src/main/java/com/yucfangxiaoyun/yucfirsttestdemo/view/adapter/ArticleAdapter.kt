package com.yucfangxiaoyun.yucfirsttestdemo.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.yucfangxiaoyun.yucfirsttestdemo.databinding.ItemArticleBinding
import com.yucfangxiaoyun.yucfirsttestdemo.network.response.Article

class ArticleAdapter(diffCallback: DiffUtil.ItemCallback<Article>) :
    PagingDataAdapter<Article, ArticleAdapter.ArticleViewHolder>(diffCallback) {

    inner class ArticleViewHolder(
        private val binding: ItemArticleBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article?) {
            binding.txtId.text = "ID:${article?.id ?: "null"}"
            binding.txtPageNumber.text = "UserID:${article?.userId ?: "null"}"
            binding.txtTitle.text = "Title:${article?.title ?: "null"}"
            binding.txtBody.text = "Content:${article?.body ?: "null"}"
        }
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val currentArticle = getItem(position)
        holder.bind(currentArticle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding =ItemArticleBinding.inflate(LayoutInflater.from(parent.context))
        return ArticleViewHolder(binding)
    }
}