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
                sh 'mvn clean package -DskipTests'
				archiveArtifacts artifacts: '**/target/*.war', fingerprint: true 
            }
        }
		
		stage('Test') {
            steps {
				/** junit 'target/surefire-reports/*.xml'*/
            }
        }
		
		stage('Code Analysis') {
            steps {
                sh 'mvn -batch-mode -V -U -e checkstyle:checkstyle pmd:pmd pmd:cpd findbugs:findbugs'
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
		
    }
}