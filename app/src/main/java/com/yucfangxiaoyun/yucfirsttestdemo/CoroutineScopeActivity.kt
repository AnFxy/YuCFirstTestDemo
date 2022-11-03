package com.yucfangxiaoyun.yucfirsttestdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.yucfangxiaoyun.yucfirsttestdemo.databinding.ActivityCoroutineScopBinding
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineScopeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoroutineScopBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineScopBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.btnStartCoroutine.setOnClickListener {
            lifecycleScope.launchWhenResumed {
                launch {
                    delay(200)
                    val currentTime = System.currentTimeMillis() % 1000
                    binding.txtOne.text = "第一个出现的时机：$currentTime"
                }
                // 阻塞协程， 如果coroutineScope内所有的子协程没有执行完毕，程序不会往下走
                coroutineScope {
                    launch {
                        delay(500)
                        val currentTime = System.currentTimeMillis() % 1000
                        binding.txtTwo.text = "第二个出现的时机：$currentTime"

                    }
                    launch {
                        delay(100)
                        val currentTime = System.currentTimeMillis() % 1000
                        binding.txtThree.text = "第三个出现的时机：$currentTime"
                    }
                }

                // 这里的程序代码是最后执行的
                val currentTime = System.currentTimeMillis() % 1000
                binding.txtFour.text = "第四个出现的时机：$currentTime"
            }
        }
    }
}
