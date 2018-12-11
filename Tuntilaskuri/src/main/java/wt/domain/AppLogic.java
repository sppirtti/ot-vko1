package wt.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
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
        User user = userDao.findByUsername(username);

        if (userDao.findByUsername(username) != null) {
            u = user;
            return true;

        } else {

            return false;
        }
    }

    public void startTimer() {
        refreshSystemDate();
        getMonth();
        getDate();
        getMinute();
        getHour();
        
    }

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

    public void logOutUser() {
        u = null;
    }

    public User getLoggedUser() {
        return u;
    }

    public boolean createNewTime() {

        Time t = new Time(u.getUsername(), month, date, startHour, startMinute, endHour, endMinute);
        

        try {

            timeDao.addTime(t);

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<Time> getTimes() {

        if (u == null) {
            return new ArrayList<>();
        }

        return timeDao.getAll()
                .stream()
                .filter(t -> t.getUser().equals(u))
                .collect(Collectors.toList());

    }

    public String timeWorked(int startH, int startM, int endH, int endM) {
        Integer hoursWorked = 0;
        Integer minutesWorked = 0;

        Integer startHo = startHour;
        Integer startMi = startMinute;
        Integer endHo = endH;
        Integer endMi = endM;
        
        System.out.println(startHo);
        System.out.println(startMi);
        System.out.println(endHo);
        System.out.println(endMi);

        if (endHo < startHo) {
            hoursWorked = endHo + 24 - startHo;
        } else {
            hoursWorked = endHo - startHo;

        }

        if (endMi < startMi) {
            hoursWorked = hoursWorked - 1;
            minutesWorked = endMi + 60 - startMi;
        } else {
            minutesWorked = endMi - startMi;
        }

        if (minutesWorked < 10) {
            return hoursWorked + ":0" + minutesWorked;
        }
        return hoursWorked + ":" + minutesWorked;
    }

}
