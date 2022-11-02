package com.yucfangxiaoyun.yucfirsttestdemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yucfangxiaoyun.yucfirsttestdemo.Constants
import com.yucfangxiaoyun.yucfirsttestdemo.database.daos.CourseDao
import com.yucfangxiaoyun.yucfirsttestdemo.database.daos.StudentCourseDao
import com.yucfangxiaoyun.yucfirsttestdemo.database.daos.StudentDao
import com.yucfangxiaoyun.yucfirsttestdemo.database.entities.Course
import com.yucfangxiaoyun.yucfirsttestdemo.database.entities.Student
import com.yucfangxiaoyun.yucfirsttestdemo.database.entities.StudentCourse

@Database(entities = [Student::class, Course::class, StudentCourse::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    // we get student dao from appDatabase
    abstract fun studentDao(): StudentDao

    // we get course dao from appDatabase
    abstract fun courseDao(): CourseDao

    // we get student-course dao from appDatabase
    abstract fun studentCourseDao(): StudentCourseDao

    companion object {
        @Volatile
        private var INSTANCE : AppDatabase?= null

        fun getDatabase(context: Context): AppDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    Constants.dataBaseName
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
