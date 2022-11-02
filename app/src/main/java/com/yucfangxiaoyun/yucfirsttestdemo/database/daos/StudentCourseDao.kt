package com.yucfangxiaoyun.yucfirsttestdemo.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yucfangxiaoyun.yucfirsttestdemo.database.entities.StudentCourse

@Dao
interface StudentCourseDao {

    // select all student names who choose the all course
    @Query(
        "SELECT student_name FROM Student WHERE stuId IN (SELECT student_id FROM StudentCourse " +
                "GROUP BY student_id HAVING COUNT(*) = (SELECT COUNT(*) FROM course))"
    )
    fun specialSelect(): List<String>

    // insert student-course into student-course table
    @Insert
    fun addStuCourse(vararg studentCourse: StudentCourse)
}