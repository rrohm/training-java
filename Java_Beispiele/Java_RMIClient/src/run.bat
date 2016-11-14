CLS

@REM Der Client muss mit folgenden Informationen gestartet werden:
@REM - -Djava.security.policy=policy (policy-Datei)
@REM - -Djava.security.manager
@REM Unter Umständen ist noch die Angabe des CLASSPATH notwendig

java  -Djava.security.manager  -Djava.security.policy=policy  org.meins.rmi.client.BerechnungsClient