job('job-DSL') {
  description('Job DSL de ejemplo para el curso de Jenkins')
  scm {
        git('https://github.com/LuisRuizLemas/Job-In-Team.git', 'main') { node ->
          node / gitConfigName('LuisRuizLemas')
          node / gitConfigEmail('desarprac@gmail.com')
        }
  }
  parameters {
    choiceParam('n1',['1','2','3','4','5','6','7'])
    choiceParam('n2',['8','9','10','11','12','13','14',])
    booleanParam('invertir',false)
  }
  
  triggers{
    cron('H/7 * * * *')
   
  }
  steps{
    shell("bash prueba.sh")
  }
  publishers {
    mailer('desarprac@gmail.com', true, true)
    mailer('luisgjenkins@gmail.com', true, true)
    slackNotifier {
      notifyAborted(true)
      notifyEveryFailure(true)
      notifyNotBuilt(false)
      notifyUnstable(false)
      notifyBackToNormal(true)
      notifySuccess(false)
      notifyRepeatedFailure(false)
      startNotification(false)
      includeTestSummary(false)
      includeCustomMessage(false)
      customMessage(null)
      sendAs(null)
      commitInfoChoice('NONE')
      teamDomain(null)
      authToken(null)
    }
  }
  
}
