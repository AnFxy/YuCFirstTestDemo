package com.yucfangxiaoyun.yucfirsttestdemo.network

import com.yucfangxiaoyun.yucfirsttestdemo.common.Constants
import com.yucfangxiaoyun.yucfirsttestdemo.network.interceptor.CloudInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Duration

// 拦截器的主要使用
class RetrofitConfig {

    companion object {

        val originalRetrofit = Retrofit.Builder()
            .baseUrl("https://www.baidu.com")
            .addConverterFactory(GsonConverterFactory.create())

        val client = OkHttpClient.Builder()
            .callTimeout(Duration.ofMillis(5000))
            .connectTimeout(Duration.ofMillis(5000))
            .readTimeout(Duration.ofMillis(5000))

        fun interceptorRetrofit(tag: String): Retrofit =
            if (tag == Constants.TEAMGRADE) {
                originalRetrofit.addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            } else {
                originalRetrofit
            }
                .client(client.addInterceptor(CloudInterceptor(tag)).build())
                .build()

        fun noInterceptorRetrofit(baseURL: String): Retrofit =
            Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}