CLS

@REM Der Client muss mit folgenden Informationen gestartet werden:
@REM - -Djava.security.policy=policy (policy-Datei)
@REM - -Djava.security.manager
@REM Unter Umständen ist noch die Angabe des CLASSPATH notwendig


SET APPBASE=D:/aeJavaTraining/work/Java7_RMIServer/dist

java  -Djava.security.manager  -Djava.security.policy=policy -Djava.rmi.server.codebase=file:/%APPBASE%/Java7_RMIServer.jar -jar Java7_RMIClient.jar