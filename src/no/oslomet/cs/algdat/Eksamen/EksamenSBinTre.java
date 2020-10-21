package no.oslomet.cs.algdat.Eksamen;


import java.util.*;

public class EksamenSBinTre<T> {
    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public EksamenSBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");

        Node<T> p = rot, q = null;               // p starter i roten
        int cmp = 0;                             // hjelpevariabel

        while (p != null)       // fortsetter til p er ute av treet
        {
            q = p;                                 // q er forelder til p
            cmp = comp.compare(verdi,p.verdi);     // bruker komparatoren
            p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
        }

        // p er nå null, dvs. ute av treet, q er den siste vi passerte

        p = new Node<>(verdi,q);                 // oppretter en ny node

        if (q == null) rot = p;                  // p blir rotnode
        else if (cmp < 0) q.venstre = p;         // venstre barn til q
        else q.høyre = p;                        // høyre barn til q

        antall++;                                // én verdi mer i treet
        return true;

        /*

        Objects.requireNonNull(verdi,"Ulovlig med nullverdier");

        Node<T> p = rot, q = null;
        int cmp = 0;

        while (p != null){
            q = p;
            cmp = comp.compare(verdi,p.verdi);
            p = cmp < 0 ? p.venstre : p.høyre;
        }

        if (q==null)rot = new Node<>(verdi,q);
        else if(cmp < 0) {
            p = new Node<>(verdi, q);
            q.venstre = p;
        }
        else q.høyre = p;

        antall++;

        return true;

         */
    }

    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int fjernAlle(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int antall(T verdi) {
        if (tom())
            return 0;

        int teller = 0;
        if (verdi == null) return teller;


        Node<T> current = rot;

        while (current != null) {
            int cmp = comp.compare(verdi, current.verdi);
            if (cmp==0){
                teller++;
                current = current.høyre;
            }
            else if (cmp < 0){
                current = current.venstre;
            }
            else  current = current.høyre;
        }
        return teller;
    }

    public void nullstill() {
    }

    private static <T> Node<T> førstePostorden(Node<T> p) {

        //Hvis p har ingen barn, return p
        if (p.venstre == null && p.høyre == null){
            return p;
        }
        Node<T> current = p;

        //Hvis p har venstre barn

        if (p.venstre != null) {
            while (current.venstre != null) {
                current = current.venstre;
            }
        }
        if (current.høyre != null) {
            current = current.høyre;
            if (current.venstre != null){
                while (current.venstre != null) {
                    current = current.venstre;
                }
            }
            else{
                while (current.høyre != null){
                    current = current.høyre;
                }
                return current;
            }
        }
        //Hvis p har kun høyre barn

        return current;
    }

    private static <T> Node<T> nestePostorden(Node<T> p) {

        if (p.forelder == null) // rot er siste verdi i postorden
            return null;

        if (p.forelder.høyre == p){//Hvis p er et høyre barn, p.forelder være neste verdi i postorden
            return p.forelder;
        }
        else if (p.forelder.høyre != null){//Hvis p er venstre barn, kjører vi førstePostorden for å finne første noden
            return førstePostorden(p.forelder.høyre);
        }
        else {
            return p.forelder;//p.forelder har ikke høyre barn, dvs neste verdi i postorder blir p.forelder
        }

    }

    public void postorden(Oppgave<? super T> oppgave) {


        Node<T> p = førstePostorden(rot);
        while (p != null){
            oppgave.utførOppgave(p.verdi);
            p = nestePostorden(p);
        }
    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        postordenRecursive(rot, oppgave);

    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {




        if (p.venstre != null)postordenRecursive(p.venstre, oppgave);
        if (p.høyre != null)postordenRecursive(p.høyre,oppgave);
        oppgave.utførOppgave(p.verdi);
    }

    public ArrayList<T> serialize() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    static <K> EksamenSBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }


} // ObligSBinTre
