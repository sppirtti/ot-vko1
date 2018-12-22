# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen avulla on tarkoitusta seurata työaikoja. Sovellukseen on mahdollisuus rekisteröityä käyttäjällä. Sovelluksessa kaikilla on oma työaikaseuranta jonka avulla voidaan kartoittaa esim. viimeviikon kokonaistyöaikaa.

## Käyttäjät

Sovellukseen on mahdollista luoda käyttäjä. Käyttäjän tarvitsee syöttää vain etunimi ja sukunimi. Käyttäjänimi generoidaan etunimen ensimmäisen kirjaimen ja sukunimen kolmen ensimmäisen kirjaimen yhdistelmänä. Myöhemmin saatetaan lisätä esimiestunnukset joiden avulla voi tarkastella muiden työaikaa.

## Käyttöliittymäluonnos

Käyttöliittymässä on neljä ruutua, yksi sisäänkirjautumiselle, yksi uuden käyttäjän luonnille, yksi työajan sisään- ja ulosleimaukselle ja viimeinen leimausten ja muun datan tarkastamiselle.

<img src="https://github.com/sppirtti/ot2018/blob/master/Dokumentaatio/k%C3%A4ytt%C3%B6liittym%C3%A4%20esim.png" width="750">

## Perusversion tarjoama toiminnallisuus

### Ennen Kirjautumista

- Käyttäjä voi luoda uuden tunnuksen
  - Uniikkikäyttäjätunnus, minimi 4 merkkiä. Muodostetaan ottamalla sukunimi 3 ensimmäistä kirjainta ja etunimen ensimmäinen kirjain
  
 - Käyttäjä voi kirjautua järjestelmään
   - Käyttäjän tarvitsee tietää vain käyttäjänimi
   - Jos käyttäjää ei ole, ei voi kirjautua sisään (virheviesti)
   
### Kirjautumisen jälkeen
 
 - Käyttäjä voi leimata työnajan alkaneeksi
 - Käyttäjä voi leimata työajan loppuneeksi
 - Käyttäjä voi kirjautua ulos järjestelmästä
 - Käyttäjä voi nähdä edelliset työaikansa (14 työkerran ajalta)
 
## Jatkokehitysideoita

Perusversion jälkeen voidaan sovellukseen lisätä paljon toiminnallisukksia, esim. koko työporukan keskityöaikaa yms.

- Esimiestunnukset
- Työaikojen korjaukset jälkeenpäin
- Pidempi työaikahistoria
- Palkanmaksu työajan mukaan
- Vapaapäivät yms. poikkeustilanteet
- Salasana käyttäjätunnukselle
- ohjelman siirtäminen verkkoon
