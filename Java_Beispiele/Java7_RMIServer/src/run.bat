CLS
@REM WARNING: As of Windows 7 SP 1 this does not work: quotes lead to this string being interpreted as window name! 
@REM SET JAVA_HOME="C:\Program Files\Java\jre1.8.0_45"
SET JAVA_HOME=C:\Progra~1\Java\jre1.8.0_45
SET APPHOME=D:\aeJavaTraining\work\Java7_RMIServer\dist
SET APPLIBS=%APPHOME%\lib

SET APPBASE=D:/aeJavaTraining/work/Java7_RMIServer/dist

SET CLASSPATH=.;%APPLIBS%\Java_RMIInterfaces.jar;
java -version

start %JAVA_HOME%\bin\rmiregistry -J-Djava.rmi.server.codebase=file:/%APPBASE%/Java7_RMIServer.jar
pause

%JAVA_HOME%\bin\java -cp %CLASSPATH% -Djava.rmi.server.codebase=file:/%APPBASE%/Java7_RMIServer.jar -Djava.rmi.server.hostname=localhost -Djava.security.policy=policy -jar Java7_RMIServer.jar