pipeline {
  agent any
  
  stages {
    stage("Build") {
      steps {
        sh "mvn -version"
        sh "mvn clean install:
      }
    }
  }
  post {
    alwasy {
      cleanWs()
    }
  }
}
