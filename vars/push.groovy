def call(String project,String imagetag){
          echo "Push start"

        withCredentials([
            usernamePassword(
                credentialsId: 'django-app',
                usernameVariable: 'DOCKER_HUB_USERNAME',
                passwordVariable: 'DOCKER_HUB_PASSWORD'
            )
        ]) {
            sh 'docker login -u $DOCKER_HUB_USERNAME -p $DOCKER_HUB_PASSWORD'
            sh 'docker tag django_app:latest $DOCKER_HUB_USERNAME/django_app:latest'
            sh 'docker push $DOCKER_HUB_USERNAME/"${project}":"${imagetag}"'
        }

        echo "Push successfully"
}
