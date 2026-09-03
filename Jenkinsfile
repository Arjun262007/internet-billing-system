pipeline {
    agent any

    stages {
        // We removed the broken manual checkout stage because Jenkins handles it automatically
        
        stage('Compile Application') {
            steps {
                // Compiles the source files
                sh 'mvn clean compile'
            }
        }

        stage('Execute Unit Testing') {
            steps {
                // Runs your JUnit test cases
                sh 'mvn test'
            }
        }

        stage('Package Binary Archive') {
            steps {
                // Builds the final executable JAR file
                sh 'mvn package -DskipTests'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
}

