pipeline{
    agent any
    tools {	
        maven "maven_3.8.6"	
    }
    stages{
        stage("Build Maven"){
            steps{
		 sh "mvn -version"
                checkout([$class: 'GitSCM', branches: [[name: '*/dev']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/tamizh1991/dockerdemo.git']]])
                sh "mvn clean install"
            }
            
        }
        stage("Build Docker Image"){
            steps{
                script{
			sh "docker build -t tamizh2sss/docker-demo ."
		}
            }
        }
    }
post{
	always{
		cleanWs()		
	}
	
	}
}
