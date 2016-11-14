/**
 * Beispiel: Zwei Threads, synchronisiert auf demselben Lock-Objekt,
 * Thread-Koordination mit wait() und notifyAll().
 * Fazit: Der erste Thread, der in den synchronen Block läuft, gibt zum
 * definierten Punkt die Ausführung an einen anderen Thread weiter, indem er
 * zuerst notifyAll() und dann wait() auf dem Lock-Objekt aufruft. Er verliert
 * damit den Monitor! Damit kann ein anderer Thread auf dem Lock-Objekt arbeiten.
 *
 * Achtung! Hier sieht es so aus, als ob zwei Threads sich gleichzeitig
 * innerhalb ihres synchronized-Blocks (auf demselben Objekt!!!) befänden.
 * Dies ist nur scheinbar so, da mit Aufruf von wait() der Monitor abgegeben
 * wird.
 */
package org.meins.threads.basics03_syncMitWait;
