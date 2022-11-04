package com.yucfangxiaoyun.yucfirsttestdemo.network.service

import com.yucfangxiaoyun.yucfirsttestdemo.network.RetrofitConfig
import com.yucfangxiaoyun.yucfirsttestdemo.network.response.Article
import retrofit2.http.GET
import retrofit2.http.Query

interface IArticleService {
    @GET("/posts")
    suspend fun getArticlesFromRemote(
        @Query("userId") pageNumber: Int
    ): List<Article>

    companion object {
        fun provide(baseURL: String): IArticleService =
            RetrofitConfig.noInterceptorRetrofit(baseURL)
                .create(IArticleService::class.java)
    }
}