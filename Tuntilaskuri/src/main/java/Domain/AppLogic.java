package Domain;

import Dao.UserDao;

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
    private User user;
    private UserDao userDao;
    
    public AppLogic (UserDao userDao) {
        this.userDao = userDao;
    }
    
    public boolean createNewUser(String firstname, String surname) {
        
        
        //NOT CHECKING IF ALREADY EXISTS WITH SAME USERNAME
        User u = new User (firstname, surname);
        
        try {
            userDao.createUser(u);
           
        } catch(Exception e) {
            return false;
        }
        return true;
    }
    
    
}
