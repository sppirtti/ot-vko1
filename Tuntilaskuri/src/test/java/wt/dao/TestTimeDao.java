/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wt.dao;

import java.util.ArrayList;
import java.util.List;
import wt.domain.Time;

/**
 *
 * @author Samuli
 */
public class TestTimeDao implements TimeDao {
    
    List<Time> times = new ArrayList<>();

    @Override
    public Time addTime(Time time) throws Exception {
        times.add(time);
        return time;
    }

    @Override
    public List<Time> getAll() {
        return times;
    }
    
}
