/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timetabler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import timetabler.entities.Course;
import timetabler.entities.Days;
import timetabler.entities.Lecture;
import timetabler.entities.Seminar;

/**
 *
 * @author xgardon
 * 
 * Collision detection class
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
    
    public List<Lecture> Lecturedetection(Lecture o, Collection<Course> list){
        Lecture tmp = o;
        List<Lecture> output = new ArrayList<Lecture>();
        
        for(Course c : list){   
            if(c.getLectures() != null){
                for(Lecture l : c.getLectures()){
                    if(comparator(tmp, l)){
                        output.add(l);
                    }
                }
            }
        }
        return output;
    }
    public List<Lecture> Lecturedetection(Seminar o, Collection<Course> list){
        Seminar tmp = o;
        List<Lecture> output = new ArrayList<Lecture>();
        
        for(Course c : list){   
            if(c.getLectures() != null){
                for(Lecture l : c.getLectures()){
                    if(comparator(l, tmp)){
                        output.add(l);
                    }
                }
            }
        }
        return output;
    }
    
    public List<Seminar> Seminardetection(Lecture o, Collection<Course> list){
        Lecture tmp = o;
        List<Seminar> output = new ArrayList<Seminar>();
        
        for(Course c : list){
            if(c.getSeminars() != null){
                for(Seminar s : c.getSeminars()){
                    if(comparator(tmp, s)){
                        output.add(s);
                    }
                }
            }
        }
        return output;
    }
    public List<Seminar> Seminardetection(Seminar o, Collection<Course> list){
        Seminar tmp = o;
        List<Seminar> output = new ArrayList<Seminar>();
        
        for(Course c : list){
            if(c.getSeminars() != null){
                for(Seminar s : c.getSeminars()){
                    if(comparator(tmp, s)){
                        output.add(s);
                    }
                }
            }
        }
        return output;
    }
    
    /*
     * WARNING! TYPE MISMATCHING! WARNING
     */
    
    private boolean comparator(Lecture t1, Lecture t2){
        Lecture early;
        Lecture later;
        if(t1.getDay() != t2.getDay())
            return false;
        int res = earlierTerm(t1,t2);
        if(res == 0)
            return true;
        if(res == 1){
            early = t1;
            later = t2;
        }else{
            early = t2;
            later = t1;
        }
        if(early.getTimeTo().hour() == later.getTimeFrom().hour()){
            if(early.getTimeTo().minute() > later.getTimeFrom().minute())
                return true;
            return false;
        }
        if(early.getTimeTo().hour() > later.getTimeFrom().hour()){
            return true;
        }
        return false;
    }
    
    private boolean comparator(Lecture t1, Seminar t2){
        Lecture early;
        Lecture later;
        if(t1.getDay() != t2.getDay())
            return false;
        Lecture tmp = new Lecture(null,t2.getDay(),t2.getTimeFrom(),t2.getTimeTo(),null,null);
        int res = earlierTerm(t1,tmp);
        if(res == 0)
            return true;
        if(res == 1){
            early = t1;
            later = tmp;
        }else{
            early = tmp;
            later = t1;
        }
        if(early.getTimeTo().hour() == later.getTimeFrom().hour()){
            if(early.getTimeTo().minute() > later.getTimeFrom().minute())
                return true;
            return false;
        }
        if(early.getTimeTo().hour() > later.getTimeFrom().hour()){
            return true;
        }
        return false;
    }
        private boolean comparator(Seminar t1, Seminar t2){
        Seminar early;
        Seminar later;
        if(t1.getDay() != t2.getDay())
            return false;
        int res = earlierTerm(t1,t2);
        if(res == 0)
            return true;
        if(res == 1){
            early = t1;
            later = t2;
        }else{
            early = t2;
            later = t1;
        }
        if(early.getTimeTo().hour() == later.getTimeFrom().hour()){
            if(early.getTimeTo().minute() > later.getTimeFrom().minute())
                return true;
            return false;
        }
        if(early.getTimeTo().hour() > later.getTimeFrom().hour()){
            return true;
        }
        return false;
    }
    
    private int earlierTerm(Lecture o1, Lecture o2){
        
        Lecture t1 = o1;    
        Lecture t2 = o2;
        
        if(t1.getTimeFrom().hour() == t2.getTimeFrom().hour()){
            if(t1.getTimeFrom().minute() == t2.getTimeFrom().minute())
                return 0;
            if(t1.getTimeFrom().minute() < t2.getTimeFrom().minute())
                return 1;
            return 2;
        }
        
        if(t1.getTimeFrom().hour() < t2.getTimeFrom().hour())
            return 1; 
        return 2;
    }
    private int earlierTerm(Seminar o1, Seminar o2){
        
        Seminar t1 = o1;    
        Seminar t2 = o2;
        
        if(t1.getTimeFrom().hour() == t2.getTimeFrom().hour()){
            if(t1.getTimeFrom().minute() == t2.getTimeFrom().minute())
                return 0;
            if(t1.getTimeFrom().minute() < t2.getTimeFrom().minute())
                return 1;
            return 2;
        }
        
        if(t1.getTimeFrom().hour() < t2.getTimeFrom().hour())
            return 1; 
        return 2;
    }
    
    public int gui_height(int i){
        int p=0;
        switch(i){
            case 1:
                p=60;
                break;
            case 2:
                p=30;
                break;
            case 3:
                p=20;
                break;
        }
        return p;
    }
    public int gui_y(int i){
        int p=0;
        switch(i){
            case 1:
                p=5;
                break;
            case 2:
                p=35;
                break;
            case 3:
                p=45;
                break;
        }
        return p;
    }  
}
