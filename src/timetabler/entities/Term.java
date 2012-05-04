package timetabler.entities;

import com.trolltech.qt.core.QDate;
import com.trolltech.qt.core.QTime;
import java.util.List;

/**
 * Term
 * 
 * Holds information about term
 * 
 * @author Michal Kimle
 * @version 2012-05-04
 */
public class Term {
    
    private Teacher teacher;
    private QDate day;
    private QTime timeFrom;
    private QTime timeTo;
    private List<Room> rooms;
    private int groupNum;

    public Term(Teacher teacher, QDate day, QTime timeFrom, QTime timeTo, List<Room> rooms, int groupNum) {
        this.teacher = teacher;
        this.day = day;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.rooms = rooms;
        this.groupNum = groupNum;
    }

    public QDate getDay() {
        return day;
    }

    public void setDay(QDate day) {
        this.day = day;
    }

    public int getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(int groupNum) {
        this.groupNum = groupNum;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public QTime getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(QTime timeFrom) {
        this.timeFrom = timeFrom;
    }

    public QTime getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(QTime timeTo) {
        this.timeTo = timeTo;
    }
    
}
