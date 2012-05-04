package timetabler.entities;

/**
 * Holds information about teacher.
 * 
 * Holds teacher name and id.
 * 
 * @author Michal Kimle
 * @version 2012-05-04
 */
public class Teacher {
    
    private String name;
    private int teacherId;

    public Teacher(String name, int teacherId) {
        this.name = name;
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
    
}
