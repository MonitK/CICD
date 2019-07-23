pipeline {
    agent any

    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                                   '''
            }
        }

        stage ('Build') {
            steps {
                dir("/home/redhat/aapgit/recipes") {
                sh 'mvn -Dmaven.test.failure.ignore=true -U clean install'
                }
               
            }
        }
       
 stage ('Deploy') {
            steps {
                dir("/home/redhat/aapgit/recipes") {
                sh 'mvn spring-boot:run'
                }
               
            }
}
       
    }
}
