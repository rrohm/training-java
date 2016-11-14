/**
 * Beispiel: Zwei Threads, synchronisiert auf demselben Lock-Objekt,
 * mit Sleep-Zeit - Demonstration eines sehr ungünstigen Falls.
 * Fazit: Der erste Thread, der in den synchronen Block läuft, bleib in der
 * darin laufenden Schleife, während der Sleep-Zeit bleibt die Sperre
 * auf dem Lock-Objekt bestehen. Der erste Thread wartet - und der zweite muss
 * auch warten. In der Praxis äußerst unerwünscht.
 */
package org.meins.threads.basics02_syncMitSleep;
