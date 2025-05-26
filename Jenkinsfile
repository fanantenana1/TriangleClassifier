pipeline {
    agent any
    tools {
        maven 'Maven_Jenkins'   // Nom configuré dans "Global Tool Configuration"
        jdk 'Java_Jenkins'      // Nom configuré dans Jenkins
    }
    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'github-creds', url: 'https://github.com/fanantenana1/TriangleClassifier.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Unit Tests') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build -t monuser/triangle-classifier:1.0.0 .'
            }
        }
        stage('Docker Push') {
            steps {
                withCredentials([string(credentialsId: 'dockerhub-pass', variable: 'dockerPass')]) {
                    sh 'docker login -u monuser -p $dockerPass'
                }
                sh 'docker push monuser/triangle-classifier:1.0.0'
            }
        }
    }
    post {
        failure {
            emailext(
                subject: "Build Failed",
                body: "Le build Jenkins a échoué",
                to: "votre-email@example.com"
            )
        }
    }
}

