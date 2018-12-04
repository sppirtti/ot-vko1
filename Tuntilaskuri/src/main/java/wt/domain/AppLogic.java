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
        User user = userDao.findByUsername(username);

        if (userDao.findByUsername(username) != null) {
            u = user;
            return true;

        } else {

            return false;
        }
    }
    

    public Integer getMinute() {
        return start.getMinutes();

    }

    public Integer getHour() {
        return start.getHours();
    }

    public Integer getMonth() {
        start = new Date();

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

    public void logOutUser() {
        u = null;
    }

    public User getLoggedUser() {
        return u;
    }

    public boolean createNewTime() {

        Time t = new Time(u, getMonth(), getDate(), getHour(), getMinute(), getEndHour(), getEndMinute());

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


}