pipeline {
    agent {
        label "default"
    }

    environment {
        github = credentials('github-cred-object')
    }

    stages {
        stage("Tool Info") {
            steps {
                sh "forge --version"
                sh "opctl --version"
            }
        }

        stage("On Pull Request") {
            when {
                not {
                    branch "main"
                }
            }

            stages {
                stage("Build") {
                    steps {
                        sh "mvn package"
                    }
                }
            }
        }

        stage("On Merge to deploy branch") {
            when {
                branch "deploy"
            }

            stages {
                stage("deploy to maven") {
                    steps {
                        sh "mvn deploy"
                    }
                }
            }
        }
    }
}
