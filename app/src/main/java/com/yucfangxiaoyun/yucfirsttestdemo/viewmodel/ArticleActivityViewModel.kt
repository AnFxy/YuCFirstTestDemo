package com.yucfangxiaoyun.yucfirsttestdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.yucfangxiaoyun.yucfirsttestdemo.common.Constants
import com.yucfangxiaoyun.yucfirsttestdemo.network.service.IArticleService
import com.yucfangxiaoyun.yucfirsttestdemo.repository.ArticlePagingDataSource

class ArticleActivityViewModel : ViewModel() {

    // 使用viewmodel进行状态管理，以及调用repository的操作，其实这个应该放在usercase中实现
    val articleFlow = Pager(
        PagingConfig(pageSize = 10, prefetchDistance = 3)
    ) {
        ArticlePagingDataSource(IArticleService.provide(Constants.ARTICLEURL))
    }.flow
        .cachedIn(viewModelScope)
}