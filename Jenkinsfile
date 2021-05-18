pipeline {
    agent any

    stages {
        stage("Git clone") {
            steps {
                git url: 'https://github.com/fabriciolfj/spring-kubernetes-simple.git', branch: 'jenkins-windows'
            }
        }

        stage("Build project") {
            steps {
                script {
                    "mvn clean package"
                }
            }
        }
    }
}