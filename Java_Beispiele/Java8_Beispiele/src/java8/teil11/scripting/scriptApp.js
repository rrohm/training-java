#!/usr/bin/jjs -fv
// Hinweis zur Verwendung: Zuerst jjs-Konsole aufrufen!
// Diese Beispiel wird Zeile für Zeile an der jjs-Konsole eingegeben: 

// Typ-Import und Referenz auf die JS-Konstruktorfunktionen:
var JFrame = Java.type("javax.swing.JFrame");
var JLabel = Java.type("javax.swing.JLabel");

// Instanzierung und Verwendung
var f = new JFrame();
var l = new JLabel('Hallo?');
f.add(l);
f.pack();
f.setVisible(true);

// danach: Anwendung live manipulieren! Z.B.:
l.setText('Etwas Neues?');
