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


        int[] a = {10,10,10,10};

        EksamenSBinTre<Integer> tre = new EksamenSBinTre<>(Comparator.naturalOrder());

        for (int verdi : a)tre.leggInn(verdi);









    }
}
