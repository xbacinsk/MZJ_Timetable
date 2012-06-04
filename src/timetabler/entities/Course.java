package timetabler.entities;

import com.trolltech.qt.core.QSettings;
import com.trolltech.qt.gui.QLabel;
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
public class Course extends QLabel {

    private String code;
    private String name;
    private BigInteger id;
    private Lecture lecture;
    private Seminar seminar;

    public Course(String code, String name, BigInteger id) {
        this.code = code;
        this.name = name;
        this.id = id;
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

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Seminar getSeminar() {
        return seminar;
    }

    public void setSeminar(Seminar seminar) {
        this.seminar = seminar;
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
        return (Boolean) settings.value(code + "/lecture", true);
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
        if (lecture != null) {
            List<Term> terms = lecture.getTerms();
            for (Term term : terms) {
                if (term != null && term.getTeacher() != null) {
                    teacherSet.add(term.getTeacher());
                }
            }
        }

        //getting teachers from seminars
        if (seminar != null) {
            List<Term> terms = seminar.getTerms();
            for (Term term : terms) {
                if (term != null && term.getTeacher() != null) {
                    teacherSet.add(term.getTeacher());
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
        dialog.exec();
    }

    /**
     * Executes on mouse double-click
     *
     * opens course dialog
     *
     * @param me mouse event generated within double-click
     */
    @Override
    protected void mouseDoubleClickEvent(QMouseEvent me) {
        showSettings();
    }

    @Override
    public String toString() {
        return "Course{" + "code=" + code + ", name=" + name + ", id=" + id + ", lecture=" + lecture + ", seminar=" + seminar + '}';
    }
}
