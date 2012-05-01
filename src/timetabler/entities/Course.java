/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timetabler3000;

import java.util.List;

/**
 *
 * @author Enthas
 */
public class Course {
    
    private Integer code;
    private String name;
    private Integer courseId;
    private Lecture lecture;
    private List<Seminar> seminars;

    public Course(Integer code, String name, Integer courseId, Lecture lecture, List<Seminar> seminars) {
        this.code = code;
        this.name = name;
        this.courseId = courseId;
        this.lecture = lecture;
        this.seminars = seminars;
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

    public List<Seminar> getSeminars() {
        return seminars;
    }

    public void setSeminars(List<Seminar> seminars) {
        this.seminars = seminars;
    }
    
}
