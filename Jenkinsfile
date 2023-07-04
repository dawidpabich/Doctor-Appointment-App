pipeline {
  agent any
  
  stages {
    stage('Download repository') {
      steps {
        git branch: 'main',
        url: 'https://github.com/dawidpabich/Doctor-Appointment-App.git'
      }
    }

    stage('Build and Test') {
      steps {
        sh 'docker run --rm -v $PWD:/app -w /app maven:3.8.4-openjdk-11 mvn clean test'
      }
    }
    
    stage('Package') {
      steps {
        sh 'docker run --rm -v $PWD:/app -w /app maven:3.8.4-openjdk-11 mvn package'
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
