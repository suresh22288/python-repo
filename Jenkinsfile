pipeline {
    agent any

    parameters {
        string(name: 'name', defaultValue: 'suresh-default', description: 'Enter first parameter')
        string(name: 'emailid', defaultValue: 'suresh22288@gmail.com', description: 'Enter second parameter')
    }

    environment {
        EMAIL_RECIPIENT = 'suresh22288@gmail.com'  // Replace with your actual email
    }

    stages {

        stage('Checkout Code') {
            steps {
                echo "Checking out the code from GitHub..."
                git url: 'https://github.com/suresh22288/python-repo.git', branch: 'feature/python-pipeline'  // Change URL and branch
            }
        }

        stage('Execute Python Script') {
            steps {
                echo "Running main.py with PARAM1=${params.name} and PARAM2=${params.emailid}"
                sh "python main.py ${params.name}"
            }
        }

    }
}

