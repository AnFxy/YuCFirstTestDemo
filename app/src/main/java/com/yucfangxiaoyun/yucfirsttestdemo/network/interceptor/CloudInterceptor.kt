package com.yucfangxiaoyun.yucfirsttestdemo.network.interceptor

import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response

class CloudInterceptor : Interceptor {

    override fun intercept(chain: Chain): Response {
        val request = chain.request()
        val oldUrl = request.url
        val newUrl = oldUrl.newBuilder()
            .scheme("https")
            .host("636224377521369cd065d55e.mockapi.io")
            .encodedPath("/api/true/request/students")
            .setEncodedQueryParameter("time", "2")
            .build()
        val newRequest = request.newBuilder().url(newUrl).build()
        return chain.proceed(newRequest)
    }
}