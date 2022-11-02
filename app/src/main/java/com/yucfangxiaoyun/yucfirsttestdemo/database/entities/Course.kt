package com.yucfangxiaoyun.yucfirsttestdemo.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Course(
    @PrimaryKey val couId: Long? = null,
    @ColumnInfo(name = "course_name") val couName: String,
)
