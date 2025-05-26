pipeline {
    agent any

    tools {
        maven 'Maven_nom_sur_Jenkins'  // Le nom Maven configuré dans Global Tools
    }

    stages {
        stage('Git Checkout') {
            steps {
                git branch: 'main', credentialsId: 'git_credentials', url: 'https://github.com/fanantenana1/TriangleClassifier.git'
            }
        }

        stage('Build the application') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
}
