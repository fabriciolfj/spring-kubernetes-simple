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
                    "./mvnw clean install"
                }
            }
        }

        stage("Build image") {
            steps {
                script {
                    dockerapp = docker.build("fabricio211/product-service:${env.BUILD_ID}")
                }
            }
        }

        stage("Push image") {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                        dockerapp.push('latest')
                        dockerapp.push("${env.BUILD_ID}")
                    }
                }
            }
        }
    }
}