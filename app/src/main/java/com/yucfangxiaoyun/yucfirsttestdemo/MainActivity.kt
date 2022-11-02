package com.yucfangxiaoyun.yucfirsttestdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.yucfangxiaoyun.yucfirsttestdemo.database.AppDatabase
import com.yucfangxiaoyun.yucfirsttestdemo.database.entities.Course
import com.yucfangxiaoyun.yucfirsttestdemo.database.entities.Student
import com.yucfangxiaoyun.yucfirsttestdemo.database.entities.StudentCourse
import com.yucfangxiaoyun.yucfirsttestdemo.databinding.ActivityMainBinding
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
    lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)
        initView()
    }

    fun initView() {
        dataBinding.btnGoToSecondActivity.setOnClickListener {
            startActivity(Intent(this@MainActivity, NetWorkActivity::class.java))
        }
//        dataBinding.btnAddStudent.setOnClickListener {
//            addStudent()
//        }
//
//        dataBinding.btnAddCourse.setOnClickListener {
//            addCourse()
//        }
//
//        dataBinding.btnAddStucourse.setOnClickListener {
//            addStuCourse()
//        }
//
//        dataBinding.btnSelectAllStudentInfo.setOnClickListener {
//            selectAllStudents()
//        }
//
//        dataBinding.btnSelectAllCourseInfo.setOnClickListener {
//            selectAllCourses()
//        }
//
//        dataBinding.btnSelectSpecialStudentCourse.setOnClickListener {
//            selectSpecialStudentCourse()
//        }
    }

//    fun addStudent() {
//        lifecycleScope.launchWhenResumed {
//            dataBinding.txtContent.text = ""
//            try {
//                val studentDao = AppDatabase.getDatabase(this@MainActivity).studentDao()
//                val studentName = dataBinding.editStudentName.text.toString()
//                val student = Student(stuName = studentName)
//                studentDao.insertStudents(student)
//            } catch (e: Exception) {
//                delay(500)
//                e.printStackTrace()
//                dataBinding.txtContent.text = "add student error"
//                return@launchWhenResumed
//            }
//            delay(500)
//            dataBinding.txtContent.text = "add student successful"
//        }
//    }
//
//    fun addCourse() {
//        lifecycleScope.launchWhenResumed {
//            dataBinding.txtContent.text = ""
//            try {
//                val courseDao = AppDatabase.getDatabase(this@MainActivity).courseDao()
//                val courseName = dataBinding.editCourseName.text.toString()
//                val course = Course(
//                    couId = Constants.constantsId,
//                    couName = courseName
//                )
//                courseDao.insertCourses(course)
//            } catch (e: Exception) {
//                delay(500)
//                dataBinding.txtContent.text = "add course error"
//                return@launchWhenResumed
//            }
//            delay(500)
//            dataBinding.txtContent.text = "add course successful"
//        }
//    }
//
//    fun addStuCourse() {
//        lifecycleScope.launchWhenResumed {
//            dataBinding.txtContent.text = ""
//            try {
//                val studentDao = AppDatabase.getDatabase(this@MainActivity).studentDao()
//                val courseDao = AppDatabase.getDatabase(this@MainActivity).courseDao()
//                val stuCouDao = AppDatabase.getDatabase(this@MainActivity).studentCourseDao()
//                val stuCouStudentName = dataBinding.editStucouStuName.text.toString()
//                val stuCouCourseName = dataBinding.editStucouCourseName.text.toString()
//                val studentId = studentDao.getStudentIdAccordingName(stuCouStudentName)
//                val courseId = courseDao.getCourseIdAccordingName(stuCouCourseName)
//                val stuCou = StudentCourse(
//                    stuCouId = Constants.constantsId,
//                    stuId = studentId ?: 0,
//                    couId = courseId
//                )
//                stuCouDao.addStuCourse(stuCou)
//            } catch (e: Exception) {
//                delay(500)
//                dataBinding.txtContent.text = "add student-course error"
//                return@launchWhenResumed
//            }
//            delay(500)
//            dataBinding.txtContent.text = "add student-course successful"
//        }
//    }
//
//    fun selectAllStudents() {
//        lifecycleScope.launchWhenResumed {
//            dataBinding.txtContent.text = ""
//            try {
//                val studentDao = AppDatabase.getDatabase(this@MainActivity).studentDao()
//                val students = studentDao.getAllStudents()
//                var multiString = ""
//                students?.forEach {
//                    multiString += "${it.stuId} + ${it.stuName}"
//                }
//                delay(500)
//                dataBinding.txtContent.text = multiString
//            } catch (e: Exception) {
//                delay(500)
//                dataBinding.txtContent.text = "select student error"
//                return@launchWhenResumed
//            }
//        }
//    }
//
//    fun selectAllCourses() {
//        lifecycleScope.launchWhenResumed {
//            dataBinding.txtContent.text = ""
//            try {
//                val courseDao = AppDatabase.getDatabase(this@MainActivity).courseDao()
//                val courses = courseDao.getAllCourses()
//                var multiString = ""
//                courses.forEach {
//                    multiString += "${it.couId} + ${it.couName}"
//                }
//                delay(500)
//                dataBinding.txtContent.text = multiString
//            } catch (e: Exception) {
//                delay(500)
//                dataBinding.txtContent.text = "select course error"
//                return@launchWhenResumed
//            }
//        }
//    }
//
//    fun selectSpecialStudentCourse() {
//        lifecycleScope.launchWhenResumed {
//            dataBinding.txtContent.text = ""
//            try {
//                val stuCouDao = AppDatabase.getDatabase(this@MainActivity).studentCourseDao()
//                val studentNames = stuCouDao.specialSelect()
//                delay(500)
//                dataBinding.txtContent.text = studentNames.toString()
//            } catch (e: Exception) {
//                delay(500)
//                dataBinding.txtContent.text = "select special student-course error"
//                return@launchWhenResumed
//            }
//        }
//    }
}