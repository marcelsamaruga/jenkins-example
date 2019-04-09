pipeline {
    agent { docker { image 'maven:3.3.3' } }
    stages {
        stage('build') {
            steps {
                sh 'mvn clean package'
            }
        }
		
		stage('code analysis') {
            steps {
                sh 'mvn clean package checkstyle:checkstyle'
            }
        }
    }
}