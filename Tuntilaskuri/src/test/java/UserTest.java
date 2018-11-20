
import static org.junit.Assert.assertEquals;
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
    
}
