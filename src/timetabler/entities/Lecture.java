package timetabler.entities;

import com.trolltech.qt.core.QTime;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QMouseEvent;
import java.util.List;

/**
 * 
 * Holds information about lecture, such as its teacher, day, time from and time to, list of rooms 
 * and pointer to parent course. One object represents lecture as a extension of QLabel with all 
 * information which are needed for its rendering.
 *
 * @author Michal Kimle
 * @version 2012-06-04
 */
public class Lecture extends QLabel {

    private Teacher teacher;
    private Days day;
    private QTime timeFrom;
    private QTime timeTo;
    private List<Room> rooms;
    private Course course;
    private int position;
    
    public final Signal0 requestSettings = new Signal0();
    public final Signal0 requestRemoval = new Signal0();
    
    public Lecture(Teacher teacher,Days day, QTime timeFrom, QTime timeTo, List<Room> rooms, Course course) {
        this.teacher = teacher;
        this.day = day;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.rooms = rooms;
        this.course = course;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course course){
        this.course = course;
    }
    
    /**
     * @return length of the lecture in minutes
     */
    public int getLength(){
        return timeFrom.secsTo(timeTo) / 60;
    }

    public Days getDay() {
        return day;
    }

    public void setDay(Days day) {
        this.day = day;
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

    public int getPosition(){
        return this.position;
    }
    
    public void setPosition(int position){
        this.position = position;
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
    protected void mousePressEvent(QMouseEvent me) {
        if(me.button() == Qt.MouseButton.RightButton){
            requestRemoval.emit();
        }
    }

    @Override
    public String toString() {
        return "Lecture{" + "teacher=" + teacher + ", day=" + day + ", timeFrom=" + timeFrom + ", timeTo=" + timeTo + ", rooms=" + rooms + ", tooltip=" + toolTip() + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lecture other = (Lecture) obj;
        if (this.teacher != other.teacher && (this.teacher == null || !this.teacher.equals(other.teacher))) {
            return false;
        }
        if (this.day != other.day) {
            return false;
        }
        if (this.timeFrom != other.timeFrom && (this.timeFrom == null || !this.timeFrom.equals(other.timeFrom))) {
            return false;
        }
        if (this.timeTo != other.timeTo && (this.timeTo == null || !this.timeTo.equals(other.timeTo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.teacher != null ? this.teacher.hashCode() : 0);
        hash = 97 * hash + (this.day != null ? this.day.hashCode() : 0);
        hash = 97 * hash + (this.timeFrom != null ? this.timeFrom.hashCode() : 0);
        hash = 97 * hash + (this.timeTo != null ? this.timeTo.hashCode() : 0);
        return hash;
    }

}
