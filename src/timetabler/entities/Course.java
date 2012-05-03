package timetabler.entities;

import com.trolltech.qt.core.QSettings;
import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QMouseEvent;
import java.util.ArrayList;
import java.util.List;
import timetabler.dialogs.CourseDialog;

public class Course extends QLabel {

  private String code;
  private String name;
  private int courseId;
  private Lecture lecture;
  private Seminar seminar;

  public Course(String code, String name, int courseId, Lecture lecture, Seminar seminar) {
    this.code = code;
    this.name = name;
    this.courseId = courseId;
    this.lecture = lecture;
    this.seminar = seminar;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
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

  public void setLectureVisibility(boolean isVisible) {
    QSettings settings = new QSettings();
    settings.setValue(code + "/lecture", isVisible);
  }
  
  public List<Teacher> getTeachers(){
    List<Teacher> teacherList = new ArrayList<Teacher>();
    
    if(lecture != null && lecture.getTerm() != null && lecture.getTerm().getTeacher() != null)
      teacherList.add(lecture.getTerm().getTeacher());
    
    if(seminar != null){
      List<Term> terms = seminar.getTerms();
      for(Term term : terms){
        if(term != null && term.getTeacher() != null)
          teacherList.add(term.getTeacher());
      }
    }
    
    return teacherList;
  }
  
  public void showSettings(){
    CourseDialog dialog = new CourseDialog(this);
    dialog.exec();
  }
  
  @Override
  protected void mouseDoubleClickEvent(QMouseEvent me){
    showSettings();
  }
}
