node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/ihuaylupo/test.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.
      mvnHome = tool 'M2_HOME'
   }
   stage('Build') {
      // Run the maven build
      withEnv(["MVN_HOME=$mvnHome"]) {
         if (isUnix()) {
            sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
         } else {
            bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean package/)
         }
      }
   }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archiveArtifacts 'configserver/target/*.jar'
   }
    stage('Build image') {
        sh "'${mvnHome}/bin/mvn' -Ddocker.image.prefix=333000609522.dkr.ecr.us-east-1.amazonaws.com/fabricio211 -Dproject.artifactId=product -Ddocker.image.version=9.0.1 dockerfile:build"
    }
    stage('Push image') {
        docker.withRegistry('https://819XXXXXX43.dkr.ecr.us-east-2.amazonaws.com', 'ecr:us-east-2:ecr-user') {
            sh "docker push 819XXXXXX43.dkr.ecr.us-east-2.amazonaws.com/ostock/configserver:latest"
        }
    }
   stage('Kubernetes deploy') {
       kubernetesDeploy configs: 'deployment.yml', kubeConfig: [path: ''], kubeconfigId: 'kubeconfig', secretName: '', ssh: [sshCredentialsId: '*', sshServer: ''], textCredentials: [certificateAuthorityData: '', clientCertificateData: '', clientKeyData: '', serverUrl: 'https://']
    }

}
