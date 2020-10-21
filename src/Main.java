import no.oslomet.cs.algdat.Eksamen.EksamenSBinTre;
import no.oslomet.cs.algdat.Eksamen.Oppgave;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    public static void main(String[] args) {
        /*
        EksamenSBinTre<String> tre = new EksamenSBinTre<>(Comparator.naturalOrder());
        System.out.println(tre.antall()); // Utskrift: 0

         */

        /*
        Integer[] a = {4,7,2,9,5,10,8,1,3,6};
        EksamenSBinTre<Integer> tre = new EksamenSBinTre<>(Comparator.naturalOrder());

        for (int verdi : a) tre.leggInn(verdi);
        System.out.println(tre.antall());
         */


        int[] a = {10, 6, 14, 1, 8, 12, 3, 7, 9, 11, 13, 2, 5, 4};


        EksamenSBinTre<Integer> tre = new EksamenSBinTre<>(Comparator.naturalOrder());

        for (int verdi : a)tre.leggInn(verdi);

        AtomicReference<String> postorden = new AtomicReference<>();
        Oppgave<Integer> oppgave = c -> postorden.set(postorden.get() + " " + c.toString()) ;


        postorden.set("");
        tre.postordenRecursive(oppgave);
        assertEquals(postorden.get(), " 2 4 5 3 1 7 9 8 6 11 13 12 14 10");












    }
}
