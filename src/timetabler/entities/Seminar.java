package timetabler.entities;

import com.trolltech.qt.core.QTime;
import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QMouseEvent;
import java.util.List;

/**
 * Holds information about seminar.
 *
 * Holds list of Term objects which represents all the information about seminar
 * and one separate Term object which represents currently chosen term in
 * timetable.
 *
 * @author Michal Kimle
 * @version 2012-05-04
 */
public class Seminar extends QLabel {

    /**
     * all terms within seminar
     */
    private Teacher teacher;
    private Days day;
    private QTime timeFrom;
    private QTime timeTo;
    private List<Room> rooms;
    private int groupNum;
    private Course course;
    
    public final Signal0 requestSettings = new Signal0();

    public Seminar(Teacher teacher,Days day, QTime timeFrom, QTime timeTo, List<Room> rooms, int groupNum, Course course) {
        this.teacher = teacher;
        this.day = day;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.rooms = rooms;
        this.groupNum = groupNum;
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course course){
        this.course = course;
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

    /**
     * Executes on mouse double-click
     *
     * emits request for course dialog
     *
     * @param me mouse event generated within double-click
     */
    @Override
    protected void mouseDoubleClickEvent(QMouseEvent me) {
        requestSettings.emit();
    }

    @Override
    public String toString() {
        return "Seminar{" + "teacher=" + teacher + ", day=" + day + ", timeFrom=" + timeFrom + ", timeTo=" + timeTo + ", rooms=" + rooms + ", groupNum=" + groupNum + ", tooltip=" + toolTip() + '}';
    }
}
