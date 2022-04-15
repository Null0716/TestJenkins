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
        stage('Clean') {
            steps {
                sh './gradlew clean'
            }
        }
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
                    def COMMIT_MSG = sh (script: 'git log -1 --pretty=%B ${GIT_COMMIT}', returnStdout: true).trim()
                    COMMIT_MSG = COMMIT_MSG.replaceAll('\n', '')
                    COMMIT_MSG = COMMIT_MSG.replaceAll(': ', '')
                    echo COMMIT_MSG
                    sh 'echo '+COMMIT_MSG
                    sh 'fastlane pre_release commit_msg:'+COMMIT_MSG
                }
            }
        }
    }
}