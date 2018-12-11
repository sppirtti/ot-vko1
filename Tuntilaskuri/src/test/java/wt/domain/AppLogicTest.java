/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wt.domain;

import static org.junit.Assert.assertEquals;
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
    public void TimeWorkedCorrectString() {

        assertEquals("1:30", appLogic.timeWorked(6, 40, 8, 10));

    }

}
