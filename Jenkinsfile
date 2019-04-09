pipeline {
    agent { 
		docker { 
			image 'maven:3.3.3' 
		} 
	}
    
	stages {
        stage('Info') {
			steps {
				echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}" 
			}
		}
		
		stage('Checkout SCM') {
			steps {
				checkout scm
			}
		}
		
		stage('Build') {
            steps {
                sh 'mvn clean package -DskipTest'
            }
        }
		
		stage('Test') {
            steps {
				echo "Tests results"
				sh 'mvn clean test'
				junit '**/target/*.xml'
            }
        }
		
		stage('Code Analysis') {
            steps {
                sh 'mvn -batch-mode -V -U -e checkstyle:checkstyle pmd:pmd pmd:cpd findbugs:findbugs'
            }
        }
		
		stage('Publish') {
			steps {
				archiveArtifacts artifacts: '**/target/*.war', fingerprint: true 
			}
		}
		
		stage('Deploy') {
            when {
              expression {
                currentBuild.result == null || currentBuild.result == 'SUCCESS' 
              }
            }
            
			steps {
                echo 'Build success'
            }

        }
		
		post {
        always {
            deleteDir()
        }
    }
		
    }
}