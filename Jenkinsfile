node {
   def mvnHome
      stage('Preparation') { // for display purposes
      git url: 'https://github.com/fabriciolfj/spring-kubernetes-simple.git', branch: 'jenkins-v2'
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
    stage('Build image') {
        sh "'${mvnHome}/bin/mvn' spring-boot:build-image"
    }
        stage("Push image") {
            script {
                                docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                                    dockerapp.push('9.0.1')
                                }
                            }
        }
   stage('Kubernetes deploy') {
       kubernetesDeploy configs: 'configserver-deployment.yaml', kubeConfig: [path: ''], kubeconfigId: 'kubeconfig', secretName: '', ssh: [sshCredentialsId: '*', sshServer: ''], textCredentials: [certificateAuthorityData: '', clientCertificateData: '', clientKeyData: '', serverUrl: 'https://']
    }

}