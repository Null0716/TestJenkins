package cn.test.com.testjenkins

import android.util.Log
import android.view.LayoutInflater
import cn.parch.com.ParchActivity

class MainActivity : ParchActivity<MainOrchestrator>() {

    override fun inflateDataBinding() = MainActivityDatabinding.inflate(LayoutInflater.from(this)).apply {
        databindingTest.text = " hello dataBinding"
    }

    private fun test(a: Int) {
        Log.i("jiangTest", "$a")
    }
}
