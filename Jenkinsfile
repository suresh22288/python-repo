pipeline {
    agent any

    parameters {
        string(name: 'name', defaultValue: 'suresh-default', description: 'Enter your name')
        string(name: 'emailid', defaultValue: 'suresh22288@gmail.com', description: 'Enter your email address')
    }

    environment {
        EMAIL_RECIPIENT = "${params.emailid}"
    }

    stages {

        stage('Checkout Code') {
            steps {
                echo "Checking out code from GitHub..."
                git url: 'https://github.com/suresh22288/python-repo.git', branch: 'feature/python-pipeline'
            }
        }

        stage('Execute Python Script') {
            steps {
                script {
                    echo "Running main.py with parameters: ${params.name}, ${params.emailid}"
                    try {
                        sh "python main.py ${params.name} ${params.emailid}"
                    } catch (err) {
                        echo "Script failed: ${err.getMessage()}"
                        currentBuild.result = 'FAILURE'
                        throw err
                    }
                }
            }
        }
    }

    post {
        success {
            echo "Build succeeded. Sending success email to ${EMAIL_RECIPIENT}"
            emailext(
                to: "${EMAIL_RECIPIENT}",
                subject: "Build Success: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: 'Build Successful',
                mimeType: 'text/html'
            )
        }

        failure {
            echo "Build failed. Sending failure email to ${EMAIL_RECIPIENT}"
            emailext(
                to: "${EMAIL_RECIPIENT}",
                subject: "Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: 'Build failed',
                mimeType: 'text/html'
            )
        }
    }
}

