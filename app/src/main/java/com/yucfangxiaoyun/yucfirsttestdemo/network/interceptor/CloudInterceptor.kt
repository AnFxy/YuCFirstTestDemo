package com.yucfangxiaoyun.yucfirsttestdemo.network.interceptor

import com.yucfangxiaoyun.yucfirsttestdemo.common.Constants
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response

// 关于Request，Response等拦截应用需要等待之前项目代码上传后参考
class CloudInterceptor(val tag: String) : Interceptor {

    override fun intercept(chain: Chain): Response {
        val request = chain.request()
        val oldUrl = request.url
        val tripleValue = getNewPath(tag)
        val newUrl = oldUrl.newBuilder()
            .scheme("https")
            .host("636224377521369cd065d55e.mockapi.io")
            .encodedPath(tripleValue.first)
            .setEncodedQueryParameter(
                encodedName = tripleValue.second,
                encodedValue = tripleValue.third
            )
            .build()
        val newRequest = request.newBuilder().url(newUrl).build()
        return chain.proceed(newRequest)
    }

    private fun getNewPath(tag: String): Triple<String, String, String> =
        when (tag) {
            Constants.STUDENTS -> Triple("/api/true/request/students", "time", "2")
            Constants.TEAMGRADE -> Triple("/api/true/request/teamgrade", "teamname", "dfgd")
            else -> Triple("", "", "")
        }
}