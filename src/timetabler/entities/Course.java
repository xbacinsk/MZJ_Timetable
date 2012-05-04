package timetabler.entities;

import com.trolltech.qt.core.QSettings;
import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QMouseEvent;
import java.util.ArrayList;
import java.util.List;
import timetabler.dialogs.CourseDialog;

/**
 * Holds all the information about course.
 * 
 * Holds the course code, name, id, lecture and seminar. One object represents 
 * whole course with all its information which are needed for its rendering.
 * 
 * @author Michal Kimle
 * @version 2012-05-04
 * 
 * @todo functions for rendering
 */
public class Course extends QLabel {

  private String code;
  private String name;
  private int id;
  private Lecture lecture;
  private Seminar seminar;

  public Course(String code, String name, int id, Lecture lecture, Seminar seminar) {
    this.code = code;
    this.name = name;
    this.id = id;
    this.lecture = lecture;
    this.seminar = seminar;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
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

  public Seminar getSeminars() {
    return seminar;
  }

  public void setSeminars(Seminar seminar) {
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
  
  /**
   * Returns list of all teachers within current course
   * 
   * @return list of all teachers within course
   * 
   * @todo fix teachers duplicity
   */
  public List<Teacher> getTeachers(){
    List<Teacher> teacherList = new ArrayList<Teacher>();
    
    //getting teacher from lecture
    if(lecture != null && lecture.getTerm() != null && lecture.getTerm().getTeacher() != null)
      teacherList.add(lecture.getTerm().getTeacher());
    
    //getting teachers from seminars
    if(seminar != null){
      List<Term> terms = seminar.getTerms();
      for(Term term : terms){
        if(term != null && term.getTeacher() != null)
          teacherList.add(term.getTeacher());
      }
    }
    
    return teacherList;
  }
  
  /**
   * SLOT
   * 
   * opens course dialog
   */
  public void showSettings(){
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
  protected void mouseDoubleClickEvent(QMouseEvent me){
    showSettings();
  }
}
