package timetabler.entities;

import com.trolltech.qt.core.QSettings;
import com.trolltech.qt.gui.QLabel;

public class Course extends QLabel{
    
    private Integer code;
    private String name;
    private Integer courseId;
    private Lecture lecture;
    private Seminar seminar;
    private QSettings settings;

    public Course(Integer code, String name, Integer courseId, Lecture lecture, Seminar seminar) {
        this.code = code;
        this.name = name;
        this.courseId = courseId;
        this.lecture = lecture;
        this.seminar = seminar;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
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

  public QSettings getSettings() {
    return settings;
  }

  public void setSettings(QSettings settings) {
    this.settings = settings;
  }
  
  public void setLectureVisibility(boolean isVisible){
    settings.setValue(code + "/lecture", isVisible);
  }
}
