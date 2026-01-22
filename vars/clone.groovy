def call(String url,String branch){
  echo "Take a github repository"
  git url:"${url}" ,branch:"${branch}"
  echo "Github clone Successfully"
}
