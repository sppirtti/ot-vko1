# Arkkitehtuuri

## Rakenne

Ohjelman rakenne on kolmitasoinen. Koodin pakkausrakenteessa on kolme pakkausta, userinterface, domain ja dao.
Koodin pakkausrakenne näyttää tältä:

Pakkaus userinterface sisältää javaFX:llä koodatun käyttöliittymän. Domain sisältää sovelluslogiikan sekä aika- 
ja käyttäjä-oliot. Dao vastaa tekstitiedostotallennuksesta.

## Käyttöliittymä

Käyttöliittymässä on neljä eri näkymää joista jokaisella on oma tehtävänsä. Nämä näkymät ovat:
* Uuden käyttäjän luonti
* Kirjautuminen
* Ajastin
* Aikahistoria

Jokaisella näistä on oma Scene-Olio. Scene-olioita näytetään primaryStageen sijoitettuna.

Käyttöliittymä on yksinkertainen ja helppo ja nopea oppia käyttämään.
Käyttöliittymää voit tarkastella lisää käyttöohjeesta.

## Sovelluslogiikka 

<img src="https://raw.githubusercontent.com/sppirtti/ot2018/master/Dokumentaatio/datarakenne.png" width=$>
Yllä olevasta kuvasta selviää sovelluksen datarakenne. Käyttäjät luodaan etunimen ja sukunimen perusteella, 
joiden avulla generoidaan käyttäjänimi. Käyttäjälle voidaan tallentaa monta Time-oliota. Time oliot kertovat 
Työajan Kuukauden, päivän, aloitusajan sekä lopetusajan.

Kokonaisuudessaan sovelluslogiikasta luokkien välillä vastaa AppLogic luokka.

Sovelluksen osien suhteita kuvaa alla oleva luokkakaavio:

<img src="https://raw.githubusercontent.com/sppirtti/ot2018/master/Dokumentaatio/arkkitehtuuri.png" width=$>

## Tallennus

Sovellus hyödyntää Data Access Object suunnittelumallia tallennuksessa. Luokat on eristetty rajapintojen taakse ja sovelluslogiikka käyttää näitä luokkia rajapinnan kautta. Dao-luokat lukevata ja tallentavat tekstitiedostoja. Tekstitiedostoiden nimet on määritelty siten että käyttäjät tallentuu users.txt:hen ja ajat taas times.txt:hen.

Sovellus tallentaa käyttäjät muodossa

    etunimi;sukunimi;käyttäjätunnus

Ja ajat muodossa

    käyttäjä;kuukausi;päivä;aloitustunti;aloitusminuutti;lopetustunti;lopetusminuutti
    
Molemmissa eri arvot on erotettu puolipistellä. Aika-oliossa käyttäjä tarkoittaa käyttäjätunnusta.

## Päätoiminnallisuudet

Sovelluksessa on paljon toimintoja, joista suuri osa on yksinkertaisia. Päätoimintoja ovat isommat toiminnot jotka hyödyntävät useaa luokkaa. Päätoimintoja ovat:
* Uuden käyttäjän luonti
* Sisäänkirjautuminen
* Ajastimen käyttö

Sekvenssikaavio uuden käyttäjän luonnille:

<img src="https://raw.githubusercontent.com/sppirtti/ot2018/master/Dokumentaatio/newUser.png" width=$>

### Muita toiminnallisuuksia

Sovelluksessa on paljon pieniä toiminnallisuuksia jotka käyttävät yhtä tai useampaa luokkaa. Esimerkiksi työajan laskeminen, kun tiedetään aloitusaika ja lopetusaika tapahtuu kokonaan sovelluslogiikan sisällä.

## Ohjelman heikkoudet

#### Sovelluslogiikka
Sovelluslogiikkaan kertyi paljon simppeleitä asioita jotka voisi siirtää myös muihin luokkiin.
#### DAO
Dao-luokat ovat loppujen lopuksi hyvin samanlaisia ja niissä oleva koodi on toisteista.
#### Käyttöliittymä
Myös käyttöliittymää olisi voinut eritellä. Nyt kaikki on vain yhdessä pötkössä. Käyttöliittymästä voisi eritellä esim. jokaisen Scene ikkunan omaan metodiinsa.
