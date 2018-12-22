/**
 * Sovelluslogiikasta vastaava luokka.
 * Sovelluslogiikka vastaa tiedon siirtämisestä tiedostojen ja käyttöliittymän välillä.
 *
 * Sisältää myös aikaan liittyviä ominaisuuksia.
 */
package wt.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import wt.dao.TimeDao;
import wt.dao.UserDao;

public class AppLogic {

    private User u;
    private UserDao userDao;
    public TimeDao timeDao;
    private Date systemDate;
    private int month;
    private int date;
    private int startHour;
    private int startMinute;
    private int endHour;
    private int endMinute;

    public AppLogic(UserDao userDao, TimeDao timeDao) {
        this.userDao = userDao;
        this.timeDao = timeDao;

    }
    
    /**
     * Käyttäjä syöttää etunimen ja sukunimen joista luodaan uusi käyttäjä.
     * 
     * @param firstname
     * @param surname
     * @return Boolean 
     */
    
    public boolean createNewUser(String firstname, String surname) {

        User u = new User(firstname, surname);

        if (userDao.findByUsername(u.getUsername()) != null) {
            return false;
        }

        try {

            userDao.createUser(u);

        } catch (Exception e) {
            return false;
        }

        return true;
    }
    
    /**
     * Käyttäjän sisäänkirjautuminen. Tälle käyttäjälle tallennetaan ajat.
     * @param username
     * @return 
     */

    public boolean userLogin(String username) {
        User user = userDao.findByUsername(username);

        if (userDao.findByUsername(username) != null) {
            u = user;
            return true;

        } else {

            return false;
        }
    }

    /**
     * Käynnistää ajastimen päivittämällä Date olion ja ottamalla sen arvot
     * talteen
     *
     */
    public void startTimer() {
        refreshSystemDate();
        getMonth();
        getDate();
        getMinute();
        getHour();

    }

    /**
     * Pysäyttää ajasten ja ottaa sen Date olion arvot talteen.
     */
    public void stopTimer() {
        refreshSystemDate();
        getEndHour();
        getEndMinute();
    }

    public Integer getMinute() {

        startMinute = systemDate.getMinutes();

        return startMinute;

    }

    public Integer getHour() {

        startHour = systemDate.getHours();

        return startHour;
    }

    public void refreshSystemDate() {
        systemDate = new Date();
    }

    public Integer getMonth() {

        month = systemDate.getMonth() + 1;

        return month;
    }

    public Integer getDate() {

        date = systemDate.getDate();
        return date;
    }

    public Integer getEndHour() {

        endHour = systemDate.getHours();

        return endHour;
    }

    public Integer getEndMinute() {

        endMinute = systemDate.getMinutes();

        return endMinute;
    }

    /**
     * Kirjautuu käyttäjän ulos, jotta voidaan ottaa eri käyttäjä tallennukseen
     */
    public void logOutUser() {
        u = null;
    }

    public User getLoggedUser() {
        return u;
    }
    
    /**
     * Luo uuden aikaolion tietylle käyttjälle.
     * @return 
     */

    public boolean createNewTime() {

        Time t = new Time(u.getUsername(), month, date, startHour, startMinute, endHour, endMinute);

        try {

            timeDao.addTime(t);

        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    /**
     * Listaa kaikki sisäänkirjautuneen käyttäjän ajat.
     * @return 
     */

    public List<Time> getTimes() {

        if (u == null) {
            return new ArrayList<>();
        }

        return timeDao.getAll()
                .stream()
                .filter(t -> t.getUser().equals(u.getUsername()))
                .collect(Collectors.toList());

    }
    
    /**
     * Laskee työskennellyn ajan ajastimelle. Vain nykyiselle ajalle.
     * @return 
     */

    public String timeWorked() {
        Integer hoursWorked = 0;
        Integer minutesWorked = 0;

        if (endHour < startHour) {
            hoursWorked = endHour + 24 - startHour;
        } else {
            hoursWorked = endHour - startHour;

        }

        if (endMinute < startMinute) {
            hoursWorked = hoursWorked - 1;
            minutesWorked = endMinute + 60 - startMinute;
        } else {
            minutesWorked = endMinute - startMinute;
        }

        if (minutesWorked < 10) {
            return hoursWorked + ":0" + minutesWorked;
        }
        return hoursWorked + ":" + minutesWorked;
    }
    
    /**
     * Laskee työajan mille tahansa ajalle t.
     * @param t
     * @return 
     */
    
    public String timeWorkedForTime(Time t) {
        Integer hoursWorked = 0;
        Integer minutesWorked = 0;
        
        

        if (t.getEndHour() < t.getStartHour()) {
            hoursWorked = t.getEndHour() + 24 - t.getStartHour();
        } else {
            hoursWorked = t.getEndHour() - t.getStartHour();

        }

        if (t.getEndMinute() < t.getStartMinute()) {
            hoursWorked = hoursWorked - 1;
            minutesWorked = t.getEndMinute() + 60 - t.getStartMinute();
        } else {
            minutesWorked = t.getEndMinute() - t.getStartMinute();
        }

        if (minutesWorked < 10) {
            return hoursWorked + ":0" + minutesWorked;
        }
        return hoursWorked + ":" + minutesWorked;
    }
   

}
