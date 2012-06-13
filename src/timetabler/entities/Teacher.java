package timetabler.entities;

import java.math.BigInteger;

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
    private BigInteger teacherId;

    public Teacher(String name, BigInteger teacherId) {
        this.name = name;
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(BigInteger teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Teacher other = (Teacher) obj;
        if (this.teacherId != other.teacherId && (this.teacherId == null || !this.teacherId.equals(other.teacherId))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + (this.teacherId != null ? this.teacherId.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return name;
    }
}
