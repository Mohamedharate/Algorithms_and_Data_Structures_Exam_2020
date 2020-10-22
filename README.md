# Mappeeksamen i Algoritmer og Datastrukturer Høst 2020

# Krav til innlevering

Se oblig-tekst for alle krav, og husk spesielt på følgende:

* Git er brukt til å dokumentere arbeid (minst 2 commits per oppgave, beskrivende commit-meldinger)	
* git bundle er levert inn
* Hovedklassen ligger i denne path'en i git: src/no/oslomet/cs/algdat/Eksamen/EksamenSBinTre.java
* Ingen debug-utskrifter
* Alle testene i test-programmet kjører og gir null feil (også spesialtilfeller)
* Readme-filen her er fyllt ut som beskrevet


# Beskrivelse av oppgaveløsning (4-8 linjer/setninger per oppgave)

Vi har brukt git til å dokumentere arbeidet vårt. Jeg har 16 commits totalt, og hver logg-melding beskriver det jeg har gjort av endringer.

* Oppgave 1: I denne oppgaven kopierte jeg koden fra kompendiet, Programkode 5.2 3 a). 
Jeg gjorde noen endringer som for eksempel å gi forelder riktig referanse. Koden består av en while-løkke
og to pekere q og p der q er forelder til p. I tillegg brukes comparator for å sammenligne verdiene. Hvis 
verdi(input) er større enn p.verdi går vi til høyre og hvis verdi er mindre går vi til venstre, helt til
p blir lik "null". Når p er lik null, er q siste noden vi passerte. Vi oppretter en node med q som forelder. 
Hvis q er null da vil p blir den nye roten. Antall økes med en for hver gang vi legger til.

 
* Oppgave 2: løste jeg ved å først sjekke om treet er tomt, hvis så returnerer jeg 0 siden treet er tomt og ikke har
noen verdier. Oppretter en variabel "teller" og setter den lik null. Sjekker om verdi == null, hvis returnerer jeg 0.
Videre brukte jeg en while-løkke som går gjennom treet og teller blir økt med 1 for hver gang verdi forekommer.
Her må jeg være ærlig og si at jeg fikk litt inspirasjon av metoden inneholder. Til slutt blir teller returnert.

* Oppgave 3: Denne oppgaven brukte jeg mest tid på.

- førstePostorden: denne løste jeg ved å bruke while-løkke som kjører så lenge p ikke er lik null.
inn i while sjekker jeg hvis p.venstre ikke er like så oppdaterer jeg p til p.venstre. Hvis det er ikke lenger mulig 
å gå til venstre sjekker jeg om det er mulig å gå til høyre. til slutt når det er verken mulig å gå til venstre eller 
høyre returnerer jeg p. 

- nestePostorden: Her sjekker jeg om p.forelder er lik null, hvis ja returner jeg null siden rot er den siste i
postorden. Videre sjekker jeg om p er høyre eller venstre barn. Hvis p er et høyre barn, skal p.forelder være neste 
verdi i postorden. Sjekker om p har høyre søsken, hvis ja kjører jeg førstePostorden(p.forelder.høyre) for å finne første noden.
Hvis ikke returner jeg p.forelder siden den er neste i postorden.

* Oppgave 4: 
- Metoden postorden løste jeg ved først å finne første verdien i postorden ved å bruke metoden førstePostorden() og 
lagret verdien i en variabel p. Deretter brukte jeg en while-løkke som kjører så lenge p ikke er lik null. 
Før jeg gikk til neste i postorden utførte jeg oppgaven "oppgave.utførOppgave(p.verdi)" så finner jeg neste i postorden
ved bruk av metoden nestePostorden(p).

- Metoden postordenRecursive() gjorde samme som postorden, men bare recursive :). Går til venstre så lenge det lar seg 
gjøre så gå til høyre hvis mulig og så utfør oppgaven.

* Oppgave 5:
- Metoden serialize løste jeg ved å bruke hjelpetabell Deque. Sjekker først at rot ikke er lik null, 
hvis ja legger jeg til køen. Så bruker jeg en while-løkke som kjører så lenge kø ikke er tom. Oppretter en hjelpervariabel
som lagerer innholdet som er øverst i køen.(rot skal komme først i nivåorden, hvis den har venstre barn kommer de etter 
, hvis ikke sjekker om den har høyre barn) Legger verdien i et arraylist som skal returneres. Videre sjekker jeg at
tmp.venstre ikke er lik null, hvis ja legger vi verdien til i køen. Og så sjekker vi om høyre er heller ikke lik null
hvis ja legger vi også verdien i køen. Til slutt returnerer jeg arrayet.
 
- Metoden deserialize denne løste jeg ved å opprette et tre. Og så legge til verdiene fra serialize ved bruk
av foreach og leggInn()-metoden.

* Oppgave 6:
- I metoden fjen() kopierte jeg koden fra kompandiet, men endret referansene til forelder og passet på at kode
ikke gir nullpointer.. Det første koden gjør er at 

- fjenAlle() her brukte jeg metodene antall(T verdi) og fjen(). kjørte en for-løkke som skulle kjøre fjern 
så mange ganger som den er i treet. 
Til slutt returnerer jeg antall og trekker antall noder fjernet fra antall.

- nullstille() løste jeg med bruk av serialize() og fjenAlle(). Brukte en foreach-løkke som gikk gjennom alle 
verdiene i serialize og fjernet de ved bruk av fjerAlle(). Antall settes til 0.

