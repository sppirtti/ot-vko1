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

<img src="https://raw.githubusercontent.com/sppirtti/ot2018/master/Dokumentaatio/arkkitehtuuri.png" width=$>

## Tallennus

Sovellus tallentaa käyttäjät muodossa

    etunimi;sukunimi;käyttäjätunnus


Ja ajat muodossa

    käyttäjä;kuukausi;päivä;aloitustunti;aloitusminuutti;lopetustunti;lopetusminuutti


<img src="https://raw.githubusercontent.com/sppirtti/ot2018/master/Dokumentaatio/newUser.png" width=$>
