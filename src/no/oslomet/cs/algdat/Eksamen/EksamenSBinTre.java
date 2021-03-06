package no.oslomet.cs.algdat.Eksamen;


import javax.swing.tree.TreeNode;
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

        Node<T> p = rot, q = null;
        int cmp = 0;

        while (p != null)
        {
            q = p;
            cmp = comp.compare(verdi,p.verdi);
            p = cmp < 0 ? p.venstre : p.høyre;
        }


        p = new Node<>(verdi,q);

        if (q == null) rot = p;
        else if (cmp < 0) q.venstre = p;
        else q.høyre = p;

        antall++;
        return true;
    }

    public boolean fjern(T verdi) {

        if (verdi == null) return false;

        Node<T> p = rot, q = null;

        while (p != null)            // leter etter verdi
        {
            int cmp = comp.compare(verdi,p.verdi);      // sammenligner
            if (cmp < 0) { q = p; p = p.venstre; }      // går til venstre
            else if (cmp > 0) { q = p; p = p.høyre; }   // går til høyre
            else break;
        }
        if (p == null) return false;

        if (p.venstre == null || p.høyre == null)
        {
            Node<T> b = p.venstre != null ? p.venstre : p.høyre;
            if (p == rot) {
                rot = b;
                if (b != null)
                    b.forelder = null;
            }
            else if (p == q.venstre) {
                q.venstre = b;
                if (b != null)
                    b.forelder = q;
            }
            else{
                q.høyre = b;
                if (b != null)
                    b.forelder = q;
            }
        }
        else
        {
            Node<T> s = p, r = p.høyre;
            while (r.venstre != null)
            {
                s = r;
                r = r.venstre;
            }

            p.verdi = r.verdi;

            if (s != p)
                s.venstre = r.høyre;
            else s.høyre = r.høyre;

        }

        antall--;
        return true;
    }

    public int fjernAlle(T verdi) {
        int ant = antall(verdi), teller = 0;

        for (int i = 0; i<ant;i++) {
            fjern(verdi);
            teller++;
        }

        antall = antall-teller;
        return teller;
    }

    public int antall(T verdi) {
        int teller = 0;

        if (tom() || verdi == null) return teller;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp==0){
                teller++;
                p = p.høyre;
            }
            else if (cmp < 0)
                p = p.venstre;

            else  p = p.høyre;
        }
        return teller;
    }

    public void nullstill() {

        for (T r : serialize())
            fjernAlle(r);

        antall = 0;
    }

    private static <T> Node<T> førstePostorden(Node<T> p) {

        while (p!=null){
            if (p.venstre != null)p = p.venstre;
            else if (p.høyre != null)p=p.høyre;
            else return p;
        }
        return null;

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

        if (p.venstre != null)postordenRecursive(p.venstre, oppgave);//til venstre barn
        if (p.høyre != null)postordenRecursive(p.høyre,oppgave);//til høyre barn
        oppgave.utførOppgave(p.verdi);//utfør oppgaven
    }

    public ArrayList<T> serialize() {

        ArrayList<T> array = new ArrayList<>(); // Arrayet som skal returneres

        Deque<Node> ko = new LinkedList<>(); //Køen som brukes for å lagere verdiene midlertidig før vi overfører de til array

        if (rot != null)ko.add(rot); //Roten skal være første verdien i nivåorden

        while(!ko.isEmpty()) {//sjekker om kø er tom, hvis ja returnerer vi array

            Node<T> tmp = ko.poll(); //her lagerer vi noden som er øverst i køen midlertidig og så fjerner vi det fra køen

            array.add(tmp.verdi); //Her legges øverste verdien i array
            if(tmp.venstre!=null) //I nivåorden skal venstre veriden komme før høyre
                ko.add(tmp.venstre); //Legger venstre til array
            if(tmp.høyre!=null)//Hvis tmp.høyre finnes adder vi den til ko
                ko.add(tmp.høyre);
        }
        return array;
    }

    static <K> EksamenSBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {

        EksamenSBinTre<K> tre = new EksamenSBinTre<>(c);

        for (K d : data)
            tre.leggInn(d);

        return tre;
    }
} // ObligSBinTre
