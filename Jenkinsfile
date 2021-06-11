node {
   def mvnHome
      stage('Preparation') { // for display purposes
         git 'https://github.com/fabriciolfj/spring-kubernetes-simple.git'
         mvnHome = tool 'M2_HOME'
      }
   stage('Build') {
      // Run the maven build
      withEnv(["M2_HOME=$mvnHome"]) {
         if (isUnix()) {
            sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
         } else {
            bat(/"%M2_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean package/)
         }
      }
   }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archiveArtifacts '**/target/*.jar'
   }
    stage('Build image') {
        sh "'${mvnHome}/bin/mvn' -Ddocker.image.prefix=fabricio211 -Dproject.artifactId=product -Ddocker.image.version=9.0.1 dockerfile:build"
    }
    stage('Push image') {
        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
            sh "docker push fabricio211/product:9.0.1"
        }
    }
   stage('Kubernetes deploy') {
       kubernetesDeploy configs: 'configserver-deployment.yaml', kubeConfig: [path: ''], kubeconfigId: 'kubeconfig', secretName: '', ssh: [sshCredentialsId: '*', sshServer: ''], textCredentials: [certificateAuthorityData: '', clientCertificateData: '', clientKeyData: '', serverUrl: 'https://']
    }

}