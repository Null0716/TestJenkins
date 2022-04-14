package cn.test.com.testjenkins

import cn.parch.com.Orchestrator

interface MainOrchestrator: Orchestrator

class MainOrchestratorImpl():Orchestrator{
    override fun onStart() {
    }
}