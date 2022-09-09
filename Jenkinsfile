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
                    branch "deploy"
                }
            }

            stages {
                stage("Build") {
                    steps {
                        sh "opctl run build"
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
                        sh "opctl run publish"
                    }
                }
            }
        }
    }
}
