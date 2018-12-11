package wt.domain;


import wt.domain.User;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Samuli
 */
public class UserTest {
    
    @Test
    public void UsernameCorrect() {
        User mtep = new User("matti", "teppo");
        
        assertEquals("mtep", mtep.getUsername());
        
    }
    @Test
    public void SurnameShorterThanFour() {
        User user = new User ("Li", "Ha");
        
        assertEquals("LHa", user.getUsername());
    }
    
    @Test
    public void ChecksUniqueUserName() {
        User u1 = new User("matti", "teppo");
        
        Object o = new Object();
        
        assertFalse(u1.equals(o));
    }
    
    
}
