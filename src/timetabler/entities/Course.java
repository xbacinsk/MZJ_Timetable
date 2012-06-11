package timetabler.entities;

import com.trolltech.qt.QVariant;
import com.trolltech.qt.core.QSettings;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QListWidgetItem;
import com.trolltech.qt.gui.QMouseEvent;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import timetabler.dialogs.CourseDialog;

/**
 * Holds all the information about course.
 *
 * Holds the course code, name, id, lecture and seminar. One object represents
 * whole course with all its information which are needed for its rendering.
 *
 * @author Michal Kimle
 * @version 2012-06-04
 *
 * @todo functions for rendering
 */
public class Course extends QListWidgetItem {

    private String code;
    private String name;
    private BigInteger id;
    private List<Lecture> lectures;
    private List<Seminar> seminars;
    public final Signal1<Course> optionsChanged = new Signal1<Course>();
    public final Signal1<Course> removeLectureRequest = new Signal1<Course>();
    public final Signal1<Seminar> removeSeminarRequest = new Signal1<Seminar>();
    
    public Course(String code, String name, BigInteger id) {
        this.code = code;
        this.name = name;
        this.id = id;
        this.setText(code + " " + name);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Seminar> getSeminars() {
        return seminars;
    }

    public void setSeminars(List<Seminar> seminars) {
        this.seminars = seminars;
    }

    /**
     * Sets lecture visibility within GUI
     *
     * @param isVisible value to which visibility is set
     */
    public void setLectureVisibility(boolean isVisible) {
        QSettings settings = new QSettings();
        settings.setValue(code + "/lecture", isVisible);
    }
    
    public boolean getLectureVisibility(){
        QSettings settings = new QSettings();
        return QVariant.toBoolean(settings.value(code + "/lecture", true));
    }

    /**
     * Returns list of all teachers within current course
     *
     * @return list of all teachers within course
     *
     * @todo fix teachers duplicity
     */
    public List<Teacher> getTeachers() {
        Set<Teacher> teacherSet = new HashSet<Teacher>();

        //getting teacher from lecture
        if (lectures != null) {
            for (Lecture lecture : lectures) {
                if (lecture != null && lecture.getTeacher() != null) {
                    teacherSet.add(lecture.getTeacher());
                }
            }
        }

        //getting teachers from seminars
        if (seminars != null) {
            for (Seminar seminar : seminars) {
                if (seminar != null && seminar.getTeacher() != null) {
                    teacherSet.add(seminar.getTeacher());
                }
            }
        }

        return new ArrayList(teacherSet);
    }

    /**
     * SLOT
     *
     * opens course dialog
     */
    public void showSettings() {
        CourseDialog dialog = new CourseDialog(this);
        if(dialog.exec() == QDialog.DialogCode.Accepted.value())
            optionsChanged.emit(this);
    }
    
    public void removeLecture(){
        removeLectureRequest.emit(this);
    }
    
    public void removeSeminar(Seminar seminar){
        removeSeminarRequest.emit(seminar);
    }
    
    @Override
    public String toString() {
        return "Course{" + "code=" + code + ", name=" + name + ", id=" + id + ", lecture= [" + lectures + "], seminar= [" + seminars + "] }";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Course other = (Course) obj;
        if ((this.code == null) ? (other.code != null) : !this.code.equals(other.code)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.code != null ? this.code.hashCode() : 0);
        return hash;
    }
    
}
