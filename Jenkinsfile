#!/usr/bin/env groovy

pipeline{
    agent {
        label "Pipeline Test Jenkins Label"
    }
    stages{
        stage('Stop Previous Running Build') {
            when {
                anyOf{
                    branch 'main';
                }
            }
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
        stage('Build'){
            parallel{
                stage('build-debug-apk'){
                    when {
                        anyOf {
                            branch 'main';
                        }
                    }
                    steps{
                        retry(count: 2){
                            sh 'sh ci-scripts/build-debug.sh'
                        }
                    }
                }
            }
        }
    }
}