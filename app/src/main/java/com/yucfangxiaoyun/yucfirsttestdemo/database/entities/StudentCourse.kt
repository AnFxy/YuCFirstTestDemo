package com.yucfangxiaoyun.yucfirsttestdemo.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StudentCourse(
    @PrimaryKey val stuCouId: Long? = null,
    @ColumnInfo(name = "student_id") val stuId: Long,
    @ColumnInfo(name = "course_id") val couId: Long,
)
