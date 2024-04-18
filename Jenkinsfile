pipeline {
    agent any
    tools {
        maven 'jenkins-maven'
    }
    environment {
        BUILD_NUMBER_ENV = "${env.BUILD_NUMBER}"
        TEXT_SUCCESS_BUILD = "[#${env.BUILD_NUMBER}] Project: ${JOB_NAME} build Success"
        TEXT_FAILURE_BUILD = "[#${env.BUILD_NUMBER}] Project: ${JOB_NAME} build Failure"
    }
    
    stages {
        stage('Git Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/aan629/TajilProductManagement-For-SimulationJenkinsWithSonarqube']])
                bat 'mvn clean install'
                echo 'Git Checkout Completed'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn clean install'
                    sh 'mvn clean package verify sonar:sonar'
                    echo 'SonarQube Analysis Completed'
                }
            }
        }
        stage("Quality Gate") {
            steps {
                waitForQualityGate abortPipeline: true
                echo 'Quality Gate Completed'
            }
        }
    }
}