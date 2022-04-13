package cn.parch.com

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

interface Orchestrator: LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(){}

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(){}

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(){}
}