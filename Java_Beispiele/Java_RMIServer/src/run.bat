

CLS
SET JAVA_HOME="C:\Program Files\Java\jdk1.7.0_02"
SET CLASSPATH=R:\AEONIUM\WORK-ONLINE\aeJavaTraining\work\Java_RMIServer\build\classes
java -version

start %JAVA_HOME%\bin\rmiregistry
pause
%JAVA_HOME%\bin\java -cp %CLASSPATH% -Djava.rmi.server.codebase=file:/R:/AEONIUM/WORK-ONLINE/aeJavaTraining/work/Java_RMIServer/build/classes/ -Djava.rmi.server.hostname=localhost -Djava.security.policy=policy org.meins.rmi.server.ServerMain