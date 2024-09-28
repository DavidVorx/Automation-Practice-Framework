pipeline {
    agent any

    tools {
        maven 'Maven 3.6.3'
        jdk 'JDK 17'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/DavidVorx/Automation-Practice-Framework', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}