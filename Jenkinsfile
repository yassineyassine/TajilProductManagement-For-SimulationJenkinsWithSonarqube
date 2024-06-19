pipeline {
    agent any
    environment {
        BUILD_NUMBER_ENV = "${env.BUILD_NUMBER}"
        TEXT_SUCCESS_BUILD = "[#${env.BUILD_NUMBER}] Project: ${JOB_NAME} build Success"
        TEXT_FAILURE_BUILD = "[#${env.BUILD_NUMBER}] Project: ${JOB_NAME} build Failure"
    }
    
    stages {
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

         stage('Build Docker Image') {
            steps {
                script {
                    bat 'docker build -t aandocker629/tpm-springboot-1.0 .'
                    echo 'Build Docker Image Completed'
                }
            }
        }

        stage('Docker Push') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhub-password')]) {
                        bat ''' docker login -u aandocker629 -p "%dockerhub-password%" '''
                    }
                    bat 'docker push aandocker629/tpm-springboot-1.0'
                }
            }
        }

        stage ('Docker Run') {
            steps {
                script {
                    bat 'docker run -d --name tpm-springboot-1.0 -p 8099:8080 aandocker629/tpm-springboot-1.0'
                    echo 'Docker Run Completed'
                }
            }
        }
    }

    post {
        always {
            bat 'docker logout'
        }
    }
}
