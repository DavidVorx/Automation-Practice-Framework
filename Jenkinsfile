pipeline {
    agent any

    tools {
        maven 'Maven 3.6.3' // Ensure Maven is installed and configured in Jenkins
        jdk 'JDK 17' // Ensure JDK 17 is installed and configured in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from GitHub
                git url: 'https://github.com/DavidVorx/Automation-Practice-Framework', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                // Build the project using Maven
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                // Run the tests using Maven
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            // Archive test results
            junit 'target/surefire-reports/*.xml'
        }
    }
}