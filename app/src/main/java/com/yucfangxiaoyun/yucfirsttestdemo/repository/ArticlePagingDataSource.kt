package com.yucfangxiaoyun.yucfirsttestdemo.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.yucfangxiaoyun.yucfirsttestdemo.network.response.Article
import com.yucfangxiaoyun.yucfirsttestdemo.network.service.IArticleService

class ArticlePagingDataSource(
    private val iService: IArticleService
) : PagingSource<Int, Article>() {

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> =
        try {
            // 获得这次加载，需要加载哪一页
            val needLoadKey = params.key ?: 1
            // 加载这一页后，下一页的页数是多少
            val nextKey = needLoadKey + 1
            // 加载这一页后，前一页是多少
            val prevKey = if (needLoadKey == 1) null else (needLoadKey - 1)
            val remoteData = iService.getArticlesFromRemote(needLoadKey)
            LoadResult.Page(
                data = remoteData,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
}