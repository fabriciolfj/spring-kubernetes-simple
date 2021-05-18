node {

    stage("Git Clone"){

        git url: 'https://github.com/fabriciolfj/spring-kubernetes-simple', branch: 'jenkins-windows'
    }

    stage('Maven Build') {
       "mvnw clean install"
    }

    stage("Docker build"){
        "docker version"
        "docker build -t fabricio211/product-service:3.0.0 ."
    }

    stage("Docker Login"){
        "docker login -u fabricio211 -p megatron12"
    }

    stage("Push Image to Docker Hub"){
        "docker push  fabricio211/product-service:3.0.0"
    }

    stage("kubernetes") {
        "kubectl apply -f ./ -R"
    }
}