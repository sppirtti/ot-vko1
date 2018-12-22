/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wt.domain;

import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import wt.dao.TestUserDao;
import wt.dao.TimeDao;
import wt.dao.UserDao;

/**
 *
 * @author Samuli
 */
public class AppLogicTest {

    UserDao userDao;
    TimeDao timeDao;
    AppLogic appLogic;

    User u;

    Integer date;
    Integer month;
    Integer startHour;
    Integer startMinute;
    Integer endHour;
    Integer endMinute;
    Time t;

    @Before
    public void setUp() {

        userDao = new TestUserDao();

        appLogic = new AppLogic(userDao, timeDao);

        this.date = 15;
        this.month = 10;
        this.startHour = 9;
        this.startMinute = 30;
        this.endHour = 11;
        this.endMinute = 45;
        User u = new User("Sali", "Make");

        Time t = new Time(u.getUsername(), month, date, startHour, startMinute, endHour, endMinute);

        appLogic.userLogin(u.getUsername());
    }

    @Test
    public void LoggedUserIsKnown() {
        assertEquals(u, appLogic.getLoggedUser());
    }

    @Test
    public void LoggedOutIsNull() {
        appLogic.logOutUser();

        assertEquals(null, appLogic.getLoggedUser());

    }

    @Test
    public void CreateNewUserTest() {
        appLogic.createNewUser("uusi", "user");

        User u = new User("uusi", "user");

        assertEquals(u.getFirstname(), userDao.findByUsername("uuse").getFirstname());

    }

    @Test
    public void timeCreationWork() {

        appLogic.refreshSystemDate();
        Time t = new Time("kissa", appLogic.getMonth(), appLogic.getDate(), appLogic.getHour(),
                appLogic.getMinute(), appLogic.getEndHour(), appLogic.getEndMinute());

        Integer date = new Date().getDate();

        assertEquals(t.getDay(), date);

    }

    @Test
    public void timeWorkedForTimeTest() {

        appLogic.refreshSystemDate();
        Time t = new Time("kissa", appLogic.getMonth(), appLogic.getDate(), 12,
                30, 13, 45);

        String time = appLogic.timeWorkedForTime(t);

        assertEquals("1:15", time);
    }

    @Test
    public void timeWorkedForTimeMinutesChange() {

        appLogic.refreshSystemDate();
        Time t = new Time("kissa", appLogic.getMonth(), appLogic.getDate(), 12,
                30, 13, 20);

        String time = appLogic.timeWorkedForTime(t);

        assertEquals("0:50", time);

    }

    @Test
    public void startAndStopWork() {

        appLogic.startTimer();
        appLogic.stopTimer();

    }

    @Test
    public void getAllTimesWorks() {
        t = new Time("kesa", 10, 10, 12, 30, 20, 0);
        
    }
    
    @Test
    public void timeWorkedNoTimeReturnsZeros() {

        
        String temp = appLogic.timeWorked();
        
        assertEquals("0:00", temp);
    }
}
