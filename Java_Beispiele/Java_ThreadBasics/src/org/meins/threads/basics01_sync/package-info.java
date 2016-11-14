/**
 * Beispiel: Zwei ungebremste Threads, synchronisiert auf demselben Lock-Objekt.
 * Fazit: Der erste Thread, der in den synchronen Block läuft, bleib in der
 * darin laufenden Schleife - Demonstration eines unerwünschten Verhaltens.
 */
package org.meins.threads.basics01_sync;
