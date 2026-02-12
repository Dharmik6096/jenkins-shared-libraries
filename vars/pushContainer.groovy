def call(String credId,String sourceImage,String imageName,String tag){
          
    withCredentials([
        usernamePassword(
            credentialsId: credId,
            usernameVariable: 'DOCKER_HUB_USERNAME',
            passwordVariable: 'DOCKER_HUB_PASSWORD'
        )
    ]) {
        sh "docker login -u $DOCKER_HUB_USERNAME -p $DOCKER_HUB_PASSWORD"
        sh "docker tag ${sourceImage} $DOCKER_HUB_USERNAME/${imageName}:${tag}"
        sh "docker push $DOCKER_HUB_USERNAME/${imageName}:${tag}"
    }
}
