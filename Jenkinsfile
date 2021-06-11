pipeline {

agent any

    stages {
        stage("Git clone") {
            steps {
                git url: 'https://github.com/fabriciolfj/spring-kubernetes-simple.git', branch: 'jenkins-v2'
            }
        }

        stage("Build project") {
            steps {
                script {
                    sh './mvnw clean install'
                }
            }
        }

        stage("Build image") {
            steps {
                script {
                    dockerapp = docker.build("fabricio211/product:9.0.1")
                }
            }
        }

        stage("Push image") {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                        dockerapp.push('9.0.1')
                    }
                }
            }
        }

       stage('Kubernetes deploy') {
            steps {
            script {
           kubernetesDeploy configs: 'configserver-deployment.yaml', kubeConfig: [path: ''], kubeconfigId: 'kubeconfig', secretName: '', ssh: [sshCredentialsId: '*', sshServer: ''], textCredentials: [certificateAuthorityData: '', clientCertificateData: '', clientKeyData: '', serverUrl: 'https://']
           }
           }
        }
}