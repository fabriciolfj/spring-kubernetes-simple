node {

    stage("Git Clone"){

        git credentialsId: 'GIT_HUB_CREDENTIALS', url: 'https://github.com/fabriciolfj/spring-kubernetes-simple', branch: 'jenkins'
    }

    stage('Maven Build') {

       sh 'mvn clean package'

    }

    stage("Docker build"){
        sh 'docker version'
        sh 'docker build -t fabricio211/product-service:3.0.0 .'
    }

    stage("Docker Login"){
        withCredentials([string(credentialsId: 'DOCKER_HUB_PASSWORD', variable: 'PASSWORD')]) {
            sh 'docker login -u fabricio211 -p megatron12'
        }
    }

    stage("Push Image to Docker Hub"){
        sh 'docker push  fabricio211/product-service:3.0.0'
    }

    stage("SSH Into k8s Server") {
        stage('Deploy spring boot') {
          sshCommand remote: remote, command: "kubectl apply -f ./ -R"
        }
    }
}