pipeline {
    agent any

    stages {
        stage('Compile Application') {
            steps {
                // Using 'bat' for Windows command prompt execution
                bat 'mvn clean compile'
            }
        }

        stage('Execute Unit Testing') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package Binary Archive') {
            steps {
                bat 'mvn package -DskipTests'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
}


