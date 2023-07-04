pipeline {
  agent any
  
  stages {
    
    stage('Download repository') {
            steps {
                git branch: 'main',
                url: 'https://github.com/dawidpabich/Doctor-Appointment-App.git'
            }
        }
    stage('Checkout') {
      steps {
        git 'https://github.com/dawidpabich/Doctor-Appointment-App.git'
      }
    }
    
    stage('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
    
    stage('Test') {
      steps {
        sh 'mvn test'
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
