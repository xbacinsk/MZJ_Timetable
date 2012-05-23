package timetabler.entities;

import com.trolltech.qt.core.QTime;

/**
 * Holds information about term.
 * 
 * Represents all information about one term.
 * 
 * @author Michal Kimle
 * @version 2012-05-04
 */
public class Term {
    
    private Teacher teacher;
    private Days day;
    private QTime timeFrom;
    private QTime timeTo;
    private Room room;
    private int groupNum;

    public Term(Teacher teacher,Days day, QTime timeFrom, QTime timeTo, Room room, int groupNum) {
        this.teacher = teacher;
        this.day = day;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.room = room;
        this.groupNum = groupNum;
    }

    public Days getDay() {
        return day;
    }

    public void setDay(Days day) {
        this.day = day;
    }

    public int getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(int groupNum) {
        this.groupNum = groupNum;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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

    @Override
    public String toString() {
        return "Term{" + "teacher=" + teacher + ", day=" + day + ", timeFrom=" + timeFrom + ", timeTo=" + timeTo + ", rooms=" + room + ", groupNum=" + groupNum + '}';
    }
}
