package com.yucfangxiaoyun.yucfirsttestdemo.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yucfangxiaoyun.yucfirsttestdemo.database.entities.Course

@Dao
interface CourseDao {
    // we can query the course table by querying
    @Query("SELECT * FROM course")
    fun getAllCourses(): List<Course>

    // we can add some course into the student table
    @Insert
    fun insertCourses(vararg courses: Course)

    // we can delete some courses from student table
    @Query("DELETE FROM course WHERE couId = :courseId")
    fun deleteStudents(courseId: Int)

    // we can select course from their id.
    @Query("SELECT couId FROM course WHERE course_name = :courseName LIMIT 1")
    fun getCourseIdAccordingName(courseName: String): Long
}