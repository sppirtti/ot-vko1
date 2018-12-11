/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wt.dao;

import java.util.ArrayList;
import java.util.List;
import wt.domain.User;

/**
 *
 * @author Samuli
 */
public class TestUserDao implements UserDao {

    List <User> users = new ArrayList<>();
    
    public TestUserDao() {
        users.add(new User("teppo","testi"));
    }
    
    @Override
    public User createUser(User user) throws Exception {
         users.add(user);
         return user;
    }

    @Override
    public User findByUsername(String username) {
        User user = users.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
       
       return user;
    }
    
}
