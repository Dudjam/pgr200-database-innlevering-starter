# Dokumentasjon 

Navn: Benjamin Le, William Nordli
Feide-ID: leben17, norwil17

Det ble dessverre en veldig manglende innlevering. I sluttfasen begynte alt å falle litt på plass, hvor vi kunne se betydelig fremgang, men det ble dessverre ikke nok tid til et solid sluttprodukt for oss. 
Enkelte deler av programmet (spesielt midlertidige løsninger og tester, som lesing av innlevering.properties, måtte jeg kommentere ut for å få "mvn package" til å kjøre. Fikk dessverre heller ikke mye tid til å teste den endelige .jar filen og maven oppsettet, men fungerer tilsynelatende som det skal på min ende. 
Men alt i alt, etter at vi kom ordentlig igang, så har det vært en morsom og interessant oppgave å jobbe med.

##Inkluderer dokumentasjonen hvordan man tester ut funksjonaliteten programmet manuelt?

Da vi ikke har kommet helt i mål skal funksjonaliteten være lett testbar ved å kjøre koden med ett av tre argumenter: "insert", "list" og "cleanup" (uten anførselstegn, og cleanup er en funksjon vi la til under utvikling for å tømme alle rader i "conference_talks" i databasen på en kjapp måte.).

##Inkluderer dokumentasjonen en evaluering av hvordan man jobbet sammen?

Vi fikk ordnet grupppe sent, som førte til at vi hadde lite tid å jobbe med arbeidskravet. Så vi hadde ikke mye oppmøte og det førte til at kommunikasjonen var mest digitalt.

##Inkluderer dokumentasjonen av screencast av en parprogrammeringsesjon? 

Siden vi hadde så dårlig tid, rakk vi desverre ikke å gjennomføre parprogrammeringsesjonen. 

##Inkluderer dokumentasjonen en evaluering fra en annen gruppe og en evaluering til en annen gruppe?

Vi hadde ikke nok tid til å få tilbakemelding fra en annen gruppe, siden vi prioriterte å fullføre oppgaven.

# PGR200 Innlevering 2: JDBC og databaser

Innleveringsfrist: 1. november.

## Oppgave

Dere skal utvikle et enkelt program som kan lese og skrive informasjon til en database. Programmet skal lese og skrive foredrag til en konferanse med foredrag fordelt over flere dager, tidspunkt og parallelle sesjoner. Programmet trenger ikke å håndere avansert brukerinput med mindre dere ønsker det som en oppvarming til eksamen.

Programmet skal følge god programmeringsskikk: Det skal ha enhetstester, det skal ha en god README-dokumentasjon, det skal hente inn konfigurasjon fra en .properties-fil. Det bør også bygge automatisk på [Travis CI](https://travis-ci.com).

Pass på at det er godt med tester, at koden kompilerer og kjører ok med "mvn test" og at du beskriver hvordan man tester løsningen manuelt.

Eksempel kjøring:

```bash
> mvn test
> mvn package
> Oppdater innlevering.properties med database settings
> java -jar target/database-innlevering.jar resetdb
> java -jar target/database-innlevering.jar insert "Mitt foredrag"
> java -jar target/database-innlevering.jar list
```

Dere skal trene på parprogrammering under innleveringen. I tillegg til koden i GitHub skal dere ta opp en video på 3-8 minutter der dere parprogrammerer. Velg gjerne en bit med kode som dere refactorerer. Screencast-o-matic anbefales som verktøy for video-opptaket, men andre verktøy kan benyttes. En lenke til videoen skal leveres og ikke videoen selv. Husk å åpne for tilgang til videoen ("unlisted" i Youtube) og legge inn lenke fra README.

Dere skal også gi tilbakemelding på en annen gruppes besvarelse. Tilbakemeldingen skal skrives i en egen fil (tilsvarende format som en README-fil) og inkluderes både i deres prosjekt og den andre gruppens prosjekt. Tilbakemeldingen dere har mottatt skal ligge i en fil som heter `MOTTATT-TILBAKEMELDING.md` og tilbakemeldingen dere har gitt skal hete `GITT-TILBAKEMELDING.md`.


### Datamodell:

![Architecture Overview](doc/datamodell.png)

## Sjekkliste for innleveringen

- [ ] Kodekvalitet
    - [ ] Produserer `mvn package` en executable jar? (tips: Bruk `maven-shade-plugin`)
    - [x] Bruker koden Java 8 og UTF-8
    - [ ] ~~Bygger prosjektet på https://travis-ci.com?
    - [ ] ~~Har du god test-dekning? (tips: Sett opp jacoco-maven-plugin til å kreve at minst 65% av linjene har testdekning)
    - [x] Kobler main-klassen seg opp mot PostgreSQL ved hjelp av en properties-fil?
    - [ ] ~~Kan main-klassen resette databasen? (tips: Bruk Flyway#clear)
- [x] Funksjonalitet
    - [x] Kan man legge inn et nytt foredrag?
    - [x] Kan man liste foredrag i databasen?
    - [ ] ~~Valgfritt: Oppretter main-klassen et konferanseprogram med flere dager og tracks?~~
    - [ ] ~~Valgfritt: Kan main-klassen vise konferanseprogrammet?~~
- [x] Dokumentasjon i form av README.md
    - [x] Navn og Feide-ID på dere de som var på teamet
    - [x] Inkluderer dokumentasjonen hvordan man tester ut funksjonaliteten programmet manuelt? (Inkludert eventuell ekstra funksjonalitet dere har tatt med)
    - [x] Inkluderer dokumentasjonen en evaluering av hvordan man jobbet sammen?
    - [ ] ~~Inkluderer dokumentasjonen en screencast av en parprogrammeringsesjon?
    - [ ] ~~Inkluderer dokumentasjonen en evaluering _fra_ en annen gruppe og en evaluering _til_ en annen gruppe?
    - [ ] ~~Inkluderer dokumentasjonen et databasediagram
    - [ ] ~~Inkluderer dokumentasjonen en link til screencast av programmeringsesjon?

## Forberedelse

- [x] Finn en grupperpartner innen 16. oktober
    - [x] De som ikke har en partner innen 16. oktober blir tildelt en annen
- [ ] ~~Finn en gruppe for gjensidig evaluering innen 23. oktober

## Innlevering

1. Husk å endre README.md-fila. Her skal dere skrive hvordan man tester ut serveren. Dere kan også skrive en vurdering av deres eget resultat. Husk å skrive hvem dere begge er slik at vi ser hvem som har levert sammen.
2. Tag repositoriet med "innlevering" for å markere den committen dere vil leverer inn på. Dere kan jobbe videre dersom dere vil utforske oppgaven videre, men dere vil få tilbakemelding på "innlevering"-taggen. Her er git kommandoene:
  * git tag innlevering
  * git push --tags
3. Dere vil nå se taggen repository på github.com ved å trykke på "1 Release" (rett ved siden av antall commits etc). Her vil det være en link for zip-fil. Denne kan dere laste opp i Wiseflow.
4. Det er fint om du legger til veilederne hakonschutt og mudasar187 som collaborators under Settings > Collaborators på github.com, så sparer dere oss for tid.

Det er zip-fila som er den offisielle innleveringen, men dere vil få praktisk tilbakemelding via github.
