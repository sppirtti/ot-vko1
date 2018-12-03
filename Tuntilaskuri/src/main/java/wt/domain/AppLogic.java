package wt.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import wt.dao.TimeDao;
import wt.dao.UserDao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Samuli
 */
public class AppLogic {

    private User u;
    private UserDao userDao;
    private TimeDao timeDao;
    private Date start;
    private Date stop;
    

    public AppLogic(UserDao userDao, TimeDao timeDao) {
        this.userDao = userDao;
        this.timeDao = timeDao;
        start = new Date();
        stop = new Date();
    }

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

    public boolean userLogin(String username) {
        if (userDao.findByUsername(username) != null) {
            return true;
        }
        return false;
    }

    public Integer getMinute() {
        return start.getMinutes();

    }

    public Integer getHour() {
        return start.getHours();
    }

    public Integer getMonth() {

        return start.getMonth();
    }

    public Integer getDate() {

        return start.getDate();
    }
    public Integer getEndHour() {
        stop = new Date();
        return stop.getHours();
    }
    public Integer getEndMinute() {
        return stop.getMinutes();
    }
    
    public boolean createNewTime(String username, int month, int day, int startHour, int startMinute, int endHour, int endMinute) {
        
        Time t = new Time(u.getUsername(),getMonth(),getDate(),getHour(), getMinute(), getEndHour(), getEndMinute());
        
        try {
            timeDao.add(t);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    
    

}
