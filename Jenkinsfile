node {

    stage("Git Clone"){

        git url: 'https://github.com/fabriciolfj/spring-kubernetes-simple', branch: 'jenkins'
    }

    stage('Maven Build') {

       sh "./mvnw clean install -DskipTests"

    }

    stage("Docker build"){
        sh 'docker version'
        sh 'docker build -t fabricio211/product-service:3.0.0 .'
    }

    stage("Docker Login"){
        sh 'docker login -u fabricio211 -p megatron12'
    }

    stage("Push Image to Docker Hub"){
        sh 'docker push  fabricio211/product-service:3.0.0'
    }

        stage("SSH Into k8s Server") {
            withKubeConfig([credentialsId: 'spark', serverUrl: 'https://192.168.49.2:8443']) {
              ssh  "kubectl apply -f ./ -R"
            }
        }
}