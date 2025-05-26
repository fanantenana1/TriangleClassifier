pipeline {
    agent any

    tools {
        maven 'Maven_Jenkins'
        jdk 'Java_Jenkins'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', credentialsId: 'git_credentials', url: 'https://github.com/fanantenana1/TriangleClassifier.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        failure {
            emailext(
                subject: "Build Failed",
                body: "Le build Jenkins a échoué.",
                to: "votre-email@example.com"
            )
        }
    }
}
