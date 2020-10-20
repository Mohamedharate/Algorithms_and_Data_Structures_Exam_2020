import no.oslomet.cs.algdat.Eksamen.EksamenSBinTre;

import java.util.Comparator;

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


        Integer[] a = {1,9, 7,9, 1, 6, 1, 5, 1, 4, 1, 1, 1, 3,9,9};

       // Integer[] a = {10,11,5,10,6,1,0,2,10,12,13,10};
        EksamenSBinTre<Integer> tre = new EksamenSBinTre<>(Comparator.naturalOrder());

        for (int verdi : a)tre.leggInn(verdi);

        System.out.println(tre.inneholder(9));




    }
}
