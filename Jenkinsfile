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
                    commit_msg = sh (script: 'git log -5 --pretty=%B ${GIT_COMMIT}', returnStdout: true).trim()
                    echo '${commit_msg}'
                }
            }
        }
    }
}