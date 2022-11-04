package com.yucfangxiaoyun.yucfirsttestdemo.network.service

import com.yucfangxiaoyun.yucfirsttestdemo.database.entities.TrueStudent
import com.yucfangxiaoyun.yucfirsttestdemo.network.RetrofitConfig
import com.yucfangxiaoyun.yucfirsttestdemo.network.response.Fruits
import com.yucfangxiaoyun.yucfirsttestdemo.network.response.StudentGrade
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ICloudService {

    @GET("fake/requst/")
    suspend fun getStudents(
        @Query("time") timeNow: Int
    ): List<TrueStudent>

    @GET("select/teamgrade")
    fun selectTeamGrade(
        @Query("teamname") teamName: String
    ): Single<List<StudentGrade>>

    @GET("fruits")
    suspend fun selectRemoteDataByPaging(
        @Query("nextpagenumber") nextPageNumber: Int
    ): List<Fruits>

    companion object{
        fun provide(tag: String): ICloudService {
            return RetrofitConfig.interceptorRetrofit(tag).create(ICloudService::class.java)
        }
    }
}