package com.yucfangxiaoyun.yucfirsttestdemo.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = true) val stuId: Long? = null,
    @ColumnInfo(name = "student_name") val stuName: String,
)
