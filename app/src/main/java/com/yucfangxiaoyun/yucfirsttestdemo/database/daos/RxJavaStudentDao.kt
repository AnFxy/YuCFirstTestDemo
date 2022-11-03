package com.yucfangxiaoyun.yucfirsttestdemo.database.daos

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.rxjava3.core.Single

@Dao
interface RxJavaStudentDao {

    @Query("SELECT student_name FROM student WHERE stuId = :studentID")
    fun selectStudentName(studentID: Int): Single<String>
}