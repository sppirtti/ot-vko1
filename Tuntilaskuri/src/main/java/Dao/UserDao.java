/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author Samuli
 */
import Domain.User ;

public interface UserDao {
    
  User createUser (User user);
  
  User findByUsername (String username);
  
    
}
