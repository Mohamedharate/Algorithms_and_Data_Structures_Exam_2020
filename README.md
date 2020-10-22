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

- nestePostorden: 

* Oppgave 4: 

* Oppgave 5: 

* Oppgave 6: 




Løste ved å implementere ...
