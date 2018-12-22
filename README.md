# WorkTimer

Sovelluksen avulla on mahdollista kellottaa työaikaa. Järjestelmässä on mahdollista kirjautua uudella tunnuksella tai jo voimassa olevalla. Sovellus tallentaa ajat ja historiasta voi tarkastella 14 viimeisintä työkertaa.


[Työtuntiaikataulu](https://github.com/sppirtti/ot2018/blob/master/Dokumentaatio/Ty%C3%B6aikataulu.md)

[Vaatimusmäärittely](https://github.com/sppirtti/ot2018/blob/master/Dokumentaatio/M%C3%A4%C3%A4rittelydokumentti.md)

[Arkkitehtuuri](https://github.com/sppirtti/ot2018/blob/master/Dokumentaatio/Arkkitehtuuri.md)

[Käyttöohje](https://github.com/sppirtti/ot2018/blob/master/Dokumentaatio/K%C3%A4ytt%C3%B6ohje.md)

[Testausdokumentti](https://github.com/sppirtti/ot2018/blob/master/Dokumentaatio/Testausdokumentti.md)

## Julkaisut

[Release 1](https://github.com/sppirtti/ot2018/releases)

[Release 2](https://github.com/sppirtti/ot2018/releases/tag/viikko6)

[Release 3 (Loppupalautus)](https://github.com/sppirtti/ot2018/releases/tag/Loppupalautus)

### Komentorivitoiminnot

Testien suoritus:

    mvn test
  
Testikattavuusraportti:

    mvn jacoco:report
    
Jar generointi:
    
    mvn package
    
JavaDoc generointi:

    mvn javadoc:javadoc
    
Checkstyle generointi:
  
    mvn jxr:jxr checkstyle:checkstyle
