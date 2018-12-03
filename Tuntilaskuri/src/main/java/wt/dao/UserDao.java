/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wt.dao;

/**
 *
 * @author Samuli
 */
import wt.domain.User;

public interface UserDao {

    User createUser(User user) throws Exception;

    User findByUsername(String username);

}
