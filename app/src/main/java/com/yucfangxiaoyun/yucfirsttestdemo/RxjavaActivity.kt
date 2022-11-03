package com.yucfangxiaoyun.yucfirsttestdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yucfangxiaoyun.yucfirsttestdemo.common.Constants
import com.yucfangxiaoyun.yucfirsttestdemo.database.AppDatabase
import com.yucfangxiaoyun.yucfirsttestdemo.databinding.ActivityRxjavaBinding
import com.yucfangxiaoyun.yucfirsttestdemo.network.service.ICloudService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*
import java.util.stream.Collectors

/**
 *  逻辑如下： 我们首先从一些数据进行变换组合等操作，得到的数据作为网络请求的参数
 *  网络请求后的response我们转成Observable被观察者，然后经过一系列的数据操作后得到最后Observable
 *  最后在需要使用的地方进行订阅，期间再涉及一些线程切换等操作，尽量将Rxjava的操作符都涉及
 */
class RxjavaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRxjavaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRxjavaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    // 从用户输入两个人的id查询到相应的名字组合成一起
    private fun initView() {
        binding.btnRequestTeamGrade.setOnClickListener {
            startFlow()
        }
    }

    private fun startFlow() {
        // 先拿到id，可能会出现一些问题
        val firstStudentId = binding.editFirstStudentId.text.toString().toInt()
        val secondStudentId = binding.editSecondStudentId.text.toString().toInt()

        val rxjavaDao = AppDatabase.getDatabase(this).rxjavaStudentDao()

        val observableList = listOf(
            rxjavaDao.selectStudentName(firstStudentId).subscribeOn(Schedulers.io()),
            rxjavaDao.selectStudentName(secondStudentId).subscribeOn(Schedulers.io())
        )

        Single.zip(observableList) {
            Arrays.stream(it)
                .map { streamAny -> streamAny.toString() }
                .collect(Collectors.toList())
        }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                // 拿到结果后进行网络请求。
                var builder = ""
                it.forEach { str ->
                    builder += str
                }
                ICloudService.provide(Constants.TEAMGRADE).selectTeamGrade(builder)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        { studentsList ->
                            binding.txtNetWorkContent.text = studentsList.toString()
                        }, { throwAble ->
                            throwAble.printStackTrace()
                        }
                    )
            }, {
                it.printStackTrace()
            })
    }
}