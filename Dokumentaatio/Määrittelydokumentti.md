# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen avulla on tarkoitusta seurata työaikoja. Sovellukseen on mahdollisuus rekisteröityä käyttäjällä. Sovelluksessa kaikilla on oma työaikaseuranta jonka avulla voidaan kartoittaa esim. viimeviikon kokonaistyöaikaa.

## Käyttäjät

Sovellus luodaan aluksi yhdellä käyttäjällä, työntekijällä. Myöhemmin saatetaan lisätä mahdollisuus rekisteröityä esimiehenä jolloin voi tarkastella muiden käyttäjien työaikoja yms.

## Käyttöliittymäluonnos

Käyttöliittymässä on neljä ruutua, yksi sisäänkirjautumiselle, yksi uuden käyttäjän luonnille, yksi työajan sisään- ja ulosleimaukselle ja viimeinen leimausten ja muun datan tarkastamiselle.



## Perusversion tarjoama toiminnallisuus

### Ennen Kirjautumista

- Käyttäjä voi luoda uuden tunnuksen
  - Uniikkikäyttäjätunnus, minimi 4 merkkiä. Muodostetaan esim. sukunimi 3 ensimmäistä kirjainta ja etunimen ensimmäinen kirjain.
  
 - Käyttäjä voi kirjautua järjestelmään
   - Käyttäjän tarvitsee tietää vain tunnus, ja jatkossa ehkä salasana
   - Jos käyttäjää ei ole, ei voi kirjautua sisään (Huomautusikkuna/error)
   
### Kirjautumisen jälkeen
 
 - Käyttäjä voi leimata työnajan alkaneeksi
 - Käyttäjä voi leimata työajan loppuneeksi
 - Käyttäjä voi kirjautua ulos järjestelmästä
 - Käyttäjä voi nähdä edelliset työaikansa (esim. kuukauden ajalta)
 
## Jatkokehitysideoita

Perusversion jälkeen voidaan sovellukseen lisätä paljon toiminnallisukksia, esim. koko työporukan keskityöaikaa yms.

- Esimiestunnukset
- Työaikojen korjaukset jälkeenpäin
- Pidempi työaikahistoria
- Palkanmaksu työajan mukaan
- Vapaapäivät yms. poikkeustilanteet
- Salasana käyttäjätunnukselle
- hienoja kuvaajia yms. dataa
