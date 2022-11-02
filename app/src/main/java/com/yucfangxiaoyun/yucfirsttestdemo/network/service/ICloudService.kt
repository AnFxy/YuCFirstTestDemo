package com.yucfangxiaoyun.yucfirsttestdemo.network.service

import com.yucfangxiaoyun.yucfirsttestdemo.database.entities.TrueStudent
import com.yucfangxiaoyun.yucfirsttestdemo.network.RetrofitConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface ICloudService {

    @GET("fake/requst/")
    suspend fun getStudents(
        @Query("time") timeNow: Int
    ): List<TrueStudent>

    companion object{
        fun provide(): ICloudService {
            return RetrofitConfig.interceptorRetrofit().create(ICloudService::class.java)
        }
    }
}