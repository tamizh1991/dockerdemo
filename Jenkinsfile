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
                 withCredentials([usernamePassword(credentialsId: 'amazon', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    // available as an env variable, but will be masked if you try to print it out any which way
                    // note: single quotes prevent Groovy interpolation; expansion is by Bourne Shell, which is what you want
                    sh 'echo $PASSWORD'
                    // also available as a Groovy variable
                    echo USERNAME
                    // or inside double quotes for string interpolation
                    echo "username is $USERNAME"
                    sh 'docker login -u $USERNAME -p $PASSWORD'
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
