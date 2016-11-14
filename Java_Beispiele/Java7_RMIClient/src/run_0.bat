CLS

@REM Der Client muss mit folgenden Informationen gestartet werden:
@REM - -Djava.security.policy=policy (policy-Datei)
@REM - -Djava.security.manager
@REM Unter Umständen ist noch die Angabe des CLASSPATH notwendig

@REM Auch das geht: codebase außer Kraft setzen
java  -Djava.security.manager -Djava.security.policy=policy -Djava.rmi.server.useCodebaseOnly=false -jar Java7_RMIClient.jar