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
import java.util.List;
import wt.domain.Time;

public interface TimeDao {
    
    Time add(Time time) throws Exception;
    
    List<Time> getAll();
    
    
}
