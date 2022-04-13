package cn.parch.com

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import cn.parch.com.BR

abstract class ParchActivity<O:Orchestrator>: AppCompatActivity() {
    private lateinit var orchestrator:O
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(orchestrator)
        setContentView(onCreateView())
    }
    fun setOrchestrator(orchestrator: O){
        this.orchestrator = orchestrator
    }

    private fun onCreateView() = inflateDataBinding().apply {
        setVariable(BR.presenter,orchestrator)
        lifecycleOwner = this@ParchActivity
        executePendingBindings()
    }.root

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(orchestrator)
    }

    abstract fun inflateDataBinding():ViewDataBinding
}