pipeline {
    agent any

    tools {
        maven 'MAVEN_HOME' // Asegúrate de que esté configurado en Jenkins
    }

    stages {
        stage('Clone') {
            steps {
                cleanWs()
                git branch: 'main', url: 'https://github.com/DiegoAlonso26/ExamenDespliegue.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Sonar Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh 'mvn sonar:sonar -Pcoverage'
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Docker Build & Run') {
            steps {
                script {
                    sh '''
                        docker stop alonso_app || true
                        docker rm alonso_app || true
                        docker rmi micro/product:1.0.0 || true

                        docker build -t micro/product:1.0.0 -f docker/Dockerfile .
                        docker run -d --name alonso_app -p 8086:8080 micro/product:1.0.0
                    '''
                }
            }
        }
    }

    post {
        success {
            echo '✅ Pipeline ejecutado correctamente.'
        }
        failure {
            echo '❌ Falló el pipeline.'
        }
    }
}
