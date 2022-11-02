package com.yucfangxiaoyun.yucfirsttestdemo

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.room.Room
import com.yucfangxiaoyun.yucfirsttestdemo.database.AppDatabase

class MyApplication : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}
