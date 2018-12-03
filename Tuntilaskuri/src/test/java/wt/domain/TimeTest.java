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
        time = new Time(u,12,1,12,30,16,40);
    }
    
    @Test
    public void TimeGettersWork() {
        assertEquals(12, time.getMonth());
        assertEquals(1, time.getDay());
        assertEquals(12, time.getStartHour());
        assertEquals(30, time.getStartMinute());
        assertEquals(16, time.getEndHour());
        assertEquals(40, time.getEndMinute());
                
    }
    
}
