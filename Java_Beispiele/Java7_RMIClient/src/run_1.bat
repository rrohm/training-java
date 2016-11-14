CLS

@REM Der Client muss mit folgenden Informationen gestartet werden:
@REM - -Djava.security.policy=policy (policy-Datei)
@REM - -Djava.security.manager
@REM Unter UmstÃ¤nden ist noch die Angabe des CLASSPATH notwendig

@REM Variante mit codebase, security.manager und policy intern in App festgelegt

SET APPBASE=R:/AEONIUM/WORK-ONLINE/aeJavaTraining/work/Java7_RMIServer/dist

java  -jar Java7_RMIClient.jar