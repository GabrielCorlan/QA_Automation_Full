pipeline {
    agent any

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
            when {
                expression {
                    BRANCH_NAME == 'master' || CODE_CHANGES == true
                }
            }
            steps {
                // This stage builds your project using Maven
                // Example: sh 'mvn clean install'
                bat 'mvn clean install'
            }
        }

        stage('Run Tests') {
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                // This stage executes your Selenium tests using TestNG
                // Example: sh 'mvn test'
//                 sh 'mvn test'
                bat "mvn test"
            }
        }

        stage('Deploy') {
            when {
                expression { currentBuild.resultIsBetterOrEqualTo('UNSTABLE') }
            }
            steps {
                // This stage deploys your application (if applicable)
                // Example: sh 'deploy_script.sh'
                bat 'deploy_script.sh'
                echo 'deploying the application'
            }
        }
    }

    post {
        always {
            // This block will run after all stages, regardless of success or failure
            // For example, you can clean up resources here
            echo "cleaning the system files"
        }
        failure {
            echo "send email to somebody"
        }
    }
}