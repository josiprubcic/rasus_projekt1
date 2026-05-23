# RASUS Projekt 1 – Sustav senzora i očitanja

Ovaj repozitorij sadrži rješenje prvog projekta iz kolegija RASUS. Projekt modelira distribuirani sustav senzora u kojem se senzori registriraju na centralni poslužitelj, šalju svoja očitanja i mogu dohvatiti najbliži susjedni senzor na temelju geografskih koordinata.

Projekt je podijeljen u dvije glavne cjeline:

- `1dz-server-template` – Spring Boot REST server
- `Client-template` – Java klijentska aplikacija koja predstavlja senzor

Server služi kao centralna komponenta sustava. On prima registracije senzora, pohranjuje podatke o senzorima i očitanjima te omogućuje dohvat najbližeg susjeda. Klijent predstavlja pojedini senzor koji se pokreće kao zaseban proces, registrira se na server i šalje očitanja.
