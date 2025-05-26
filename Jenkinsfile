pipeline {
    agent any

    tools {
        maven 'Maven_Jenkins'  // Nom du Maven installé dans Jenkins
        jdk 'Java_Jenkins'     // Nom du JDK installé dans Jenkins
    }

    environment {
        IMAGE_NAME = 'badre09/triang7'
        IMAGE_TAG = '1.0.0'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    credentialsId: 'github-token',
                    url: 'https://github.com/fanantenana1/TriangleClassifier.git'
            }
        }

        stage('Build Maven Project') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Unit Test Execution') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build the Docker Image') {
            steps {
                sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
            }
        }

        stage('Push to DockerHub') {
            steps {
                withCredentials([string(credentialsId: 'dockerhubpass', variable: 'dockerHubPass')]) {
                    sh "docker login -u badre09 -p $dockerHubPass"
                }
                sh "docker push ${IMAGE_NAME}:${IMAGE_TAG}"
            }
        }
    }

    post {
        success {
            echo '✅ Pipeline terminé avec succès !'
        }
        failure {
            echo '❌ Échec du pipeline.'
        }
    }
}
