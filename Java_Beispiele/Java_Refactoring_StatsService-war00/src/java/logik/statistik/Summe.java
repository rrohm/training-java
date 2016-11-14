/*
 */
package logik.statistik;

/**
 * Ausgelagerte Geschäftslogik, jetzt abgetrennt vom Service, um sie separat
 * testbar zu machen.
 *
 * @author Trainer
 */
public class Summe {

    /**
     * Summenberechnung - zustandslos, keine Instanz nötig,
     * daher auch gut statisch implementierbar. 
     * 
     * @param werte
     * @return 
     */
    public static int berechne(int[] werte) {

        int summe = 0;
        for (int wert : werte) {
            summe += wert;
        }
        
        return summe;
    }
}
