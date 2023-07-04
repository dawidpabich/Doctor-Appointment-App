pipeline {
  agent {
    docker {
      image 'maven:3.8.4-openjdk-11'
      args '-v /var/run/docker.sock:/var/run/docker.sock'
    }
  }
  
  stages {
    stage('Download repository') {
      steps {
        git branch: 'main',
        url: 'https://github.com/dawidpabich/Doctor-Appointment-App.git'
      }
    }

    stage('Build and Test') {
      steps {
        sh 'mvn clean test'
      }
    }
    
    stage('Package') {
      steps {
        sh 'mvn package'
      }
    }
    
    stage('Deploy') {
      steps {
        sh 'docker build -t my-app .'
        sh 'docker run -d -p 8080:8080 my-app'
      }
    }
  }
}
