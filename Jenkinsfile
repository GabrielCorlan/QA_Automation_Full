pipeline {
    agent any
    parameters {
        string(name: 'TEST_VERSION', defaultValue: '1.1.0', description: 'Demo QA Automation Project Version')
        booleanParam(name: 'RUN_TESTS', defaultValue: false, description: 'Mark it as true if you want to trigger a test run')
        choice(name: 'SUITE', choices: ['Smoke tests - UI', 'Smoke - tests - API'], description: 'Available Test Suites')
    }
    stages {
        stage('Checkout') {
            steps {
                // This stage checks out the source code from your version control system
                // For example, if you're using Git, you can use the 'git' step here
                // Example: git 'https://github.com/yourusername/yourrepository.git'
                // GET THE CODE FROM GITHUB
                git "https://github.com/GabrielCorlan/QA_Automation_Full.git"
            }
        }

        stage('Build') {
            steps {
                // This stage builds your project using Maven
                // Example: sh 'mvn clean install'
                bat 'mvn -U clean install'
            }
        }

        stage('Run UI Tests') {
            when {
                equals expected: true, actual: params.RUN_TESTS
                equals expected: 'Smoke tests - UI', actual: params.SUITE
            }
            steps {
                // This stage executes your Selenium tests using TestNG
                // Example: sh 'mvn ui_tests'
//                 sh 'mvn ui_tests'
                bat "mvn ui_tests"
            }
        }

        stage('Run API Tests') {
            when {
                equals expected: true, actual: params.RUN_TESTS
                equals expected: 'Smoke tests - API', actual: params.SUITE
            }
            steps {
                // This stage executes your Selenium tests using TestNG
                // Example: sh 'mvn ui_tests'
                bat "mvn api_tests"
            }
        }

        stage('Deploy') {
//             when {
//                 equals expected: true, actual: deploy
//                 equals expected: false, actual: params.RUN_TESTS
//             }
            steps {
                // This stage deploys your application (if applicable)
                // Example: sh 'deploy_script.sh'
//                 bat 'deploy_script.sh'
                echo "deploying version ${params.VERSION}"
//                 bat "mvn -U clean deploy"
            }
        }
    }

    post {
        always {
            // This block will run after all stages, regardless of success or failure
            // For example, you can clean up resources here
            echo "cleaning the system files"
        }
        success {
            mail(to: 'gabicorlan82@gmail.com',
                 subject: "Successful Test Run on version: ${TEST_VERSION}",
                 body: "Tests ran successfully, check the report.")
        }
        failure {
            echo "send email to somebody"
        }
    }
}