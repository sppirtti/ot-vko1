package wt.domain;

import wt.dao.UserDao;
import wt.dao.UserFileDao;

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

    public AppLogic(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean createNewUser(String firstname, String surname) {

        User u = new User(firstname, surname);

        if (userDao.findByUsername(u.getUsername()) != null) {
            return false;
        }

        try {
            System.out.println("lähdetään daoon");

            userDao.createUser(u);

        } catch (Exception e) {
            return false;
        }

        System.out.println("palataan daosta");
        return true;
    }

    public boolean userLogin(String username) {
        if (userDao.findByUsername(username) != null) {
            return true;
        }
        return false;
    }

}
