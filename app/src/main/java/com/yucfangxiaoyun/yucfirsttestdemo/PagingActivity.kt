package com.yucfangxiaoyun.yucfirsttestdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.yucfangxiaoyun.yucfirsttestdemo.databinding.ActivityPagingBinding
import com.yucfangxiaoyun.yucfirsttestdemo.network.response.Article
import com.yucfangxiaoyun.yucfirsttestdemo.view.adapter.ArticleAdapter
import com.yucfangxiaoyun.yucfirsttestdemo.viewmodel.ArticleActivityViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PagingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPagingBinding
    private val viewModel: ArticleActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView(){
         val adapter = ArticleAdapter(object : DiffUtil.ItemCallback<Article>() {
             // 判断 item是否相同, 有疑问，这个回调接口具体作用是什么？怎么实现区分两个item的？
             override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                 // Id is unique
                 return oldItem.id == newItem.id
             }

             // 判断内容是否相等
             override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                 return oldItem == newItem
             }
         })
        binding.rvArticle.adapter = adapter
        binding.rvArticle.layoutManager = LinearLayoutManager(this)
        lifecycleScope.launch {
            viewModel.articleFlow.collectLatest {  pagingData ->
                adapter.submitData(pagingData)
            }
        }
    }
}