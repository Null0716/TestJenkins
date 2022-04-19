#!/usr/bin/env groovy

pipeline{
    agent {
        label "master"
    }
    stages{
        stage('Stop Previous Running Build') {
            steps {
                milestone label: '', ordinal:  Integer.parseInt(env.BUILD_ID) - 1
                milestone label: '', ordinal:  Integer.parseInt(env.BUILD_ID)
            }
        }
//        stage('Clean') {
//            steps {
//                sh './gradlew clean'
//            }
//        }
//        stage('Detekt'){
//            steps{
//                sh './gradlew detekt'
//            }
//        }
//        stage('Build'){
//            parallel{
//                stage('build-debug-apk'){
//                    steps{
//                        retry(count: 2){
//                            sh './gradlew assembleDebug'
//                        }
//                    }
//                }
//            }
//        }

        stage('shell'){
            steps{
                script{
                    def BRANCH_NAME = env.GIT_BRANCH.trim().replaceAll('\n', '；')
                    def COMMIT_MSG = sh (script: 'git log -5 --pretty=%B ${GIT_COMMIT}', returnStdout: true).trim()
//                    COMMIT_MSG = COMMIT_MSG.replaceAll('\n\n', '；')
//                    COMMIT_MSG = COMMIT_MSG.replaceAll(':', '：')
//                    COMMIT_MSG = COMMIT_MSG.replaceAll(' ', '_')
                    def APP_CENTER_MSG = BRANCH_NAME+"；"+COMMIT_MSG
                    echo '提交日志:'+APP_CENTER_MSG

//                    sh 'echo '+branch_name+";"+COMMIT_MSG
//                    sh 'fastlane pre_release commit_msg:'+COMMIT_MSG
                }
            }
        }
    }
}