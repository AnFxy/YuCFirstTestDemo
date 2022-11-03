package com.yucfangxiaoyun.yucfirsttestdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.yucfangxiaoyun.yucfirsttestdemo.common.Constants
import com.yucfangxiaoyun.yucfirsttestdemo.databinding.ActivityNetWorkBinding
import com.yucfangxiaoyun.yucfirsttestdemo.network.service.ICloudService
import kotlinx.coroutines.delay

class NetWorkActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNetWorkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNetWorkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.btnRequestNetwork.setOnClickListener {
            // 这个时候我们在主线撤出那个启动一个携程去进行网络请求
            requestRemoteData()
        }

        binding.btnGoToCoroutineScope.setOnClickListener {
            startActivity(Intent(this@NetWorkActivity, CoroutineScopeActivity::class.java))
        }
    }

    private fun requestRemoteData() {
        lifecycleScope.launchWhenResumed {
            binding.txtNetWork.text = ""
            try {
                val data = ICloudService.provide(Constants.STUDENTS).getStudents(12)
                delay(500)
                binding.txtNetWork.text = data.toString()
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
                delay(500)
                binding.txtNetWork.text = "network error"
            }
        }
    }
}