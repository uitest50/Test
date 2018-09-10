def call(String buildResult) {
  if ( buildResult == "SUCCESS" ) {
    slackSend color: "good",  message: "*Job*: ${env.JOB_NAME} \n *BuildNumber* : ${env.BUILD_NUMBER} \n *Result*: PASS \n *Jenkins Build URL*: ${env.BUILD_URL}console "
  }
  else if( buildResult == "FAILURE" ) { 
    slackSend color: "danger", message: "*Job*: ${env.JOB_NAME} \n *BuildNumber* : ${env.BUILD_NUMBER} \n *Result*: FAIL \n *Jenkins Build URL*: ${env.BUILD_URL}console  "
  } 
  else if( buildResult == "UNSTABLE" ) { 
    slackSend color: "warning", message: "*Job*: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was unstable"
  }
  else {
    slackSend color: "danger", message: "*Job*: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} its result was unclear"	
  }
}

slackNotifier(currentBuild.currentResult)

library 'Jenkins-shared-library'