pipeline {
    agent any
    tools {
        maven 'maven_3.8.6'
    }
    stages {
        stage('Build Maven') {
            steps {
                sh 'mvn -version'
                checkout([$class: 'GitSCM', branches: [[name: '*/dev']],
                 extensions: [], userRemoteConfigs: [[url: 'https://github.com/tamizh1991/dockerdemo.git']]])
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t tamizh2sss/docker-demo:2.8.$BUILD_NUMBER .'
                }
            }
        }
         stage('Docker Login') {
            steps {
                script {
                    sh 'docker login -u $github_username_USR -p $github_username_PSW '
                }
            }
        }        
        stage('Push Docker Image') {
                steps {
                    script {
                        sh 'docker image push tamizh2sss/docker-demo:2.8.$BUILD_NUMBER '
                    }
                }
        }
    }
}
