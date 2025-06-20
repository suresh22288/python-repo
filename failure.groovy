def build = manager.build
def jobName = build.project.name
def buildNumber = build.number
def buildUrl = build.absoluteUrl
def userId = build.getCause(hudson.model.Cause$UserIdCause)?.getUserName() ?: "Automated Trigger"

return """
<html>
  <body>
    <h2 style="color: red;">Build Failed</h2>
    <p><strong>Job:</strong> ${jobName}</p>
    <p><strong>Build #:</strong> ${buildNumber}</p>
    <p><strong>Triggered by:</strong> ${userId}</p>
    <p><strong>URL:</strong> <a href="${buildUrl}">${buildUrl}</a></p>
  </body>
</html>
"""

