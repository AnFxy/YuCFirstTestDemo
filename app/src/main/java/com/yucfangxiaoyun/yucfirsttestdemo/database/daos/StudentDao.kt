package com.yucfangxiaoyun.yucfirsttestdemo.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yucfangxiaoyun.yucfirsttestdemo.database.entities.Student

// we add a student dao interface to operator the student class
@Dao
interface StudentDao {

    // we can query the student table by querying
    @Query("SELECT * FROM student")
    suspend fun getAllStudents(): List<Student>?

    // we can add some student into the student table
    @Insert
    suspend fun insertStudents(vararg students: Student)

    // we can delete some students from student table
    @Query("DELETE FROM student WHERE stuId = :userId")
    suspend fun deleteStudents(userId: Int)

    // we can select student from their id.
    @Query("SELECT stuId FROM student WHERE student_name = :studentName LIMIT 1")
    suspend fun getStudentIdAccordingName(studentName: String): Long?
}