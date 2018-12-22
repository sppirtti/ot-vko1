# Testausdokumentti

Ohjelmaa on testattu testipaketeista löytyvillä paketeilla. Jokaiselle luokalle on oma testausluokkansa. Käyttöliittymää ei ole testattu ollenkaan.

Testaamiseen on käytetty manuaalisesti luotuja testejä, jotka testaavat ohjelmaa niin helpoissa get-ominaisuuksissa kuin vaativissa sovellus- ja tallennustoiminnoissa.

### Testikattavuus

Rivikattavuus testeille on 77% ja haaraumakattavuus 70%

<img src="https://raw.githubusercontent.com/sppirtti/ot2018/master/Dokumentaatio/Testikattavuus.png" width=$>

### Sovelluslogiikka
Sovelluslogiikkaa on testattu on testattu AppLogicTest luokassa. Sovelluslogiikan testaus oli odotettua hankalampaa, mutta lopuksi sille saatiin ihan hyvä testikattavuus. Sovelluslogiikan lisäksi Domainpaketin User ja Time olioille on luotu testit jotka varmistavat get- ja set- ominaisuuksien toiminnan. User luokassa uniikkia käyttäjää ei ole testattu

### Dao
Daopakettia, eli sovelluksen tallennusominaisuuksien testaus on kattava. Testit varmistavat että tallennetut oliot eivät muutu tiedostoissa ja niitä pystytään lukemaan ja käsittelemään halutusti.

Daon testauksessa on hyödynnetty JUnit TemporaryFolder tilapäistiedostoja.

## Järjestelmätestaus

Järjestelmätestaus on tehty manuaalisesti.

### Asennus ja Konfigurointi
Sovellus on luotu, ladattu ja testattu windows ympäristössä.

### Toiminnallisuus
Suurin osa määrittelydokumentissa listatuista ominaisuuksista on testattu tai huomioitu testeissä.
