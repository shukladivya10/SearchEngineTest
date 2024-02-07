pipeline {
    agent any
    
    environment {
        DEV_SUITE_XML = "src/test/resources/regression-suite-dev.xml"
        PROD_SUITE_XML = "src/test/resources/regression-suite-prod.xml"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                script {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Build and Test') {
            steps {
                script {
                    def suiteXmlFile

                    // Check if the environment variable is set and use the appropriate testng.xml file
                    if (env.ENVIRONMENT == 'dev') {
                        suiteXmlFile = DEV_SUITE_XML
                    } else if (env.ENVIRONMENT == 'prod') {
                        suiteXmlFile = PROD_SUITE_XML
                    } else {
                        error "Invalid environment specified"
                    }

                    // Run Maven test command with the dynamically determined suiteXmlFile
                    sh "mvn test -DsuiteXmlFile=${suiteXmlFile}"
                }
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/TEST-*.xml'
        }
    }
}