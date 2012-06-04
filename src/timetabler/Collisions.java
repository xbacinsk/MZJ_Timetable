/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timetabler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import timetabler.entities.Course;
import timetabler.entities.Term;

/**
 *
 * @author xgardon
 * 
 * Term collision detection class
 * 
 */
public class Collisions {
    
    /**
     * Fill it! :D
     * 
     * @param t
     * @param list
     * @return 
     */
    
    /* zakomentovane len aby som to mohol skompilovat
    /*
    public Collection<Course> detection(Term t, Collection<Course> list){
        List<Course> output = new ArrayList<Course>();
        
        for(Course c : list){
            if(comparator(t, c.getLecture().getTerm()) || 
                    comparator(t, c.getSeminar().getChosen())){
                output.add(c);
            }
        }
        
        return output;
    }*/
    
    private boolean comparator(Term t1, Term t2){
        Term early = earlierTerm(t1,t2);
        Term later = earlierTerm(t1,t2);
        
        if(early == null || later == null)
            return true;
        
        if(early.getTimeTo().hour() == later.getTimeFrom().hour()){
            if(early.getTimeTo().minute() > later.getTimeFrom().minute())
                return true;
            return false;
        }
        if(early.getTimeTo().hour() == later.getTimeFrom().hour()){
            return true;
        }
        return false;
    }
    
    
    private Term earlierTerm(Term t1, Term t2){
        
        if(t1.getTimeFrom().hour() == t2.getTimeFrom().hour()){
            if(t1.getTimeFrom().minute() == t2.getTimeFrom().minute())
                return null;
            if(t1.getTimeFrom().minute() < t2.getTimeFrom().minute())
                return t1;
            return t2;
        }
        
        if(t1.getTimeFrom().hour() < t2.getTimeFrom().hour())
            return t1; 
        return t2;
    }
    
}
