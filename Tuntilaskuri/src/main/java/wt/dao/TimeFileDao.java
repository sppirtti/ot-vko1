/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wt.dao;

import java.util.List;
import wt.domain.Time;

/**
 *
 * @author Samuli
 */
public class TimeFileDao implements TimeDao {
    
    public List<Time> times;
    private String timefile;
    
    public TimeFileDao(String timefile) {
        
        this.timefile = timefile;
    }

    @Override
    public Time add(Time time) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Time> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
