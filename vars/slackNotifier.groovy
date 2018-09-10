def call(String buildResult) {
  if ( buildResult == "SUCCESS" ) {
    slackSend color: "good", message: "*Job*: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was successful"
  }
  else if( buildResult == "FAILURE" ) { 
    slackSend color: "danger", message: "*Job*: ${env.JOB_NAME} \n *buildnumber* : ${env.BUILD_NUMBER} \n *Result*:${env.BUILD_STATUS} FAIL \n *Jenkins Build URL*:${env.BUILD_URL}+"/console"+ "
  } 
  else if( buildResult == "UNSTABLE" ) { 
    slackSend color: "warning", message: "*Job*: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was unstable"
  }
  else {
    slackSend color: "danger", message: "*Job*: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} its resulat was unclear"	
  }
}