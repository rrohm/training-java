 # Kompilierung mit dem javac-Compiler
 javac MeineAnwendung.java 
 
 # Ausführung direkt aus der Startklasse
 java MeineAnwendung 
 
 # Alternativ: Ausführbares Archiv erzeugen, d.h. 
 # erst Manifest-Datei erstellen: 
 vim.tiny Manifest.txt

Name: MeineAnwendung
Main-Class: MeineAnwendung

 
# dann packen, 
jar cvfm MeineAnwendung.jar Manifest.txt  MeineAnwendung.class 
 
 #... dann aus Paket ausführen
java -jar MeineAnwendung.jar 