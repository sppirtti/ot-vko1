/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wt.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Samuli
 */
public class TimeTest {
    
    Time time;
    User u;
    
    @Before
    
    
    
    public void setUp() {
        User u = new User("matti", "teppo");
        time = new Time(u.getUsername(),12,1,12,30,16,40);
    }
    
    @Test
    public void UserIsCorrect() {
        assertEquals("mtep", time.getUser());
    }
    
    @Test
    public void TimeGettersWork() {
        assertEquals("12", time.getMonth().toString());
        assertEquals("1", time.getDay().toString());
        assertEquals("12", time.getStartHour().toString());
        assertEquals("30", time.getStartMinute().toString());
        assertEquals("16", time.getEndHour().toString());
        assertEquals("40", time.getEndMinute().toString());
                
    }
    
}
