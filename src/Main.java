import no.oslomet.cs.algdat.Eksamen.EksamenSBinTre;
import no.oslomet.cs.algdat.Eksamen.Oppgave;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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

        /*

        int[] a = {10, 6, 14, 1, 8, 12, 3, 7, 9, 11, 13, 2, 5, 4};


        EksamenSBinTre<Integer> tre = new EksamenSBinTre<>(Comparator.naturalOrder());

        for (int verdi : a)tre.leggInn(verdi);

        AtomicReference<String> postorden = new AtomicReference<>();
        Oppgave<Integer> oppgave = c -> postorden.set(postorden.get() + " " + c.toString()) ;


        postorden.set("");
        tre.postordenRecursive(oppgave);
        assertEquals(postorden.get(), " 2 4 5 3 1 7 9 8 6 11 13 12 14 10");

         */

        /*
        EksamenSBinTre<Integer> tre =
                new EksamenSBinTre<>(Comparator.naturalOrder());

        int[] a = {10, 14, 6, 8, 1, 12, 7, 3, 11, 9, 13, 5, 2, 4};
        for (int verdi : a) tre.leggInn(verdi);

        ArrayList<Integer> data = tre.serialize();

        Integer[] truth = {10, 6, 14, 1, 8, 12, 3, 7, 9, 11, 13, 2, 5, 4};
        assertArrayEquals(data.toArray(), truth);



        for (int i : data)
            System.out.print(i + " ");

         */



        int[] a = {10, 6, 14, 1, 8, 12, 3, 7, 9, 11, 13, 2,3, 5, 4};


        EksamenSBinTre<Integer> tre = new EksamenSBinTre<>(Comparator.naturalOrder());

        for (int verdi : a)tre.leggInn(verdi);

        System.out.println(tre.fjern(3));
        System.out.println(tre.fjern(3));


        System.out.println(tre.inneholder(3));










    }
}
