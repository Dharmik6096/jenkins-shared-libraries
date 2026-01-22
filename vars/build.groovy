def call(){
  echo "docker file excute"
  sh 'docker compose up -d'
  echo "Docker excute successful"
}
