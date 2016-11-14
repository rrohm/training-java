
REM Header erstellen mit javah
REM Das Tool arbeitet mit der QUELLCODE-Datei, 
REM wird jedoch mit dem Klassennamen aufgerufen
javah  -o strlen.h org.meins.jni.StrLen

REM Die mit -o angegebene Ausgabe-Datei wird im Arbeitsverzeichnis abgelegt.