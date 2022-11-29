pipeline{
    environment {
        JAVA_TOOL_OPTIONS = "-Duser.home=/var/maven"
    }
    agent {
        docker {
            image "maven:3.8.0-jdk-17"
            label "docker"
            args "-v /tmp/maven:/var/maven/.m2 -e MAVEN_CONFIG=/var/maven/.m2"
        }
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
